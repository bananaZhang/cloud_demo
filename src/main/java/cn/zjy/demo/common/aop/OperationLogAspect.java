package cn.zjy.demo.common.aop;

import cn.zjy.demo.common.annotation.OperationLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZJY
 * @ClassName: OperationLogAspect
 * @Description: OperationLogAspect
 * @date 2018/8/22 20:16
 */
@Aspect
@Component
public class OperationLogAspect {

    private static Logger logger = LoggerFactory.getLogger(OperationLogAspect.class);

    // 在@OperationLog注解的地方进行日志记录
    @Pointcut("@annotation(cn.zjy.demo.common.annotation.OperationLog)")
    public void logAspectPoint() {
    }

    /**
     * 后置通知
     */
    @After("logAspectPoint() && @annotation(operationLog)")
    public void doAfter(JoinPoint joinPoint, OperationLog operationLog) {
        logger.debug("=====后置通知开始=====");
        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        logger.debug("方法参数是:{}", args[0].toString());
        // 获取注解值
        logger.debug("方法注解是:{}", operationLog.module());
        // 获取request header中的token
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        logger.debug("请求TOKEN是:{}", token);
        // TODO 通过token获取userId、role、orgNo等信息
        // 获取请求IP
        String ip = request.getRemoteAddr();
        logger.debug("请求的IP是:{}", ip);

    }

}
