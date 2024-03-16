package org.code.feature.sealed;

/**
 * 密封接口的实现类可以设置为 final，该类不能被继承，即可以不需要声明子类
 *
 * @author jhlz
 * @version x.x.x
 * @since 2024/3/16 15:09
 */
public final class WeChatService implements PayInterface {
    @Override
    public int pay() {
        return 0;
    }

    @Override
    public String getMark() {
        return "wechat";
    }
}
