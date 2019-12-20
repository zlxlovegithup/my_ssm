package com.zlx.my_ssm.dao;

import com.zlx.my_ssm.domain.Role;
import com.zlx.my_ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * 用户的持久层方法
 */
public interface IUserDao {
    /**
     * 通过用户名查询到用户信息以及关联的角色信息
     * @param username
     * @return
     *  private String id;  //主键UUID 无意义
     *     private String username;//用户名
     *     private String email;//邮箱
     *     private String password;//密码
     *     private String phoneNum;//电话号码
     *     private String status;//状态(0 未开启 1 已经开启)
     *     private String statusStr;//状态(字符串类型,方便在前端页面上进行展示)
     *     private List<Role> roles; //用户和角色是多对多的关系
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            //用户与角色是多对多的关系
            @Result(column = "id",property = "roles",javaType = java.util.List.class,many=@Many(select = "com.zlx.my_ssm.dao.IRoleDao.findRolesByUserId"))
    })
    UserInfo findUserByUsername(String username);

    /**
     * 查询所有的用户
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAllUsers();

    /**
     * 保存用户
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(@Param("email") String email,@Param("username") String username,@Param("password") String password,@Param("phoneNum") String phoneNum,@Param("status") Integer status);

    /**
     * 通过用户id查询到用户信息和关联的角色信息
     * @return
     */
    @Select("select * from users where id = #{userId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class,many=@Many(select = "com.zlx.my_ssm.dao.IRoleDao.findRolesByUserId"))
    })
    UserInfo findUserById(String userId);

    /**
     * 通过用户id查询到可以为用户添加的其他的角色(已经添加的角色不需要查询出来)
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId);

    /**
     * 通过用户id查询对应用户已经添加的角色(已经添加到用户中的角色需要查询出来)
     * @param userId
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    List<Role> findExistRoles(String userId);

    /**
     * 将查询到的尚未给用户添加的角色而添加给用户
     * @param userId
     * @param roleId
     * 注意：当有多个值需要设置进入SQL时，需要使用@Param指定参数
     * 将查询到的角色插入到用户-角色表中
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 从用户中删除对应角色
     * @param userId
     * @param roleId
     */
    @Delete("delete from users_role where userId = #{userId} and roleId = #{roleId}")
    void deleteRoleFromUser(@Param("userId") String userId, @Param("roleId") String roleId);

}



















