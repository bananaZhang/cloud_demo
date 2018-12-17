package cn.zjy.demo.controller;

import cn.zjy.demo.controller.base.BaseController;
import cn.zjy.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/id/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") Integer userId) {
        return null;
    }
}
