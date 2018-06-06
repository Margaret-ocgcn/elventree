package com.fhj.elventree;

import com.fhj.elventree.registery.Dict;
import com.google.gson.Gson;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
@ImportResource(locations = {"classpath:beans.xml"})
public class SpringConfigLoader {
    public SpringConfigLoader() {
        System.out.println("TestConfiguration容器启动初始化。。。");
    }

    // @Bean注解注册bean,同时可以指定初始化和销毁方法
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "dict", initMethod = "init", destroyMethod = "destory")
    public Dict testBean() {
        return new Dict();
    }



    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "gson")
    public Gson getGson() {
        return new Gson();
    }
}
