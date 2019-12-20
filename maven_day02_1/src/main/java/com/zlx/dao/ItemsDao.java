package com.zlx.dao;

import com.zlx.domain.Items;

/**
 * 持久化接口
 */
public interface ItemsDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Items findById(Integer id);
}
