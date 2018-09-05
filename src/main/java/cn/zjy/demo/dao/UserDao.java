package cn.zjy.demo.dao;

import cn.zjy.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZJY
 * @ClassName: UserDao
 * @Description: UserDao
 * @date 2018/8/1 14:26
 */
@Mapper
@Service
public interface UserDao {
    User queryUserByUserId(@Param("userId") Integer userId);

    User queryUserByMobile(@Param("mobile") String mobile);

    List<User> queryAll();

    int updateUser(User user);
}
