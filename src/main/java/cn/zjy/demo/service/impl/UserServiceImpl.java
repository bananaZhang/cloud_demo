package cn.zjy.demo.service.impl;

import cn.zjy.demo.dao.UserDao;
import cn.zjy.demo.domain.User;
import cn.zjy.demo.handler.OperLogHandler;
import cn.zjy.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Integer userId) {
        logger.debug("getUser...");
        new OperLogHandler().doAsync();
        return new User();
    }
}
