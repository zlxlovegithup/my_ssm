package com.zlx.my_ssm.controller;


import com.github.pagehelper.PageInfo;
import com.zlx.my_ssm.domain.Orders;
import com.zlx.my_ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.PermitAll;
import java.util.List;

@Controller("ordersController")
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    /**
     * 分页查询所有的订单和订单关联的所有的产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllOrdersByPage.do")
    @PermitAll //允许所有的角色查询所有的订单
    public ModelAndView findAllOrdersByPage(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                            @RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        //查询第page页的pageSize条数据
        List<Orders> ordersList = ordersService.findAllByPage(page,pageSize);
        //分页Bean进行分页操作
        PageInfo pageInfo = new PageInfo(ordersList);

        System.out.println("====================================================================");
        System.out.println(ordersList);
        System.out.println("====================================================================");

//        modelAndView.addObject("ordersList",ordersList);
        modelAndView.addObject("pageInfo",pageInfo);
//        modelAndView.setViewName("orders-list");
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    /**
     * 通过订单id查询订单，订单关联的产品、旅客，会员信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    @PermitAll //允许所有的角色查询所有的订单
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id) throws Exception{
        //通过memberID查询会员
        //通过travellerID查询旅客
        //通过订单ID查询订单
        Orders order = ordersService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders-show");
        modelAndView.addObject("orders",order);
        return modelAndView;
    }
}
