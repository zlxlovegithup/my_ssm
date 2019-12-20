package com.zlx.my_ssm.service.impl;

import com.zlx.my_ssm.dao.IProductDao;
import com.zlx.my_ssm.domain.Product;
import com.zlx.my_ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productServiceImpl") //将ProductServiceImpl交给Spring容器管理
@Transactional // 进行事务的控制(因为数据库中记录的增删改都需要进行数据库的控制)
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() throws Exception {
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) {
       iProductDao.save(product);
    }
}
