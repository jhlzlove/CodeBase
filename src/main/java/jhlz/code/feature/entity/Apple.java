package jhlz.code.feature.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jhlz
 * @since 2022/9/12 19:40:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {
    private String color;
    private Double weight;

    /**
     * 思考一下，为什么 这里 使用 static 呢？
     * 很简单，不写编译器直接报错。非静态引用在静态上下文中是不能使用的
     *
     * @param apple
     * @return
     */
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

}
