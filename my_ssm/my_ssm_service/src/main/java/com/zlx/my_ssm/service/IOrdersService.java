package com.zlx.my_ssm.service;

import com.zlx.my_ssm.domain.Orders;

import java.util.List;

/**
 * 订单的业务层方法
 */
public interface IOrdersService {

    /**
     * 分页查询订单
     * @param page 当前页
     * @param pageSize 每页记录数
     * @return
     * @throws Exception
     */
    List<Orders> findAllByPage(int page,int pageSize) throws Exception;

    /**
     * 通过订单id查询订单，订单关联的产品、旅客，会员信息
     * @param id
     * @return
     */
    Orders findById(String id) throws Exception;
}
