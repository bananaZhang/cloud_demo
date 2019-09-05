package cn.zjy.demo.service;

import cn.zjy.demo.bean.model.User;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

public interface EhcacheService {
    List<User> getUsersFromCache();

    @CacheEvict(value = "userCache", allEntries = true, beforeInvocation = true)
    void clearAllCache();

    void searchCacheWithParam(String mobileParam);
}
