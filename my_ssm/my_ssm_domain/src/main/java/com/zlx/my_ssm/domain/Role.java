package com.zlx.my_ssm.domain;

import java.util.List;

public class Role {
    private String id;//主键UUID 无意义
    private String roleName;//角色名称
    private String roleDesc;//角色描述
    private List<Permission> permissions; //角色与权限是多对多的关系
    private List<UserInfo> users; //角色与用户是多对多的关系

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
