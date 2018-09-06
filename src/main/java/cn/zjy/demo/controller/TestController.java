package cn.zjy.demo.controller;

import cn.zjy.demo.common.annotation.OperationLog;
import cn.zjy.demo.domain.User;
import cn.zjy.demo.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZJY
 * @ClassName: TestController
 * @Description: TestController
 * @date 2018/7/24 11:36
 */
@RestController
@RequestMapping("/demo/test")
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserService userService;

    @OperationLog(module = "LOGIN")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody JSONObject jsonObject) {
        Integer userId = jsonObject.getInteger("userId");
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public User logout(@RequestBody JSONObject jsonObject) {
        Integer userId = jsonObject.getInteger("userId");
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public List<User> getUserList() {
        return userService.queryAllUser();
    }

    @RequestMapping(value = "/thread")
    public String threadTest() {
		userService.threadPool();
		return "success";
    }
}
