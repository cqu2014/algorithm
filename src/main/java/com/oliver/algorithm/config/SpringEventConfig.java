package com.oliver.algorithm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.Executors;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/18
 * @since
 */
@Configuration
public class SpringEventConfig {

    /**
     * 名字在AbstractApplicationContext中是固定死的
     *
     * @return
     */
    @Bean("applicationEventMulticaster")
    public SimpleApplicationEventMulticaster eventMulticaster(){
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(Executors.newFixedThreadPool(3));
        return eventMulticaster;
    }
}
