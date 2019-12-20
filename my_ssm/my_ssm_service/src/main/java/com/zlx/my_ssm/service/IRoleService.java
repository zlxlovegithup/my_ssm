package com.zlx.my_ssm.service;

import com.zlx.my_ssm.domain.Permission;
import com.zlx.my_ssm.domain.Role;

import java.util.List;

/**
 * 角色的业务层接口
 */
public interface IRoleService {

    /**
     * 查询所有的角色
     * @return
     */
    List<Role> findAllRoles();

    /**
     * 新增角色
     * @param roleName
     * @param roleDesc
     */
    void save(String roleName, String roleDesc);

    /**
     * 根据角色id查询到对应的角色(包含角色的权限信息)
     * @param roleId
     * @return
     */
    Role findRoleById(String roleId);

    /**
     * 通过用户id找到其他的可以添加给角色的权限
     * @return
     */
    List<Permission> findOtherPermissions(String roleId);

    /**
     * 将尚未赋给角色的权限赋给角色
     */
    void addPermissionToRole(String[] permissionId, String roleId);

    /**
     * 查询到角色中已经存在的权限
     * @param roleId
     */
    List<Permission>  findExistPermission(String roleId);

    /**
     * 删除你所需要的删除的对应的角色的权限
     * @param permissionIds
     * @param roleId
     */
    void deletePermissionFromRole(String[] permissionIds, String roleId);

}
