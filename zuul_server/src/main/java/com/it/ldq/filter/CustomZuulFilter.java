package com.it.ldq.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: ldq
 * @Date: 2020/10/23
 * @Description:
 * @Version: 1.0
 */
@Slf4j
@Component
public class CustomZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 路由前执行过滤器:pre,routing post,error 四种过滤器
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤器执行的顺序
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // 过滤器是否有效
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 过滤器执行具体的逻辑
        log.info("来到了zuul过滤器..........");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if (token==null) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        // 检验通过的话,可以将用户的消息放入上下文,以便后续用到
       // requestContext.set(token,token);
        return null;
    }
}
