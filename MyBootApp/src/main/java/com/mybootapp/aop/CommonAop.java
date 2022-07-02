package com.mybootapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mybootapp.exceptioon.ApplicationException;
import com.mybootapp.exceptioon.SystemException;

@Aspect
@Component
public class CommonAop {
	private static final Logger log = LoggerFactory.getLogger(CommonAop.class);
	
	@Around("execution(* com.mybootapp.controller..*.*(..))")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object ret = null;
        try {
            log.info(String.format("[START] %s#%s",
                    proceedingJoinPoint.getTarget().getClass(),
                    proceedingJoinPoint.getSignature().getName()));

            // 業務処理実行
            ret = proceedingJoinPoint.proceed();

        // 例外発生時は内容をログに出力する。例外のハンドリングは例外ハンドラクラスで行うため、再スローする。
        } catch (ApplicationException e) {
            log.warn("アプリケーションエラー発生：" + e.toString());
            throw e;
            
        } catch (SystemException e) {
            log.error("システムエラー発生：" + e.getMessage());
            throw e;
            
        } catch (Exception e) {
            log.error("例外発生：" + e.getCause());
            throw new SystemException(e);
            
        } finally {
            log.info(String.format("[END  ] %s#%s",
                    proceedingJoinPoint.getTarget().getClass(),
                    proceedingJoinPoint.getSignature().getName()));
        }
        
        return ret;
    }
    
    @Around("execution(* com.mybootapp.service..*.*(..))")
    public Object invokeService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object ret = null;
        
        log.info(String.format("[START] %s#%s",
                proceedingJoinPoint.getTarget().getClass(),
                proceedingJoinPoint.getSignature().getName()));

        // 業務処理実行
        ret = proceedingJoinPoint.proceed();

        log.info(String.format("[END  ] %s#%s",
                proceedingJoinPoint.getTarget().getClass(),
                proceedingJoinPoint.getSignature().getName()));

        return ret;
    }
}