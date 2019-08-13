package socket;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 17:17 2019/8/12 0012
 * @company:北京今汇在线
 */
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;


public class WindowWordCount2 {


        public static void main(String[] args) throws Exception {

            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

            DataStream<Tuple2<String, Integer>> dataStream = env
                    .socketTextStream("localhost", 9999)
                    .flatMap(new Splitter())
                    .keyBy(0)
                    .timeWindow(Time.seconds(5))
                    .sum(1);

            dataStream.print();

            env.execute("Window WordCount");
        }

        public static class Splitter implements FlatMapFunction<String, Tuple2<String, Integer>> {

            public void flatMap(String sentence, Collector<Tuple2<String, Integer>> out) throws Exception {
                for (String word: sentence.split(" ")) {
                    out.collect(new Tuple2<String, Integer>(word, 1));
                }
            }
        }

    }
