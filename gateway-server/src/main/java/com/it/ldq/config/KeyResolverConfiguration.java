package com.it.ldq.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Auther: ldq
 * @Date: 2020/10/24
 * @Description:
 * @Version: 1.0
 */
@Configuration
public class KeyResolverConfiguration {

    // 基于请求路径的限流
//    @Bean
//    public KeyResolver pathKeyResolver() {
//        KeyResolver keyResolver = new KeyResolver() {
//            public Mono<String> resolve(ServerWebExchange exchange) {
//                return Mono.just(exchange.getRequest().getPath().toString());
//            }
//        };
//        return keyResolver;
//    }

    // 基于用户限流
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }
}
