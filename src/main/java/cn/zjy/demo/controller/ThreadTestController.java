package cn.zjy.demo.controller;

import cn.zjy.demo.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZJY
 * @ClassName: ThreadTestController
 * @Description: ThreadTestController
 * @date 2019/1/28 18:40
 */
@RestController
@RequestMapping("/demo/thread")
@Slf4j
public class ThreadTestController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping(value = "/test")
    public String threadTest() {
        threadService.threadPool();
        return "success";
    }

    @RequestMapping(value = "/future")
    public String futureThreadTest() {
        threadService.futureThreadPool();
        return "success";
    }
}
