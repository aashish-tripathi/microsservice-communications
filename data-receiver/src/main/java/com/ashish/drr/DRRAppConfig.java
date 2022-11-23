package com.ashish.drr;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "process.name", havingValue = "start-data-receiver")
public class DRRAppConfig {

    @Bean("start-data-receiver")
    public DataProcess startDataReceiver(DataReceiver dataReceiver){
        return args -> dataReceiver.startReceiver();
    }

}
