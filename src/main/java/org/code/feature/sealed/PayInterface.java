package org.code.feature.sealed;

/**
 * 顶级密封类接口，密封接口和它的实现需要在同一包中
 *
 * @author jhlz
 * @version x.x.x
 * @since 2024/3/16 15:03
 */
public sealed interface PayInterface permits AlipayService, WeChatService, OtherService {

    int pay();

    String getMark();
}
