package cn.zjy.demo.dao;

import cn.zjy.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

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
}
