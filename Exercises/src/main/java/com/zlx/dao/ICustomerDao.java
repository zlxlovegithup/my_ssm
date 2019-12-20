package com.zlx.dao;
import com.zlx.domain.Customer;

public interface ICustomerDao {
	Customer getCustomerByAccount(Customer customer);
}
