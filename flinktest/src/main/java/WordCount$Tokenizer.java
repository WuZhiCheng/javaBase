
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public final class WordCount$Tokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {
    public WordCount$Tokenizer() { }

    public void flatMap(String value, Collector<Tuple2<String, Integer>> out) {
        String[] tokens = value.toLowerCase().split("\\W+");
        String[] var4 = tokens;
        int var5 = tokens.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String token = var4[var6];
            if (token.length() > 0) {
                out.collect(new Tuple2(token, 1));
            }
        }
    }
}
