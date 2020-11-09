package com.it.ldq.service.impl;

import com.it.ldq.dao.ProductDao;
import com.it.ldq.entity.Product;
import com.it.ldq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Auther: ldq
 * @Date: 2020/10/21
 * @Description:
 * @Version: 1.0
 */
@Service
public class IProductService implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public Product findById(Long id) {
        Product product = productDao.findById(id).get();
        return product;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Long id) {

    }
}
