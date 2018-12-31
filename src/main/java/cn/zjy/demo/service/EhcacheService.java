package cn.zjy.demo.service;

import cn.zjy.demo.model.User;

import java.util.List;

public interface EhcacheService {
    List<User> getUsersFromCache();
}
