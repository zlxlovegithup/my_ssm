package com.zlx.my_ssm.domain;

import java.util.List;

public class Permission {
    private String id; //角色UUID 无意义
    private String permissionName;//权限名
    private String url;//资源路径
    private List<Role> roles;//角色与权限是多对多的关系

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
