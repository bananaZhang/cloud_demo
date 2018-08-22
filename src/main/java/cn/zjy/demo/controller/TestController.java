package cn.zjy.demo.controller;

import cn.zjy.demo.domain.User;
import cn.zjy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZJY
 * @ClassName: TestController
 * @Description: TestController
 * @date 2018/7/24 11:36
 */
@RestController
@RequestMapping("/demo/test")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login(@RequestParam("userId") Integer userId) {
        return userService.getUser(userId);
    }
}
