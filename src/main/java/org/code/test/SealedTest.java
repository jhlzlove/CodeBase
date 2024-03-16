package org.code.test;

import org.code.feature.sealed.AlipayService;

/**
 * @author jhlz
 * @version x.x.x
 * @since 2024/3/16 15:11
 */
public class SealedTest {

    public static void main(String[] args) {
        AlipayService alipayService = new AlipayService();
        System.out.println(alipayService.getMark());
    }

}
