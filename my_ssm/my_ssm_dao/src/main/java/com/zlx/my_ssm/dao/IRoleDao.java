package com.zlx.my_ssm.dao;

import com.zlx.my_ssm.domain.Permission;
import com.zlx.my_ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 角色持久层接口
 */
public interface IRoleDao {

    /**
     * 通过用户的id查询到角色
     * @param userId
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    List<Role> findRolesByUserId(String userId);

    /**
     * 查询所有的角色
     * @return
     */
    @Select("select * from role")
    List<Role> findAllRoles();

    /**
     * 新增角色
     * @param roleName
     * @param roleDesc
     */
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc}")
    void save(@Param("roleName") String roleName, @Param("roleDesc") String roleDesc);

    /**
     * 根据角色id查询到对应的角色(包含角色的权限信息)
     * @param roleId
     * @return
     */
    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,many = @Many(select = "com.zlx.my_ssm.dao.IPermissionDao.findPermissionsByRoleId"))
    })
    Role findRoleById(@Param("roleId") String roleId);

    /**
     * 通过用户id找到其他的可以添加给角色的权限
     * @param roleId
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(@Param("roleId") String roleId);

    /**
     * 将尚未赋给角色的权限赋给角色
     */
    @Insert("insert into role_permission(permissionId,roleId) values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("permissionId") String permissionId,@Param("roleId") String roleId);

    /**
     * 查询到角色中已经存在的权限
     * @param roleId
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission>  findExistPermission(@Param("roleId") String roleId);

    /**
     * 删除你所需要的删除的对应的角色的权限
     * @param permissionId
     * @param roleId
     */
    @Delete("delete from role_permission where permissionId = #{permissionId} and roleId = #{roleId}")
    void deletePermissionFromRole(@Param("permissionId") String permissionId,@Param("roleId") String roleId);
}
