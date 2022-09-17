import jhlz.code.feature.entity.Apple;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * FeatureTest:
 *
 * @author jhlz
 * @since 2022/9/16 17:13:37
 */
public class FeatureTest {
    /**
     * test：Lambda用例
     */
    @Test
    public void testAppleWeight() {
        // 构建列表
        List<Apple> list = Arrays.asList(
                new Apple("red", 280.0),
                new Apple("green", 120.6),
                new Apple("yellow", 1.2));
        System.out.println(filter(list, Apple::isHeavyApple));

    }

    public <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
