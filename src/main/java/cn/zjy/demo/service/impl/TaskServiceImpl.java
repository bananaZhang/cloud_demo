package cn.zjy.demo.service.impl;

import cn.zjy.demo.dao.TaskDao;
import cn.zjy.demo.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public void compareMemoryAndInnodb() {
        Date startTime = new Date();
        for (int i = 0; i < 100; i ++) {
            taskDao.queryByMemory();
        }
        log.info("memory 100次耗时: " + (new Date().getTime() - startTime.getTime()));

        startTime = new Date();
        for (int i = 0; i < 100; i ++) {
            taskDao.queryByInnodb();
        }
        log.info("innodb 100次耗时: " + (new Date().getTime() - startTime.getTime()));

    }
}
