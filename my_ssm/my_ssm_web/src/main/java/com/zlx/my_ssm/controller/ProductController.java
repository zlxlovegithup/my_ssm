package com.zlx.my_ssm.controller;

import com.zlx.my_ssm.domain.Product;
import com.zlx.my_ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

@Controller("productController")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 查询所有的产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    //@RolesAllowed("ADMIN") //只有拥有管理员权限才可以查询所有的产品
    @Secured("ROLE_ADMIN") //只有管理员才可以查询产品
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll();
        modelAndView.addObject("productList", productList);
        modelAndView.setViewName("product-list1");
        return modelAndView;
    }

    /**
     * 增添产品，增加完产品之后，调用查询方法查询产品
     * @param product
     */
    @RequestMapping("/save.do")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do"; //使用了重定向
        //return findAll()  没有使用重定向
    }
}
