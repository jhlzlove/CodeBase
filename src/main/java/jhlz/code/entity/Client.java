package jhlz.code.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jhlz
 * @time: 2022/9/6 下午3:35
 * @desc: Client
 */
@Data
@Accessors(chain = true)
public class Client {

    private String userAgent;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 浏览器版本号
     */
    private String browserVersion;

    /**
     * 浏览器内核
     */
    private String browserKernel;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 操作系统架构
     */
    private String arch;
}
