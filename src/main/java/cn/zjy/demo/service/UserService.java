package cn.zjy.demo.service;

import cn.zjy.demo.bean.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author ZJY
 * @ClassName: UserService
 * @Description: UserService
 * @date 2018/8/1 14:33
 */
public interface UserService extends IService<User> {

    void threadPool();

    List<User> queryAllUser();

    void modifyUserName(Integer userId, String name);

}
