package cn.zjy.demo.service.impl;

import cn.zjy.demo.dao.OperateLogDao;
import cn.zjy.demo.bean.model.OperateLog;
import cn.zjy.demo.service.OperateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZJY
 * @ClassName: OperateLogServiceImpl
 * @Description: OperateLogServiceImpl
 * @date 2018/8/23 16:04
 */
@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogDao, OperateLog> implements OperateLogService {
    @Resource
    private OperateLogDao operateLogDao;

}
