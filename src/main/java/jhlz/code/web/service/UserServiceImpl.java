package jhlz.code.web.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jhlz.code.web.entity.UserModel;
import jhlz.code.web.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author: jhlz
 * @since: 2022/10/23 21:54:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements UserService {

}
