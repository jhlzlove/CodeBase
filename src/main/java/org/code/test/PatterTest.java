package org.code.test;

import org.code.feature.Gender;

/**
 * @author jhlz
 * @version x.x.x
 * @since 2024/3/16 14:49
 */
public class PatterTest {

    public static void main(String[] args) {
        System.out.println(getGender(Gender.FEMALE));
    }

    static String getGender(Gender gender) {
        return switch (gender) {
            case MALE -> "this is male";
            case FEMALE -> "she is female";
            case UNKNOWN -> "UNKNOWN";
            case null, default -> "";
        };
    }
}
