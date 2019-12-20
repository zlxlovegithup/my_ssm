package com.zlx.my_ssm.service;

import com.zlx.my_ssm.domain.Permission;

import java.util.List;

/**
 * 权限的业务层接口
 */
public interface IPermissionService {

    /**
     * 查询到所有的权限
     * @return
     */
    List<Permission> findAllPermissions();

    /**
     * 新增权限
     */
    void save(String permissionName,String url);

    /**
     * 删除对应的权限
     * @param permissionId
     */
    void deletePermission(String permissionId);
}
