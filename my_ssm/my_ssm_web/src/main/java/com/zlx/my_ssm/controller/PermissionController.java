package com.zlx.my_ssm.controller;

import com.zlx.my_ssm.domain.Permission;
import com.zlx.my_ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/permission")
@Controller
public class PermissionController {

    @Autowired
   private IPermissionService iPermissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Permission> permissionList = iPermissionService.findAllPermissions();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("permission-list");
        modelAndView.addObject("permissionList",permissionList);
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(@RequestParam(name = "permissionName",required = true) String permissionName, @RequestParam(name = "url",required = true) String url){
        iPermissionService.save(permissionName,url);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deletePermission.do")
    public String deletePermission(@RequestParam("id") String permissionId){
        iPermissionService.deletePermission(permissionId);
        return "redirect:findAll.do";
    }
}
