package com.it.ldq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Auther: ldq
 * @Date: 2020/10/25
 * @Description:
 * @Version: 1.0
 */
@SpringBootApplication
// 开启注册中心服务
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }

}
