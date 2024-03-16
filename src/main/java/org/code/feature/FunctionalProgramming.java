package org.code.feature;

import org.code.feature.entity.Apple;

import java.util.*;
import java.util.function.Predicate;

/**
 * FunctionalProgramming: 函数式编程实践
 *
 * @author jhlz
 * @since 2022/9/12 19:42:39
 */
public class FunctionalProgramming<T> {

    /**
     * 使用泛型
     *
     * @param c
     * @param p
     * @param <T>
     * @return
     */
    static <T> Collection<T> filter(Collection<T> c, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : c) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * 格式化打印
     *
     * @param inventory
     * @param p
     */
    static void prettyPrint(List<Apple> inventory,
                            ApplePredicate p) {
        for (Apple apple : inventory) {
            String accept = p.accept(apple);
            System.out.println(accept);
        }
    }

    public static void main(String[] args) {
        // 构建列表
        List<Apple> list = Arrays.asList(
                new Apple("red", 280.0),
                new Apple("green", 120.6),
                new Apple("yellow", 1.2));
        // ##################### test start ######################
        // 调用输出
        prettyPrint(list, new ApplePredicateImpl());
        System.out.println(filter(list, Apple::isGreenApple));

        // 根绝颜色进行排序
        list.sort(Comparator.comparing(Apple::getColor));
        System.out.println("after sorted by list" + list);
    }
}
