package com.it.ldq;

import com.it.ldq.entity.Product;
import com.it.ldq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: ldq
 * @Date: 2020/10/21
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/product")
@RefreshScope //动态刷新数据 @Value("${name}")
public class ProductController {
    @Autowired
    ProductService productService;
    @Value("${spring.cloud.client.ip-address}")
    private String ip;
    @Value("${server.port}")
    private String port;
    @Value("${name}")
    private String name;

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable("id") Long id) throws InterruptedException {
        Product product = productService.findById(id);
        product.setProductName("服务的ip地址:"+ip+":"+port);
        return product;
    }

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String test() {
        return name;
    }
}
