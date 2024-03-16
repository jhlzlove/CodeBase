package org.code.feature.sealed;

/**
 * 声明为密封类的实现必须有自己的子类实现，若其子类如果仍然是密封类，说明由下游调用方继续提供密封保障，则继续向下扩展
 *
 * @author jhlz
 * @version x.x.x
 * @since 2024/3/16 15:14
 */
public sealed class OtherService implements PayInterface permits OtherServiceImpl {
    @Override
    public int pay() {
        return 0;
    }

    @Override
    public String getMark() {
        return null;
    }
}
