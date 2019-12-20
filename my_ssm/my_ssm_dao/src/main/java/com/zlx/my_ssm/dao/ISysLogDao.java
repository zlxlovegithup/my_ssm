package com.zlx.my_ssm.dao;

import com.zlx.my_ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 日志的持久层接口
 */
public interface ISysLogDao {
    /**
     * 保存日志
     * @param sysLog
     */
    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;


    /**
     * 查询日志
     * @return
     */
    @Select("select * from sysLog")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "id",property = "id"),
            @Result(column = "visitTime",property = "visitTime"),
            @Result(column = "username",property = "username"),
            @Result(column = "ip",property = "ip"),
            @Result(column = "method",property = "method"),
            @Result(column = "url",property = "url")
    })
    List<SysLog> findAll() throws Exception;
}
