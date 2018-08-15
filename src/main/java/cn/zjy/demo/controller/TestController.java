package cn.zjy.demo.controller;

import cn.zjy.demo.req.LoginReq;
import cn.zjy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        return userService.getUser(userId).toString();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private String logout(@RequestParam("userId") Integer userId) {
        return userService.getUser(userId).toString();
    }

    @RequestMapping(value = "/req", method = RequestMethod.POST)
    private String test(@RequestBody LoginReq loginReq) {
        return loginReq.toString();
    }

}
