package com.macro.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(EurekaClientApplication.class, args);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
