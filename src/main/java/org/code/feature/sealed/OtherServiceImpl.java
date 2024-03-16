package org.code.feature.sealed;

/**
 * 向下扩展一层，如果子类还需要继续扩展，则继续使用 sealed 声明
 * 到 final 时说明子类已经完成密封扩展
 *
 * @author jhlz
 * @version x.x.x
 * @since 2024/3/16 15:17
 */
public final class OtherServiceImpl extends OtherService {
}
