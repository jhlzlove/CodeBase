package jhlz.code.feature.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Dish:
 *
 * @author jhlz
 * @since 2022/9/16 17:30:35
 */
@Data
@AllArgsConstructor
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type {
        MEAT,
        FISH,
        OTHER
    }
}
