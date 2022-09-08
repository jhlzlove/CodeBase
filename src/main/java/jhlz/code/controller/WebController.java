package jhlz.code.controller;

import jhlz.code.entity.Client;
import jhlz.code.utils.qrcodes.client.UserClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jhlz
 * @time: 2022/9/6 下午3:19
 * @desc: WebController
 */
@RestController
public class WebController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @GetMapping("test")
    public Client test(HttpServletRequest request) {
        String userAgent = UserClientUtil.getUserAgent(request);
        Client client = new Client();
        client.setUserAgent(userAgent)
                .setOs(UserClientUtil.getClientOS(userAgent))
                .setArch(UserClientUtil.getClientArch(userAgent))
                .setBrowserVersion(UserClientUtil.getBrowserVersion(userAgent))
                .setBrowser(UserClientUtil.getBrowser(userAgent))
                .setBrowserKernel(UserClientUtil.getBrowserKernel(userAgent));
        return client;
    }
}
