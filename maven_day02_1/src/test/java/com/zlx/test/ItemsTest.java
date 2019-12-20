package com.zlx.test;

import com.zlx.dao.ItemsDao;
import com.zlx.domain.Items;
import com.zlx.service.ItemsService;
import com.zlx.service.impl.ItemsServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsTest {
    @Test
    public void findById(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //测试dao
        System.out.println("==============测试dao=============");
        //从容器中拿到所需的dao的代理对象
        ItemsDao itemsDao = applicationContext.getBean(ItemsDao.class);
        //调用方法
        Items items = itemsDao.findById(1);
        System.out.println(items);
        //测试service
        System.out.println("==============测试service=============");
        ItemsService itemsService = applicationContext.getBean(ItemsService.class);
        Items service = itemsService.findById(1);
        System.out.println(service);
    }
}
