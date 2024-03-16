package org.code.feature.sealed;

/**
 * 实现类可以声明为非密封
 *
 * @author jhlz
 * @version x.x.x
 * @since 2024/3/16 15:04
 */
public non-sealed class AlipayService implements PayInterface {
    @Override
    public int pay() {
        return 0;
    }

    @Override
    public String getMark() {
        return "ali";
    }
}
