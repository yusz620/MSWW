package com.msww.ms.user.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msww.ms.utils.MSWWJsonResult;

// @ControllerAdvice
public class AjaxExceptionHandler {

    public static final String ERROR_VIEW = "error/ajaxerror";
    private Logger log = LoggerFactory.getLogger(AjaxExceptionHandler.class);

    // @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) throws Exception {
        log.debug("start to log exception", exception.getMessage());
        exception.printStackTrace();
        return MSWWJsonResult.errorException(exception.getMessage());
    }

    public static boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
