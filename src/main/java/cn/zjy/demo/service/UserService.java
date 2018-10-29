package cn.zjy.demo.service;

import cn.zjy.demo.domain.User;

import java.util.List;

/**
 * @author ZJY
 * @ClassName: UserService
 * @Description: UserService
 * @date 2018/8/1 14:33
 */
public interface UserService {

    public User getUser(Integer userId);

	void threadPool();

	List<User> queryAllUser();

	int modifyUserName(Integer userId, String name);

	int addUser(User user);

	User getUserByMobile(String mobile);
}
