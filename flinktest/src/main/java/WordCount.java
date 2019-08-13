//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class WordCount {

    public static void main(String[] args) throws Exception {
        ParameterTool params = ParameterTool.fromArgs(args);
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().setGlobalJobParameters(params);
        DataStreamSource text;
        if (params.has("input")) {
            text = env.readTextFile(params.get("input"));
        } else {
            System.out.println("Executing WordCount example with default input data set.");
            System.out.println("Use --input to specify file input.");
//          text = env.fromElements("To be, or not to be,--that is the question:--");
            text = env.fromElements(WordCountData.WORDS);
        }
        DataStream<Tuple2<String, Integer>> counts =
                text.flatMap(new WordCount$Tokenizer()).keyBy(new int[]{0}).sum(1);
//                text.flatMap(new WordCount$Tokenizer()).keyBy(new int[]{0}).countWindow(5,1).sum(1);
//        counts.writeAsText("D:\\wordcount.out");
        if (params.has("output")) {
            counts.writeAsText(params.get("output"));
        } else {
            System.out.println("Printing result to stdout. Use --output to specify output path.");
            counts.print();
        } 
        env.execute("Streaming WordCount");
    }
}
