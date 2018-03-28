package com.msww.ms.user.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msww.ms.utils.MSWWJsonResult;

@Controller
public class ExceptionController {
    @RequestMapping(value = "error/error")
    public String error() {
        int i = 1 / 0;
        return "error/error";
    }

    @RequestMapping(value = "error/ajaxerror")
    public String ajaxerror() {

        return "error/ajaxerror";
    }

    @RequestMapping(value = "error/getAjaxerror")
    @ResponseBody
    public Object getAjaxerror() {
        int i = 1 / 0;
        return MSWWJsonResult.ok();
    }
}
