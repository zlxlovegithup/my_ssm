package com.zlx.service.impl;

import com.zlx.dao.ICustomerDao;
import com.zlx.domain.Customer;
import com.zlx.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao iCustomerDao;

    public Customer getCustomerByAccount(Customer customer) {
        return iCustomerDao.getCustomerByAccount(customer);
    }
}
