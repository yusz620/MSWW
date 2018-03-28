package com.msww.ms;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.msww.ms.user.model.SysUser;
import com.msww.ms.user.web.WebConfig;

@SpringBootApplication
// 开启定时任务
@EnableScheduling
// 开启异步调用方法
@EnableAsync
// @EnableWebSecurity
public class MswwApplication {
    private static final Logger log = LoggerFactory.getLogger(MswwApplication.class);
    //static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);

    public static void main(String[] args) {
        SpringApplication.run(MswwApplication.class, args);
//        log.debug(context.getApplicationName());
//        log.debug(context.getBean(WebConfig.class).toString());
    }

    @Bean
    public SysUser currentUser() {
        return new SysUser();
    }

    @Bean
    public HttpSession httpSession(HttpSession httpSession) {
        return httpSession;
    }

}
