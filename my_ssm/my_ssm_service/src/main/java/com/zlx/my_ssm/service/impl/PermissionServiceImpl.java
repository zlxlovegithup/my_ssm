package com.zlx.my_ssm.service.impl;

import com.zlx.my_ssm.dao.IPermissionDao;
import com.zlx.my_ssm.domain.Permission;
import com.zlx.my_ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao iPermissionDao;

    /**
     * 查询到所有的权限
     * @return
     */
    @Override
    public List<Permission> findAllPermissions() {
        return iPermissionDao.findAllPermissions();
    }

    /**
     * 新增权限
     * @param permissionName
     * @param url
     */
    @Override
    public void save(String permissionName, String url) {
        iPermissionDao.save(permissionName, url);
    }

    /**
     * 删除对应的权限
     * @param permissionId
     */
    @Override
    public void deletePermission(String permissionId) {
        iPermissionDao.deletePermission(permissionId);
    }
}
