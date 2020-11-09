package com.it.ldq.exception;

import com.sun.deploy.security.BlockedException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * @Auther: ldq
 * @Date: 2020/10/23
 * @Description:
 * @Version: 1.0
 */
// sentinel方式的熔断降级
public class ExceptionUtils {

    // 限流熔断业务
//    public static SentinelClientHttpResponse handleBlock(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockedException be) {
//
//        return new SentinelClientHttpResponse("限流熔断降级");
//    }
//
//    // 异常熔断业务
//    public static SentinelClientHttpResponse handleFallback(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockedException be) {
//        return new SentinelClientHttpResponse("异常熔断降级");
//    }
}
