package com.zlx.my_ssm.service;

import com.zlx.my_ssm.domain.Product;

import java.util.List;

/**
 * 产品的业务层接口
 */
public interface IProductService {
    /**
     * 查询所有的产品
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;

    /**
     * 添加产品
     * @param product
     */
    void save(Product product);
}
