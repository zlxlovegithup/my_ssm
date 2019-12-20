package com.zlx.my_ssm.service;

import com.zlx.my_ssm.domain.SysLog;

import java.util.List;

/**
 * 日志信息业务层接口
 */
public interface ISysLogService {

    /**
     * 保存日志
     * @param sysLog
     */
    void save(SysLog sysLog) throws Exception;

    /**
     * 查询日志
     * @return
     * @throws Exception
     */
    public List<SysLog> findAll() throws Exception;
}
