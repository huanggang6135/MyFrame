package org.hg.shiro.aspect;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hg.shiro.dto.OperateLog;
import org.hg.shiro.service.OperateLogService;
import org.hg.shiro.util.Encrypts;
import org.hg.shiro.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Controller Log
 *
 * @Author hg
 * @Date 2019/4/4 15:04
 * @Version 1.0
 **/
@Slf4j
@Aspect
@Component
public class ControllerLogAspect {
    @Autowired
    private OperateLogService operateLogService;

    @Pointcut("execution(public * org.hg.shiro.rest.*.*(..))")
    public void webLog() {
    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        OperateLog operateLog = initLog(joinPoint);
        if (ret instanceof Result) {
            Result result = (Result) ret;
            operateLog.setResultCode(result.getCode());
            String message = result.getMessage();
            if (message != null) {
                operateLog.setResultMessage(get225(message));
            }
        }
        operateLogService.save(operateLog);
        log.info("用户：{} 请求： {} 结果： {} {}", operateLog.getOperator(),
                operateLog.getOperateType(), operateLog.getResultCode(), operateLog.getResultMessage());
    }
    @AfterThrowing(value = "webLog()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable exception){
        OperateLog operateLog = initLog(joinPoint);
        if(exception != null){
            operateLog.setException(get225(exception.getMessage()));
        }
        operateLogService.save(operateLog);
        log.info("用户：{} 请求： {} 异常： {}",
                operateLog.getOperator(), operateLog.getOperateType(), operateLog.getException());
    }

    private OperateLog initLog(@NonNull JoinPoint joinPoint) {
        /*** ============ 获取用户  ================= **/
        Object operator = SecurityUtils.getSubject().getPrincipal();
        /*** ============ 获取方法签名  ================= **/
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        OperateLog operateLog = new OperateLog();
        operateLog.setId(Encrypts.uuid());
        operateLog.setOperator(String.valueOf(operator));
        operateLog.setOperateType(signature.getDeclaringTypeName() + "." + methodSignature.getName());
        /*** ============ 获取请求信息  ================= **/
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        operateLog.setIp(req.getRemoteAddr());
        operateLog.setUrl(req.getRequestURL().toString());
        operateLog.setHttpMethod(req.getMethod());
        operateLog.setArgs(get225(Arrays.toString(joinPoint.getArgs())));
        return operateLog;
    }

    private String get225(String str) {
        return str.length() > 255 ? str.substring(0, 255) : str;
    }
}
