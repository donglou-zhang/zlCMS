package com.cms.zl.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Vincent on 2017/1/3.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceHandler指定对外暴露的访问路径，addResourceLocation指定文件放置目录
        registry.addResourceHandler("/upload/articleImages/**").addResourceLocations("file:E:/Projects/Java/zlCMS/upload/articleImages/");
        super.addResourceHandlers(registry);
    }
}
