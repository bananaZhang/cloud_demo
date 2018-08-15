package cn.zjy.demo.service.impl;

import cn.zjy.demo.dao.UserDao;
import cn.zjy.demo.domain.User;
import cn.zjy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZJY
 * @ClassName: UserServiceImpl
 * @Description: UserServiceImpl
 * @date 2018/8/14 10:13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Integer userId) {
        System.out.println("getUser");
        return new User();
    }
}
