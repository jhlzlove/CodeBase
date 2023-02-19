package jhlz.code;

import java.util.concurrent.locks.ReentrantLock;

/**
 * jhlz.code.JDKTest:
 *
 * @author jhlz
 * @since 2022/9/14 19:25:21
 */
public class JDKTest {
    /**
     * test：MathRound用例
     */
    // @Test
    public void testMathRound() {
        new ReentrantLock(true);
        System.out.println(2 << 3);
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(11.4));
        System.out.println(Math.round(-11.5));
    }

}
