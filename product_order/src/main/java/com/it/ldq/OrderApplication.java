package com.it.ldq;

import com.it.ldq.exception.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: ldq
 * @Date: 2020/10/21
 * @Description: com.it.ldq
 * @Version: 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
// 开启hystrix(有了feign 就不需要,但是要hystrix的监控数据的话就需要开启)
@EnableCircuitBreaker
// 激活hystrix仪表盘
@EnableHystrixDashboard
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    @Bean
    @LoadBalanced
   // @SentinelRestTemplate(blockHandler = "handleBlock",blockHandlerClass = ExceptionUtils.class,fallback = "handleFallback",fallbackClass = ExceptionUtils.class)
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
