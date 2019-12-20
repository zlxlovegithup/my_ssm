package com.zlx.my_ssm.service.impl;

import com.zlx.my_ssm.dao.ISysLogDao;
import com.zlx.my_ssm.domain.SysLog;
import com.zlx.my_ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 日志的业务层实现类
 */
@Service("sysLogService")
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao iSysLogDao;

    /**
     * 保存日志
     * @param sysLog
     */
    @Override
    public void save(SysLog sysLog) throws Exception {
        iSysLogDao.save(sysLog);
    }

    /**
     * 查询日志
     * @return
     * @throws Exception
     */
    @Override
    public List<SysLog> findAll() throws Exception {
        return iSysLogDao.findAll();
    }
}
