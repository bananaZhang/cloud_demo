package cn.zjy.demo.dao;

import cn.zjy.demo.bean.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZJY
 * @ClassName: UserDao
 * @Description: UserDao
 * @date 2018/8/1 14:26
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
