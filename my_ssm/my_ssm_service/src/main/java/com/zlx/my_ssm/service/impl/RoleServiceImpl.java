package com.zlx.my_ssm.service.impl;

import com.zlx.my_ssm.dao.IRoleDao;
import com.zlx.my_ssm.domain.Permission;
import com.zlx.my_ssm.domain.Role;
import com.zlx.my_ssm.service.IRoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色的业务层实现类
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;


    @Override
    public List<Role> findAllRoles() {
        return iRoleDao.findAllRoles();
    }

    /**
     * 新增角色
     * @param roleName
     * @param roleDesc
     */
    @Override
    public void save(String roleName, String roleDesc) {
        iRoleDao.save(roleName,roleDesc);
    }

    /**
     * 根据角色id查询到对应的角色(包含角色的权限信息)
     * @param roleId
     * @return
     */
    @Override
    public Role findRoleById(String roleId) {
        return iRoleDao.findRoleById(roleId);
    }

    /**
     * 通过用户id找到其他的可以添加给角色的权限
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return iRoleDao.findOtherPermissions(roleId);
    }

    /**
     * 查询到角色中已经存在的权限
     * @param roleId
     */
    @Override
    public List<Permission>  findExistPermission(String roleId) {
       return iRoleDao.findExistPermission(roleId);
    }

    /**
     * 将尚未赋给角色的权限赋给角色
     */
    @Override
    public void addPermissionToRole(String[] permissionIds, String roleId) {
        for(String permissionId:permissionIds){
            iRoleDao.addPermissionToRole(permissionId,roleId);
        }
    }

    /**
     * 删除你所需要的删除的对应的角色的权限
     * @param permissionIds
     * @param roleId
     */
    @Override
    public void deletePermissionFromRole(String[] permissionIds, String roleId) {
        for(String permissionId:permissionIds){
            iRoleDao.deletePermissionFromRole(permissionId,roleId);
        }
    }

}
