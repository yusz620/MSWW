package com.msww.ms.user.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.msww.ms.utils.MSWWJsonResult;

@ControllerAdvice
public class HttpExceptionHandler {
    public static final String ERROR_VIEW = "error/error";
    private Logger log = LoggerFactory.getLogger(HttpExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) throws Exception {
        log.debug("start to log exception", exception.getMessage());
        exception.printStackTrace();
        if (isAjax(request)) {
            exception.printStackTrace();
            return MSWWJsonResult.errorException(exception.getMessage());
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception", exception);
            modelAndView.addObject("message", exception.getMessage());
            modelAndView.addObject("url", request.getRequestURL());
            modelAndView.setViewName(ERROR_VIEW);
            log.debug("end log exception");
            return modelAndView;
        }

    }

    public static boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
