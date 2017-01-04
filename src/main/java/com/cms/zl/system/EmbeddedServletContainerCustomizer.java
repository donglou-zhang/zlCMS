package com.cms.zl.system;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;

/**
 * Created by Vincent on 2016/12/20.
 * EmbeddedServletContainerCustomizer接口提供了customize方法用来自定义servlet容器的一些属性
 */
public interface EmbeddedServletContainerCustomizer {

    void customize(ConfigurableEmbeddedServletContainer container);
}
