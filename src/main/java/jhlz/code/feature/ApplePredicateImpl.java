package jhlz.code.feature;

import jhlz.code.entity.Apple;

/**
 * ApplePredicateImpl: 函数式接口实现
 *
 * @author jhlz
 * @since 2022/9/13 16:03:19
 */
public class ApplePredicateImpl implements ApplePredicate {

    @Override
    public String accept(Apple apple) {
        return "heavy " + apple.getWeight() + ", color is " + apple.getColor();
    }
}
