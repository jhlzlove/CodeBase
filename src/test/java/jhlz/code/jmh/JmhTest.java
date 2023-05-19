package jhlz.code;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;

/**
 * @author jhlz
 * @since 2023/5/19 11:11
 */
@State(Scope.Benchmark)
public class JmhTest {
    public static void main(String[] args) throws RunnerException, IOException {
        Options opt = new OptionsBuilder().include(JmhTest.class.getSimpleName())
                .result("result.json")
                .resultFormat(ResultFormatType.JSON).build();

        new Runner(opt).run();
        // org.openjdk.jmh.Main.main(args);
    }

    @Param(value = {"100"})
    int length;

    @Benchmark
    public void buildAppend() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("雾切之回光" + i);
        }
    }

    @Benchmark
    public void bufferAppend() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append("雾切之回光" + i);
        }
    }

    @Benchmark
    public void stringAppend() {
        String s = "";
        for (int i = 0; i < length; i++) {
            s = s + "雾切之回光" + i;
        }
    }
}
