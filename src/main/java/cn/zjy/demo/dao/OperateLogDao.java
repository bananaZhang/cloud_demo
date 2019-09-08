package cn.zjy.demo.dao;

import cn.zjy.demo.bean.model.OperateLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZJY
 * @ClassName: OperateLogDao
 * @Description: OperateLogDao
 * @date 2018/8/23 16:03
 */
@Mapper
public interface OperateLogDao extends BaseMapper<OperateLog> {

}
