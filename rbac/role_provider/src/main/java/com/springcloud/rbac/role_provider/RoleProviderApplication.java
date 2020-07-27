package com.springcloud.rbac.role_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableFeignClients
@MapperScan("com.springcloud.rbac.role_provider.dao")
public class RoleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoleProviderApplication.class, args);
    }

}
