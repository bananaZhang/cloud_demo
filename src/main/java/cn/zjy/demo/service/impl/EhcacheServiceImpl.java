package cn.zjy.demo.service.impl;

import cn.zjy.demo.dao.UserDao;
import cn.zjy.demo.model.User;
import cn.zjy.demo.service.EhcacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class EhcacheServiceImpl implements EhcacheService {

    @Autowired
    private UserDao userDao;

    @Cacheable
    @Override
    public List<User> getUsersFromCache() {
        return userDao.queryAll();
    }
}
