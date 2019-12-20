package com.zlx.controller;

import com.zlx.domain.Items;
import com.zlx.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/showDetails")
    public String showDetails(Model model){ //model用于传递数据到前端
        Items items = itemsService.findById(1);
        model.addAttribute("item",items);
        return "itemsDetails";
    }
}
