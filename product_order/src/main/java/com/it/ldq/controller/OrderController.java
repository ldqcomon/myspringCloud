package com.it.ldq.controller;

import com.it.ldq.entity.Product;
import com.it.ldq.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @Auther: ldq
 * @Date: 2020/10/21
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/order")
// 统一降级方法(hystrix)
// @DefaultProperties(defaultFallback = "defaultFallback")
public class OrderController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    ProductFeign productFeign;

    @GetMapping("/{id}")
    // @HystrixCommand(fallbackMethod = "fallback")
   // @SentinelResource(value="order",blockHandler = "fallback",fallback = "fallback2")
    public Product findProductById(@PathVariable("id") Long id) {
       // List<ServiceInstance> services = discoveryClient.getInstances("SERVICE_PRODUCT");
        // 远程调用productService服务
       // Product product = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/1", Product.class);
        //通过微服务的名称调用
        //Product product = restTemplate.getForObject("http://service-product/product/1", Product.class);
        // 通过feign 接口方式远程调用服务
        if (id==2) {
            throw new RuntimeException();
        }
        Product product = productFeign.findById(id);
        return product;
    }

    // 熔断之后的降级方法:返回值和方法的参数要和原来的方法一致
    public Product fallback(Long id) {
        Product product = new Product();
        product.setProductName("触发了降级方法");
        return product;
    }

    public Product fallback2(Long id) {
        Product product = new Product();
        product.setProductName("触发了抛出异常方法");
        return product;
    }

    // 统一降级方法:没有参数
    public Product defaultFallback() {
        Product product = new Product();
        product.setProductName("触发了统一降级方法");
        return product;
    }
}
