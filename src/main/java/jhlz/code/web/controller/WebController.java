package jhlz.code.web.controller;

import jhlz.code.utils.client.UserClientUtil;
import jhlz.code.web.entity.Client;
import jhlz.code.web.entity.UserModel;
import jhlz.code.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

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

    @RequestMapping("postgres")
    public void testPostgres() {
        UserModel user = new UserModel().setId(123L).setName("风中捉刀").setBirthday(LocalDateTime.now()).setSex(true);
        userService.save(user);
        System.out.println(userService.list());
    }

    private final UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;
    }
}
