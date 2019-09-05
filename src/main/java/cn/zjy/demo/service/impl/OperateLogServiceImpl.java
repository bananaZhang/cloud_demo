package cn.zjy.demo.service.impl;

import cn.zjy.demo.dao.OperateLogDao;
import cn.zjy.demo.bean.model.OperateLog;
import cn.zjy.demo.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZJY
 * @ClassName: OperateLogServiceImpl
 * @Description: OperateLogServiceImpl
 * @date 2018/8/23 16:04
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Autowired
    private OperateLogDao operateLogDao;

    @Override
    public int save(OperateLog operateLog) {
        return this.operateLogDao.save(operateLog);
    }
}
