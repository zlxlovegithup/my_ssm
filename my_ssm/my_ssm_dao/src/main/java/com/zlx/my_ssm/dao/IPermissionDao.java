package com.zlx.my_ssm.dao;

import com.zlx.my_ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    /**
     * 通过角色id查询到对应角色对应的权限
     * @param roleId
     * @return
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findPermissionsByRoleId(@Param("roleId") String roleId);

    /**
     * 查询到所有的权限
     * @return
     */
    @Select("select * from permission")
    List<Permission> findAllPermissions();

    /**
     * 新增权限
     * @param permissionName
     * @param url
     */
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(@Param("permissionName") String permissionName, @Param("url") String url);

    /**
     * 删除对应的权限
     * @param permissionId
     */
    @Delete("delete from permission where id = #{permissionId}")
    void deletePermission(String permissionId);
}
