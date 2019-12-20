package com.zlx.my_ssm.dao;

import com.zlx.my_ssm.domain.Member;
import com.zlx.my_ssm.domain.Orders;
import com.zlx.my_ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 订单的持久层
 */
public interface IOrdersDao {
    /**
     * 查询所有的订单
     * @return
     */
    @Select("select * from orders")
    @Results({
            //主键
            @Result(id=true,column = "id",property = "id"),
            //非主键
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            //产品的外键
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "com.zlx.my_ssm.dao.IProductDao.findProductById"))
    })
    List<Orders> findAllByPage() throws Exception;

    /**
     * 通过订单id查询订单，订单关联的产品、旅客，会员信息
     * @return
     */
    @Select("select * from orders where id = #{id}")
    @Results({
            //订单主键
            @Result(id=true,column = "id",property = "id"),
            //非主键
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderName",property = "orderName"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "peopleCount",property = "peopleCount"),
            //订单关联的产品表
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "com.zlx.my_ssm.dao.IProductDao.findProductById")),
            //订单关联的旅客表
            @Result(column = "memberId",property = "member",javaType = Member.class,one = @One(select = "com.zlx.my_ssm.dao.IMemberDao.findMemberById")),
            //订单关联的会员表
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,many = @Many(select = "com.zlx.my_ssm.dao.ITravellerDao.findTravellersById"))
    })
    Orders findById(String id) throws Exception;
}
