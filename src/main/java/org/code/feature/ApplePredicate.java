package org.code.feature;

import org.code.feature.entity.Apple;

/**
 * 自定义函数式接口，注解不是必须的，使用它可以检查出你写的是不是函数式接口
 */
@FunctionalInterface
public interface ApplePredicate {
    String accept(Apple apple);
}
