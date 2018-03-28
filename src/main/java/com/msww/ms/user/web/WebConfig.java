package com.msww.ms.user.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/")
                .excludePathPatterns("/static/**").excludePathPatterns("/register").excludePathPatterns("/userName").excludePathPatterns("/error/**")
                .excludePathPatterns("/ajaxerror").excludePathPatterns("/getAjaxerror").excludePathPatterns("/bootstrap-4.0.0/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");

        super.addResourceHandlers(registry);
    }

}
