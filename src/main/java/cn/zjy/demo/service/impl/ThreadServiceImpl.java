package cn.zjy.demo.service.impl;

import cn.zjy.demo.handler.FutureThreadHandler;
import cn.zjy.demo.handler.OperLogHandler;
import cn.zjy.demo.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ZJY
 * @ClassName: ThreadServiceImpl
 * @Description: ThreadServiceImpl
 * @date 2019/1/28 18:49
 */
@Slf4j
@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private OperLogHandler operLogHandler;
    @Autowired
    private FutureThreadHandler futureThreadHandler;

    @Override
    public void threadPool() {
        log.debug("getUser...");
        operLogHandler.doAsync();
        log.debug("after operLog...");
    }

    @Override
    public void futureThreadPool() {
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            Future<String> result = futureThreadHandler.genAndUpload(String.valueOf(i));
            results.add(result);
        }
        try {
            int n = 0;
            for (Future<String> result : results) {
                log.debug(result.get());
                n++;
                log.debug("循环次数" + n);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
