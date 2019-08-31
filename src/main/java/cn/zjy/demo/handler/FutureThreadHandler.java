package cn.zjy.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author ZJY
 * @ClassName: FutureThreadHandler
 * @Description: FutureThreadHandler
 * @date 2019/1/28 17:32
 */
@Slf4j
@Component
public class FutureThreadHandler {

    @Async("testFutureThreadPool")
    public Future<String> genAndUpload(String param) {
//        log.debug("futureTask start..., param:{}", param);
        Random random = new Random();
        try {
            Thread.sleep((random.nextInt(5) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        log.debug("futureTask end..., param:{}", param);
        return new AsyncResult<>(param + "success");
    }
}
