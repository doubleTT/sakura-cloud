package com.cola.sakura.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.cola.sakura.system.dao")
public class SakuraCloudSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SakuraCloudSystemApplication.class, args);
    }

}
