package com.ashish.drq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(DRQAppConfig.class)
@ComponentScan(value = {"com.ashish.drq"} )
@SpringBootApplication
public class DRQMain {

    @Autowired
    ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DRQMain.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(DRQMain.class,args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext){
        String processName = System.getProperty("process.name");
        return args -> {
            DataProcess dataProcess = applicationContext.getBean(processName,DataProcess.class);
            dataProcess.start(args);
        };
    }

}
