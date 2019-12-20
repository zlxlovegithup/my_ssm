package com.zlx.my_ssm.service.impl;

import com.zlx.my_ssm.dao.IUserDao;
import com.zlx.my_ssm.domain.Role;
import com.zlx.my_ssm.domain.UserInfo;
import com.zlx.my_ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = iUserDao.findUserByUsername(username);
        User user = null;
        try {
            //将从数据库中查询到的用户名和密码封装到UserDetails中
            //"{noop}"+userInfo.getPassword()跳过密码的加密操作

            // user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
            //如果用户的状态为0：未开启 则无法成功登录 如果状态为1：开启 则可以成功登录
            user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //返回一个list集合 集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    /**
     * 查询到所有的用户
     *
     * @return
     */
    @Override
    public List<UserInfo> findAllUsers() {
       return iUserDao.findAllUsers();
    }

    /**
     * 保存用户
     */
    @Override
    public void save(String email,String username,String password,String phoneNum,Integer status) {
        iUserDao.save(email,username,password,phoneNum,status);
    }


    /**
     * 通过用户id查询到用户信息和关联的角色信息
     * @return
     */
    @Override
    public UserInfo findUserById(String userId) {
        return iUserDao.findUserById(userId);
    }

    /**
     * 通过用户id查询到可以为用户添加的其他的角色(已经添加的角色不需要查询出来)
     * @param userId
     * @return
     */
    @Override
    public List<Role> findOtherRoles(String userId) {
        return iUserDao.findOtherRoles(userId);
    }

    /**
     * 通过用户id查询对应用户已经添加的角色(已经添加到用户中的角色需要查询出来)
     * @param userId
     * @return
     */
    @Override
    public List<Role> findExistRoles(String userId) {
        return iUserDao.findExistRoles(userId);
    }

    /**
     * 将查询到的尚未给用户添加的角色而添加给用户
     * @param userId
     * @param roleIds
     * 一个用户可以拥有多个角色,故需要使用字符串数组
     */
    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for(String roleId : roleIds){
            //将查询到的角色插入到用户-角色表中
            iUserDao.addRoleToUser(userId,roleId);
        }
    }

    /**
     * 将查询到的已经给用户添加的角色从用户中删除
     * @param userId
     * @param roleIds
     */
    @Override
    public void deleteRoleFromUser(String userId, String[] roleIds) {
        for(String roleId:roleIds){
            //从用户中删除对应角色
            iUserDao.deleteRoleFromUser(userId,roleId);
        }
    }
}
