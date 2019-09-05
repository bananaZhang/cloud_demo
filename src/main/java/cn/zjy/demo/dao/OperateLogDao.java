package cn.zjy.demo.dao;

import cn.zjy.demo.bean.model.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @author ZJY
 * @ClassName: OperateLogDao
 * @Description: OperateLogDao
 * @date 2018/8/23 16:03
 */
@Mapper
@Service
public interface OperateLogDao {

    int save(OperateLog operateLog);
}
