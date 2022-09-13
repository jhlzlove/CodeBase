package jhlz.code.entity;

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

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static boolean accept() {
        return true;
    }
}
