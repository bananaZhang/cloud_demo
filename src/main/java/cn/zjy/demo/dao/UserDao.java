package cn.zjy.demo.dao;

import cn.zjy.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ZJY
 * @ClassName: UserDao
 * @Description: UserDao
 * @date 2018/8/1 14:26
 */
@Mapper
public interface UserDao {
    @Select("Select * From demo_user Where user_id = #{userId}")
    User findByUserId(@Param("userId") Integer userId);
}
