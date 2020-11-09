package com.it.ldq.feign;

import com.it.ldq.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @Auther: ldq
 * @Date: 2020/10/22
 * @Description:
 * @Version: 1.0
 */
// 降级接口
@Component
public class IProductFeign implements ProductFeign {
    @Override
    public Product findById(Long id) {
        Product product = new Product();
        product.setProductName("进入了feign的降级方法中了");
        return product;
    }
}
