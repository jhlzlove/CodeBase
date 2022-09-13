package jhlz.code.feature;

import jhlz.code.entity.Apple;

/**
 * 函数式接口
 */
public interface ApplePredicate {
    String accept(Apple apple);
}
