package cn.zjy.demo.service.impl;

import cn.zjy.demo.dao.UserDao;
import cn.zjy.demo.handler.OperLogHandler;
import cn.zjy.demo.bean.model.User;
import cn.zjy.demo.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author ZJY
 * @ClassName: UserServiceImpl
 * @Description: UserServiceImpl
 * @date 2018/8/14 10:13
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private OperLogHandler operLogHandler;

    @Override
    public void threadPool() {
        log.debug("getUser...");
        operLogHandler.doAsync();
        log.debug("after operLog...");
    }

    @Override
    public List<User> queryAllUser() {
        return this.queryAllUser();
    }

    @Override
    public void modifyUserName(Integer userId, String name) {
        this.update(Wrappers.<User>lambdaUpdate().eq(User::getUserId, userId).set(User::getName, name));
    }
}
