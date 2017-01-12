package com.cms.zl.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.FileNotFoundException;
import java.net.URL;

/**
 * Created by Vincent on 2017/1/3.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        URL root = null;
        try {
            root = ResourceUtils.getURL("");//获取项目根路径
            System.out.println("root path: " + root);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // addResourceHandler指定对外暴露的访问路径，addResourceLocation指定文件放置目录
        registry.addResourceHandler("/upload/articleImages/**").addResourceLocations(root + "/upload/articleImages/");
        registry.addResourceHandler("/adminAvatar/**").addResourceLocations(root + "/upload/adminAvatar/");
        super.addResourceHandlers(registry);
    }
}
