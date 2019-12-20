package com.zlx.my_ssm.controller;

import com.zlx.my_ssm.domain.Permission;
import com.zlx.my_ssm.domain.Role;
import com.zlx.my_ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Role> roleList = iRoleService.findAllRoles();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-list");
        modelAndView.addObject("roleList",roleList);
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(@RequestParam(name = "roleName",required = true) String roleName,@RequestParam(name = "roleDesc",required = true) String roleDesc){
        iRoleService.save(roleName,roleDesc);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String roleId){
        Role role = iRoleService.findRoleById(roleId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    @RequestMapping("/findRoleByIdAndAllPermission_addPermission.do")
    public ModelAndView findRoleByIdAndAllPermission_addPermission(@RequestParam(name = "id",required = true) String roleId){
        Role role = iRoleService.findRoleById(roleId);
        List<Permission> permissionList = iRoleService.findOtherPermissions(roleId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-permission-add");
        modelAndView.addObject("role",role);
        modelAndView.addObject("roleList",permissionList);
        return modelAndView;
    }

    @RequestMapping("/findRoleByIdAndAllPermission_deletePermission.do")
    public ModelAndView findRoleByIdAndAllPermission__deletePermission(@RequestParam(name = "id",required = true) String roleId){
        Role role = iRoleService.findRoleById(roleId);
        List<Permission> permissionList = iRoleService.findExistPermission(roleId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-permission-delete");
        modelAndView.addObject("role",role);
        modelAndView.addObject("roleList",permissionList);
        return modelAndView;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "permissionIds",required = true) String[] permissionIds,@RequestParam(name = "roleId",required = true)  String roleId){
        iRoleService.addPermissionToRole(permissionIds,roleId);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deletePermissionFromRole.do")
    public String deletePermissionFromRole(@RequestParam(name = "permissionIds",required = true) String[] permissionIds, @RequestParam(name = "roleId",required = true)  String roleId){
        iRoleService.deletePermissionFromRole(permissionIds,roleId);
        return "redirect:findAll.do";
    }
}
