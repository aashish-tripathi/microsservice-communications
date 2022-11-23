package com.ashish.drq;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "process.name", havingValue = "start-data-sender")
public class DRQAppConfig {

    @Bean("start-data-sender")
    public DataProcess startDataReceiver(DataSender dataSender){
        return args -> dataSender.startSender();
    }

}
