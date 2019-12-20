package com.zlx.my_ssm.service;

import com.zlx.my_ssm.domain.Role;
import com.zlx.my_ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Spring Security框架要求:Service类需要基础实现UserDetailsService接口
 */
public interface IUserService extends UserDetailsService {
    /**
     * 查询所有的用户
     * @return
     */
    List<UserInfo> findAllUsers();

    /**
     * 保存用户
     */
    void save(String email,String username,String password,String phoneNum,Integer status);

    /**
     * 通过用户id查询到用户信息和关联的角色信息
     * @return
     */
    UserInfo findUserById(String userId);

    /**
     * 通过用户id查询到可以为用户添加的其他的角色(已经添加的角色不需要查询出来)
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId);

    /**
     *通过用户id查询对应用户已经添加的角色(已经添加到用户中的角色需要查询出来)
     * @param userId
     * @return
     */
    List<Role> findExistRoles(String userId);

    /**
     * 将查询到的尚未给用户添加的角色而添加给用户
     * @param userId
     * @param roleIds
     * 一个用户可以拥有多个角色,故需要使用字符串数组
     */
    void addRoleToUser(String userId, String[] roleIds);

    /**
     * 将查询到的已经给用户添加的角色从用户中删除
     * @param userId
     * @param roleIds
     */
    void deleteRoleFromUser(String userId, String[] roleIds);

}
