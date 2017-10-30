package com.ucsmy.ucas.config;

import com.ucsmy.commons.log.LoggerOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {

    @Bean
    public LoggerOperation loggerOperation() {
        return new LoggerOperation();
    }

}
