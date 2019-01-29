package cn.zjy.demo.controller;

import cn.zjy.demo.controller.base.BaseController;
import cn.zjy.demo.model.User;
import cn.zjy.demo.req.OrgUserAddReq;
import cn.zjy.demo.service.EhcacheService;
import cn.zjy.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZJY
 * @ClassName: TestController
 * @Description: TestController
 * @date 2018/7/24 11:36
 */
@RestController
@RequestMapping("/demo/test")
@Slf4j
public class TestController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private EhcacheService ehcacheService;

    /**
     * 可通过@RequestHeader获取请求header中的值
     * 可通过@CookieValue获取Cookie中的值
     */
    @RequestMapping(value = "/anno", method = RequestMethod.POST)
    public String testAnnotationGetToken(@RequestHeader("token") String headToken) {
        log.debug(headToken);
        return "success";
    }

    /**
     * @function 测试请求类中的内部类能不能映射到
     * @author ZJY 2018/10/29 20:01
     */
    @RequestMapping(value = "/inner", method = RequestMethod.POST)
    public String testInnerClassReq(@RequestBody OrgUserAddReq req) {
        System.out.println(req);
        return "success";
    }

    @RequestMapping(value = "/map", method = RequestMethod.POST)
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("111", "A");
        map.put("222", "B");
        return map;
    }

    @RequestMapping(value = "/cache/all", method = RequestMethod.POST)
    public List<User> testGetEhcache() {
        return ehcacheService.getUsersFromCache();
    }

    @RequestMapping(value = "/cache/clear", method = RequestMethod.POST)
    public void testClearEhcache() {
        ehcacheService.clearAllCache();
    }

    @RequestMapping(value = "/cache/get/{mobile}", method = RequestMethod.POST)
    public void testGetParam(@PathVariable(name = "mobile") String mobile) {
        ehcacheService.searchCacheWithParam(mobile);
    }
}
