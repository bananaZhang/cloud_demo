package cn.zjy.demo.service.impl;

import cn.zjy.demo.dao.UserDao;
import cn.zjy.demo.bean.model.User;
import cn.zjy.demo.service.EhcacheService;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Cacheable：在调用方法之前，首先应该在缓存中查找方法的返回值，如果这个值能够找到，就会返回缓存的值。
 * 否则，这个方法就会被调用，返回值会放到缓存之中。
 * CachePut：将方法的返回值放到缓存中。在方法的调用前并不会检查缓存，方法始终都会被调用。
 * CacheEvict：在缓存中清除一个或多个条目。
 * Caching：分组的注解，能够同时应用多个其他的缓存注解。
 * @author: ZJY
 * @date: 2018/12/31 下午10:49
 */
@Service
@Slf4j
public class EhcacheServiceImpl implements EhcacheService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CacheManager cacheManager;

    /**
     * Cacheable有三个属性：value、key、condition
     * value：cache的名称
     * key：自定义策略，支持springEL表达式
     * condition：指定缓存的条件
     */
    @Cacheable(value = "userCache")
    @Override
    public List<User> getUsersFromCache() {
        log.info("缓存未命中，从db查询...");
        return userDao.queryAll();
    }

    /**
     * allEntries：是否需要清除缓存中的所有元素，为true时忽略指定的key
     */
    @CacheEvict(value = "userCache", allEntries = true, beforeInvocation = true)
    @Override
    public void clearAllCache() {
        log.info("clear cache success...");
    }

    @Override
    public void searchCacheWithParam(String mobileParam) {
        Cache userCache = cacheManager.getCache("userCache");
        Attribute<String> mobile = userCache.getSearchAttribute("mobile");

        //-----------------------
        User user1 = new User(1, "15111111111", "hehe", "123@qq.com", 15,
                "1234", new Date(), new Date(), 1);

        User user2 = new User(2, "15111111110", "heihei", "123@qq.com", 25,
                "5678", new Date(), new Date(), 1);

        User user3 = new User(3, "15111111112", "xixi", "123@qq.com", 25,
                "9012", new Date(), new Date(), 1);

        Element element = new Element(user1.getUserId(), user1);
        userCache.putIfAbsent(element);
        element = new Element(user2.getUserId(), user2);
        userCache.putIfAbsent(element);
        element = new Element(user3.getUserId(), user3);
        userCache.putIfAbsent(element);
        //-----------------------

        // 创建一个查询对象
        Query query = userCache.createQuery();
        query.addCriteria(mobile.eq(mobileParam));

//        query.includeAttribute(mobile);

        // 查询结果包括key和value
        Results results = query.includeKeys().includeValues().execute();
        for (Result result : results.all()) {
//            //结果中包含key时可以获取key
//            if (results.hasKeys()) {
//                result.getKey();
//            }
//            //结果中包含value时可以获取value
//            if (results.hasValues()) {
//                result.getValue();
//            }
//            //结果中包含属性时可以获取某个属性的值
//            if (results.hasAttributes()) {
//                Attribute<String> attribute = userCache.getSearchAttribute("name");
//                result.getAttribute(attribute);
//            }
//            //结果中包含统计信息时可以获取统计信息组成的List
//            if (results.hasAggregators()) {
//                result.getAggregatorResults();
//            }
            log.debug(result.toString());
        }
    }
}
