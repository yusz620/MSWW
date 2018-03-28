package com.msww.ms.user.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserControllerAspect {
    private final static Logger logger = LoggerFactory.getLogger(UserControllerAspect.class);

    @Pointcut("execution(public * com.msww.ms.user.controller.UserController.*(..))")
    public void log() {}

    // @Before("execution(public * com.msww.ms.user.controller.UserController.login(..))")
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("UserControllerAspect executed before");
        // ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // HttpServletRequest request = requestAttributes.getRequest();
        logger.info("--------------------UserController information start--------------------");
        // logger.info("request.getAuthType() " + request.getAuthType());
        // logger.info("request.getCharacterEncoding() " + request.getCharacterEncoding());
        // logger.info("request.getContentLength() " + request.getContentLength());
        // logger.info("request.getContentType() " + request.getContentType());
        // logger.info("request.getContextPath() " + request.getContextPath());
        // logger.info("request.getHeader(\"currentUser\") " + request.getHeader("currentUser"));
        // logger.info("request.getLocalAddr() " + request.getLocalAddr());
        // logger.info("request.getLocalName() " + request.getLocalName());
        // logger.info("request.getLocalPort() " + request.getLocalPort());
        // logger.info("request.getMethod() " + request.getMethod());
        // logger.info("request.getPathInfo() " + request.getPathInfo());
        // logger.info("request.getPathTranslated() " + request.getPathTranslated());
        // logger.info("request.getProtocol() " + request.getProtocol());
        // logger.info("request.getQueryString() " + request.getQueryString());
        // logger.info("request.getRealPath(request.getContextPath()) " + request.getRealPath(request.getContextPath()));
        // logger.info("request.getRemoteAddr() " + request.getRemoteAddr());
        // logger.info("request.getRemoteHost() " + request.getRemoteHost());
        // logger.info("request.getRemotePort() " + request.getRemotePort());
        // logger.info("request.getRemoteUser() " + request.getRemoteUser());
        // logger.info("request.getRequestURL() " + request.getRequestURL());
        // logger.info("Class method " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // logger.info("args {} " + joinPoint.getArgs().toString());


        logger.info("--------------------UserController information end--------------------");
    }

    @After("log()")
    public void doAfter() {
        logger.info("UserControllerAspect executed after");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("UserControllerAspect executed afterReturning");
        logger.info("Response object {} " + object);
    }

    // @Around(value = "")
    // public void doAround(Object object) {
    // logger.info("UserControllerAspect executed around");
    // logger.info("Response object {} " + object);
    // }

}
