package com.it.ldq.service;

import com.it.ldq.entity.Product;
import org.springframework.stereotype.Service;

/**
 * @Auther: ldq
 * @Date: 2020/10/21
 * @Description:
 * @Version: 1.0
 */
public interface ProductService {
    /**
     * 根据id查询
     */
    Product findById(Long id);

    /**
     * 保存
     */
    void save(Product product);
    /**
     * 更新
     */
    void update(Product product);
    /**
     * 删除
     */
    void delete(Long id);
}
