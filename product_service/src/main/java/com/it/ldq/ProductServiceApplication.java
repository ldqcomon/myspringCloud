package com.it.ldq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: ldq
 * @Date: 2020/10/21
 * @Description:
 * @Version: 1.0
 */
@SpringBootApplication
// 激活eureka客户端:可以省略不写
@EnableEurekaClient
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class,args);
    }
}
