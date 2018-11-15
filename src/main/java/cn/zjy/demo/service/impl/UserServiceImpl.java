package cn.zjy.demo.service.impl;

import cn.zjy.demo.dao.UserDao;
import cn.zjy.demo.domain.User;
import cn.zjy.demo.handler.OperLogHandler;
import cn.zjy.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author ZJY
 * @ClassName: UserServiceImpl
 * @Description: UserServiceImpl
 * @date 2018/8/14 10:13
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private OperLogHandler operLogHandler;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User getUser(Integer userId) {


        User user = userDao.queryUserByUserId(userId);// 事务提交后才会释放锁，且不会阻塞整表查询（读的是更新前的数据）

	    user.setName("测试");user.toString();
	    userDao.updateUser(user);

        log.debug("start sleep...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("end sleep...");
        return user;
    }

    @Override
    public void threadPool() {
        log.debug("getUser...");
        operLogHandler.doAsync();
        log.debug("after operLog...");
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAll();
    }

    @Override
    public int modifyUserName(Integer userId, String name) {
        User user = userDao.queryUserByUserId(userId);
        user.setName(name);
        return userDao.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUserByMobile(String mobile) {
        return userDao.queryUserByMobile(mobile);
    }
}
