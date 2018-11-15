package cn.zjy.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ZJY
 * @ClassName: OperLogHandler
 * @Description: OperLogHandler
 * @date 2018/8/17 15:13
 */
@Slf4j
@Component
public class OperLogHandler {

    /**
     * 方法加上Async即可使用线程池
     */
    @Async("testThreadPool")
    public void doAsync() {
        log.debug("start do task...");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("end do task...");
    }

}
