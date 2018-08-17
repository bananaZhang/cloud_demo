package cn.zjy.demo.handler;

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
@Component
public class OperLogHandler {

    private static Logger logger = LoggerFactory.getLogger(OperLogHandler.class);

    @Async("singleThreadPool")
    public void doAsync() {
        logger.debug("start do task...");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.debug("end do task...");
    }

}
