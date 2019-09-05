package cn.zjy.demo.common.aop;

import cn.zjy.demo.common.annotation.OperationLog;
import cn.zjy.demo.bean.model.OperateLog;
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
//@Order(1)
public class OperationLogAspect {

    @Autowired
    private OperateLogService operateLogService;

    /**
     * 在@OperationLog注解的地方进行日志记录
     */
    @Pointcut("@annotation(cn.zjy.demo.common.annotation.OperationLog)")
    public void logAspectPoint() {
    }

    /**
     * 在切点中带入参数
     */
    @Pointcut("execution(* cn.zjy.demo.service.impl.UserServiceImpl.getUser(Integer)) && args(userId)")
    public void getUserPoint(Integer userId){
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
        // 获取请求IP
        String ip = IpUtil.getUserIpAddr(request);
        log.debug("请求的IP是:{}", ip);
        log.debug("请求的URL是:{}", request.getRequestURI());

        OperateLog log = new OperateLog();
        log.setUserId(1);
        log.setOper(operationLog.module());
        log.setOperDesc("登录");
        log.setStatus(1);
        log.setCreateTime(new Date());

        operateLogService.save(log);
    }

    @After("getUserPoint(userId)")
    public void beforeGetUser(Integer userId) {
        log.debug("=====获取用户后的操作=====");
        log.debug("userId = {}", userId);
        // 这里设置userId=3时抛出异常，目的是测试aop中的异常能否回滚掉主代码的事务
        // 经测试：只要在切面上加了@Order注解，这里的异常就不会回滚掉主代码的事务；如果没有加@Order注解，就会回滚掉，可见@Transactional的优先级应该是很高的
        if (userId == 3) {
            throw new RuntimeException("rollback transaction");
        }
    }
}
