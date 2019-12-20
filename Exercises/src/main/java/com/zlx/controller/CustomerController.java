package com.zlx.controller;

import com.zlx.domain.Customer;
import com.zlx.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/login")
    public String login(Customer customer, Model model) {
        customer = customerService.getCustomerByAccount(customer);
        if(customer!=null){
            model.addAttribute("LOGIN_CUSTOMER",customer);
            return "success";
        }
        //如果你直接返回一个字符串 ， 那么它是返回本页面的error.jsp页面
        return "error";
    }
}
