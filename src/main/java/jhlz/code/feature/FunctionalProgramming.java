package jhlz.code.feature;

import jhlz.code.entity.Apple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
     * 使用具体类型
     *
     * @param inventory
     * @param p
     * @return
     */
    static List<Apple> filterApples(List<Apple> inventory,
                                    Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
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

        Apple apple01 = new Apple("red", 280.0);
        Apple apple02 = new Apple("green", 120.6);
        Apple apple03 = new Apple("yellow", 1.2);

        List<Apple> list = new ArrayList<>();
        list.add(apple01);
        list.add(apple02);
        list.add(apple03);
        // 调用输出
        prettyPrint(list, new ApplePredicateImpl());
        System.out.println(filter(list, Apple::isGreenApple));
    }
}
