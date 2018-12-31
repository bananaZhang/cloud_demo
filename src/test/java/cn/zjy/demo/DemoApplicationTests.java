package cn.zjy.demo;

import cn.zjy.demo.model.User;
import cn.zjy.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;


    @Before
    public void prepareData() {
//        User user = new User();
//        user.setMobile("110110110");
//        user.setName("test user");
//        user.setEmail("123@qq.com");
//        user.setOtherContact("123");
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());
//        user.setStatus(1);
//
//        userService.addUser(user);
    }

    @Transactional
    @Test
    public void addUser() {
        User user = userService.getUserByMobile("110110110");
        System.out.println(user);
    }

    @Transactional
    @Test
    public void queryAllUser() {
        List<User> userList = userService.queryAllUser();
        userList.sort((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime()));

        System.out.println(userList);
    }

}
