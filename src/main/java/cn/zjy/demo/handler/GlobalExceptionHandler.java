package cn.zjy.demo.handler;

import cn.zjy.demo.bean.vo.JsonVO;
import cn.zjy.demo.common.constant.ReturnCodeAndMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * 全局异常处理器
 * @author: ZJY
 * @date: 2019/9/4 下午10:20
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonVO<String> defaultExceptionHandler(Exception e) {
        // @RequestBody抛出的异常
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            List<ObjectError> errors = exception.getBindingResult().getAllErrors();
            StringBuilder errInfo = new StringBuilder();
            for (ObjectError error : errors) {
                String message = error.getDefaultMessage();
                errInfo.append(message).append(",");
            }
            return new JsonVO<>(ReturnCodeAndMsg.FAIL, errInfo.substring(0, errInfo.length()-1));
        // @RequestParam抛出的异常
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException exception = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
            StringBuilder errInfo = new StringBuilder();
            for (ConstraintViolation<?> violation : violations) {
                errInfo.append(violation.getMessage()).append(",");
            }
            return new JsonVO<>(ReturnCodeAndMsg.FAIL, errInfo.substring(0, errInfo.length()-1));
        }
        log.error(e.getMessage(), e);
        return new JsonVO<>(ReturnCodeAndMsg.FAIL);
    }

}
