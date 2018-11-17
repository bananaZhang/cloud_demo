package cn.zjy.demo.common.aop;

import cn.zjy.demo.common.annotation.OperationLog;
import cn.zjy.demo.model.OperateLog;
import cn.zjy.demo.service.OperateLogService;
import cn.zjy.demo.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author ZJY
 * @ClassName: OperationLogAspect
 * @Description: OperationLogAspect
 * @date 2018/8/22 20:16
 */
@Aspect
@Component
@Slf4j
public class OperationLogAspect {

    @Autowired
    private OperateLogService operateLogService;

    // 在@OperationLog注解的地方进行日志记录
    @Pointcut("@annotation(cn.zjy.demo.common.annotation.OperationLog)")
    public void logAspectPoint() {
    }

    /**
     * 后置通知
     */
    @After("logAspectPoint() && @annotation(operationLog)")
    public void doAfter(JoinPoint joinPoint, OperationLog operationLog) {
        log.debug("=====后置通知开始=====");
        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        log.debug("方法参数是:{}", args[0].toString());
        // 获取注解值
        log.debug("方法注解是:{}", operationLog.module());
        // 获取request header中的token
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        log.debug("请求TOKEN是:{}", token);
        // TODO Ris通过token获取userId、role、orgNo等信息
        // 获取请求IP
        String ip = IpUtil.getUserIpAddr(request);
        log.debug("请求的IP是:{}", ip);

        OperateLog log = new OperateLog();
        log.setUserId(1);
        log.setOper(operationLog.module());
        log.setOperDesc("登录");
        log.setStatus(1);
        log.setCreateTime(new Date());

        operateLogService.save(log);
    }

}
