package com.it.ldq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @Auther: ldq
 * @Date: 2020/10/23
 * @Description:
 * @Version: 1.0
 */
@SpringBootApplication
// 开启zuul网关
@EnableZuulProxy
//@EnableZuulServer
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class,args);
    }
}
