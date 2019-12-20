package com.zlx.my_ssm.controller;

import com.zlx.my_ssm.domain.Role;
import com.zlx.my_ssm.domain.UserInfo;
import com.zlx.my_ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')") //管理员才有资格查询所有用户
    public ModelAndView findAll(){
        List<UserInfo> userList = iUserService.findAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-list");
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }

    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username == '小哥哥' or authentication.principal.username == '小姐姐'") //名字为小哥哥或者小姐姐的管理员用户才有资格添加用户
    public String save(@RequestParam(name = "email",required = true) String email,@RequestParam(name = "username",required = true) String username,@RequestParam(name = "password",required = true) String password,@RequestParam(name = "phoneNum",required = true) String phoneNum,@RequestParam(name = "status",required = true) Integer status){
        iUserService.save(email,username,password,phoneNum,status);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String userId){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo=iUserService.findUserById(userId);
        modelAndView.setViewName("user-show");
        modelAndView.addObject("user",userInfo);
        return modelAndView;
    }

    /**
     * 通过用户id查询到对应用户和可以添加的角色
     */
    @RequestMapping("/findUserByIdAndAllRole_AddRole.do")
    public ModelAndView findUserByIdAndAllRole_AddRole(@RequestParam(name = "id",required = true) String userId){
        //通过用户id查询到对应的用户
        UserInfo user = iUserService.findUserById(userId);
        //通过用户id查询还可以为对应用户添加的角色(已经添加到用户中的角色不需要查询出来)
        List<Role> roleList = iUserService.findOtherRoles(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList",roleList);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    /**
     * 通过用户id查询到对应用户和已经添加到用户之中的角色
     */
    @RequestMapping("/findUserByIdAndAllRole_DeleteRole.do")
    public ModelAndView findUserByIdAndAllRole_DeleteRole(@RequestParam(name = "id",required = true) String userId){
        //通过用户id查询到对应的用户
        UserInfo user = iUserService.findUserById(userId);
        //通过用户id查询对应用户已经添加的角色(已经添加到用户中的角色需要查询出来)
        List<Role> roleList = iUserService.findExistRoles(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList",roleList);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user-role-delete");
        return modelAndView;
    }

    /**
     * 给用户添加没有添加过的角色
     * @return
     * 一个用户可以拥有多个角色,故需要使用字符串数组
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds){
        iUserService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    //deleteRoleFromUser
    @RequestMapping("/deleteRoleFromUser.do")
    public String deleteRoleFromUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds){
        iUserService.deleteRoleFromUser(userId,roleIds);
        return "redirect:findAll.do";
    }

}
