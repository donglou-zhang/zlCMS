package com.cms.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Vincent on 2016/12/18.
 */
@SpringBootApplication
@EnableScheduling
//@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
//@ComponentScan
public class Application implements EmbeddedServletContainerCustomizer{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8088);
    }

}
