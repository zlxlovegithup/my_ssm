package com.zlx.my_ssm.dao;

import com.zlx.my_ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 产品的持久层接口
 */
public interface IProductDao {
    @Select("select * from product")
    /**
     * 查询所有的产品
     */
    List<Product> findAll() throws Exception;

    /**
     * 新增产品
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 根据id查询到产品
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    Product findProductById(String id) throws Exception;

}
