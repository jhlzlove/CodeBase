import jhlz.code.CodeBaseApplication;
import jhlz.code.web.entity.UserModel;
import jhlz.code.web.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author: jhlz
 * @since: 2022/10/23 22:00:04
 */
@SpringBootTest(classes = CodeBaseApplication.class)
public class SpringTest {

    private final UserMapper userMapper;

    public SpringTest(UserMapper userService) {
        this.userMapper = userService;
    }

    /**
     * test: postgres connect example
     */
    @Test
    public void testConnect() {
        UserModel user = new UserModel().setId(123L).setName("风中捉刀").setBirthday(LocalDateTime.now()).setSex(true);
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(userMapper.selectList(null));
    }
}
