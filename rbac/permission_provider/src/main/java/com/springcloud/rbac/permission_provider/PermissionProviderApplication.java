package com.springcloud.rbac.permission_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@MapperScan("com.springcloud.rbac.permission_provider.dao")
public class PermissionProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PermissionProviderApplication.class, args);
    }

}
