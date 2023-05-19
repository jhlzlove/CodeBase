package jhlz.code.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 这些注解用在类上对类中所有 @Benchmark 的方法生效
 * JVM 会进行死代码消除，所以每个方法最好把需要测试的结果进行返回，或者使用 Blackhole 进行消费，从而使测试结果更加准确
 *
 * @author jhlz
 * @since 2023/5/19 11:11
 */
@Fork(1)
// Scope.Benchmark:所有工作线程将共享相同类型的所有实例
@State(Scope.Benchmark)
// 测量迭代 5 次，每次 1 s
@Measurement(time = 1, iterations = 5)
// 输出使用纳秒
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JmhTest {

    Blackhole blackhole;

    public static void main(String[] args) throws RunnerException, IOException {
        Options opt = new OptionsBuilder()
                .include(JmhTest.class.getSimpleName())
                .result("result.json")
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(opt).run();
    }

    @Param(value = {"100"})
    int length;

    @Benchmark
    public void buildAppend() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("雾切之回光" + i);
        }
        blackhole.consume(sb.toString());
    }

    @Benchmark
    public String bufferAppend() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append("雾切之回光" + i);
        }
        return sb.toString();
    }

    @Benchmark
    public String stringAppend() {
        String s = "";
        for (int i = 0; i < length; i++) {
            s = s + "雾切之回光" + i;
        }
        return s;
    }
}
