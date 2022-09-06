package jhlz.code.utils.qrcodes.client;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jhlz
 * @time: 2022/9/6 下午3:10
 * @desc: UserClientUtil 客户端工具类
 */
public class UserClientUtil {

    /**
     * 客户端 user-agent
     *
     * @param request
     * @return
     */
    public static String getUserAgent(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        return userAgent;
    }

    /**
     * 客户端操作系统
     *
     * @param userAgent
     * @return 客户端操作系统
     */
    public static String getClientOS(final String userAgent) {
        // 操作系统
        String os = userAgent
                .substring(userAgent.indexOf(";"), userAgent.lastIndexOf(";")).replace(";", "").trim();
        return os;
    }

    /**
     * 客户端操作系统架构
     *
     * @param userAgent
     * @return 客户端操作系统架构
     */
    public static String getClientArch(final String userAgent) {
        // 操作系统
        String os = userAgent
                .substring(userAgent.indexOf(";"), userAgent.lastIndexOf(";")).replace(";", "").trim();
        return os.substring(os.indexOf(" ")).trim();
    }

    /**
     * 浏览器
     *
     * @param userAgent
     * @return 浏览器
     */
    public static String getBrowser(final String userAgent) {
        String sub = userAgent.substring(userAgent.indexOf("/"), userAgent.lastIndexOf("/"));
        // 浏览器类型
        String browser = sub.substring(sub.lastIndexOf(" ")).trim();
        return browser;
    }

    /**
     * 浏览器内核
     *
     * @param userAgent
     * @return 浏览器内核
     */
    public static String getBrowserKernel(final String userAgent) {
        // 浏览器内核
        String browserKernel = userAgent.substring(userAgent.lastIndexOf(")"), userAgent.lastIndexOf(" ")).replace(")", "").trim();
        return browserKernel;
    }

    /**
     * 浏览器版本
     *
     * @param userAgent
     * @return 浏览器版本
     */
    public static String getBrowserVersion(final String userAgent) {
        // 浏览器版本号
        String version = userAgent.substring(userAgent.lastIndexOf("/")).replace("/", "");
        return version;
    }


}
