package org.code.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author jhlz
 * @version x.x.x
 */
@ToString
@Data
public class Ac {
    String name;
    Integer value;

    public Ac(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
