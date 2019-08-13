import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class SocketWindowWordCount {

    //需要加载flink的lib目录下的jar 否则报错java.lang.NoClassDefFoundError: org/apache/flink/streaming/api/datastream/DataStream
//    https://blog.csdn.net/weixin_38842096/article/details/85723335?spm=a2c4e.11153987.0.0.43c833c3bHViwn
  /*  https://www.jianshu.com/p/11b7d5eba08c
  *  nc -l 9000
对应window命令为：nc -l -p 9000
  * */

    public static void main(String[] args) throws Exception {
        // the port to connect to
        final int port = 10991;
//        try {
//            final ParameterTool params = ParameterTool.fromArgs(args);
//            port = params.getInt("port");
//        } catch (Exception e) {
//            System.err.println("No port specified. Please run 'SocketWindowWordCount --port <port>'");
//            return;
//        }

        // get the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // get input data by connecting to the socket
        DataStream<String> text = env.socketTextStream("localhost", port, "\n");

        // parse the data, group it, window it, and aggregate the counts
        DataStream<WordWithCount> windowCounts = text
                .flatMap(new FlatMapFunction<String, WordWithCount>() {
                    public void flatMap(String value, Collector<WordWithCount> out) {
                        for (String word : value.split("\\s")) {
                            out.collect(new WordWithCount(word, 1L));
                        }
                    }
                })
                .keyBy("word")
                // 5秒一统计，1秒计算一次，超过5秒的数据不进行计算，5秒内一直有数据输入，则每隔一秒进行计算一次，超过5秒没数据就停止计算（窗口的宽度与滑动的时间片）
                //  计算最近5秒的数据
                .timeWindow(Time.of(5,TimeUnit.SECONDS), Time.seconds(1))
                .reduce(new ReduceFunction<WordWithCount>() {
                    public WordWithCount reduce(WordWithCount a, WordWithCount b) {
                        return new WordWithCount(a.word, a.count + b.count);
                    }
                });

        // print the results with a single thread, rather than in parallel
        windowCounts.print().setParallelism(1);

        env.execute("Socket Window WordCount");
    }

    // Data type for words with count
    public static class WordWithCount {

        public String word;
        public long count;

        public WordWithCount() {
        }

        public WordWithCount(String word, long count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return word + " : " + count;
        }
    }


}