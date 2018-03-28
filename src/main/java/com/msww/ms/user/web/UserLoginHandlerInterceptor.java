package com.msww.ms.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.msww.ms.user.model.SysUser;

@Component
public class UserLoginHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
        System.out.println("afterCompletion run!");

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle run!");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        System.out.println("preHandle run!");
        HttpSession httpSession = request.getSession();
        SysUser user = (SysUser) httpSession.getAttribute("currentUser");
        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
