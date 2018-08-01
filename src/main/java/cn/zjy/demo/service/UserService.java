package cn.zjy.demo.service;

import cn.zjy.demo.dao.UserDao;
import cn.zjy.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZJY
 * @ClassName: UserService
 * @Description: UserService
 * @date 2018/8/1 14:33
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUser(Integer userId) {
        return userDao.findByUserId(userId);
    }

}
