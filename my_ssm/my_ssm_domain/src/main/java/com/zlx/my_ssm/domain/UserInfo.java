package com.zlx.my_ssm.domain;

import java.util.List;
import java.util.UUID;

public class UserInfo {

    private String id;  //主键UUID 无意义
    private String username;//用户名
    private String email;//邮箱
    private String password;//密码
    private String phoneNum;//电话号码
    private Integer status;//状态(0 未开启 1 已经开启)
    private String statusStr;//状态(字符串类型,方便在前端页面上进行展示)
    private List<Role> roles; //用户和角色是多对多的关系

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        //状态(0 未开启 1 已经开启)
        if(status!=null){
            if(status==0){
                statusStr="未开启";
            }
            if(status==1){
                statusStr="已经开启";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
