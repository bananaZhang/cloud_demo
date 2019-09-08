package cn.zjy.demo.controller;

import cn.zjy.demo.common.annotation.OperationLog;
import cn.zjy.demo.controller.base.BaseController;
import cn.zjy.demo.bean.model.User;
import cn.zjy.demo.service.UserService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZJY
 * @ClassName: UserController
 * @Description: UserController
 * @date 2018/11/15 15:55
 */
@RestController
@RequestMapping("/demo/user")
@Slf4j
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @OperationLog(module = "LOGIN")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody JSONObject jsonObject) {
        Integer userId = jsonObject.getInteger("userId");
        log.debug("token = {}", token.get());
        return userService.getById(userId);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public User logout(@RequestBody JSONObject jsonObject) {
        Integer userId = jsonObject.getInteger("userId");
        return userService.getById(userId);
    }
}
