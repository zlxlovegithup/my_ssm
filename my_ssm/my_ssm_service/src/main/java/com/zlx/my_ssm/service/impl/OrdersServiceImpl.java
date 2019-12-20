package com.zlx.my_ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.zlx.my_ssm.dao.IOrdersDao;
import com.zlx.my_ssm.domain.Orders;
import com.zlx.my_ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单的业务层方法
 */
@Service("OrdersServiceImpl")//将ProductServiceImpl交给Spring容器管理
@Transactional//事务的控制
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao iOrdersDao;

    /**
     * 分页查询订单
     * @param page 当前页
     * @param pageSize 每页记录数
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAllByPage(int page,int pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return iOrdersDao.findAllByPage();
    }

    /**
     * 通过订单id查询订单，订单关联的产品、旅客，会员信息
     * @param id
     * @return
     */
    @Override
    public Orders findById(String id) throws Exception {
        return iOrdersDao.findById(id);
    }
}
