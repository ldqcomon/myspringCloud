package com.it.ldq.feign;

import com.it.ldq.entity.Product;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: ldq
 * @Date: 2020/10/22
 * @Description:
 * @Version: 1.0
 */
// service-product:需要远程调用的微服务的名称,fallback:熔断之后执行降级方法
@FeignClient(name = "service-product",fallback = IProductFeign.class)
public interface ProductFeign {
    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    Product findById(@PathVariable("id") Long id);
}
