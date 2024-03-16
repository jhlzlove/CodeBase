package org.code.feature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Test01:
 *
 * @author jhlz
 * @version 1
 * @since 2022/9/16 17:35:26
 */
public class Test01 {
    public static void main(String[] args) {
        String[] array = {"诗酒趁年华", "酒不醉人人自醉"};
        Stream<String> strList = Arrays.stream(array);
        // 检查组成数组的字符有哪些
        System.out.println(strList.map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));

        List<Integer> numList01 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numList02 = Arrays.asList(7, 8);

        // 两个流可以组成的元组
        System.out.println(numList01.stream().map(n -> n * n).collect(Collectors.toList()));

        // iterate 创建无限流
        Stream.iterate(new int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]})
                .limit(10)
                .forEach(a -> System.out.println("(" + a[0] + ", " + a[1] + ")"));
        // 获取斐波那契数列
        Stream.iterate(new int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]})
                .limit(10)
                .map(a -> a[0])
                .forEach(System.out::println);
    }
}
