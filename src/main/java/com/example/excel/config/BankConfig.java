package com.example.excel.config;

import com.example.excel.common.BankFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class BankConfig {
    Logger log = LoggerFactory.getLogger(BankConfig.class);

    @Bean
    public BankFactory bankInitializer() throws JsonParseException, JsonMappingException, IOException {
        log.info("Initialize bank factory");
        return new BankFactory();
    }
}
