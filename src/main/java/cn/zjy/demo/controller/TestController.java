package cn.zjy.demo.controller;

import cn.zjy.demo.common.annotation.OperationLog;
import cn.zjy.demo.domain.User;
import cn.zjy.demo.req.OrgUserAddReq;
import cn.zjy.demo.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private HttpServletRequest request;

    private ThreadLocal<String> token = new ThreadLocal<>();

    /**
     * 会在进入其他方法之前调用这个init方法
     */
    @ModelAttribute
    public void init() {
        token.set(request.getHeader("token"));
    }

    @OperationLog(module = "LOGIN")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody JSONObject jsonObject) {
        Integer userId = jsonObject.getInteger("userId");
        logger.debug("token = {}", token.get());
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

    /**
     * 可通过@RequestHeader获取请求header中的值
     * 可通过@CookieValue获取Cookie中的值
     */
    @RequestMapping(value = "/anno", method = RequestMethod.POST)
    public String testAnnotationGetToken(@RequestHeader("token") String headToken) {
        logger.debug(headToken);
        return "success";
    }

    @RequestMapping(value = "/thread")
    public String threadTest() {
		userService.threadPool();
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
}
