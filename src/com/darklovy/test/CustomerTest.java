package com.darklovy.test;

import com.darklovy.domain.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试类
 */
public class CustomerTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init(){
        //1. 创建配置对象,加载配置文件 hibernate.cfg.xml
        Configuration config = new Configuration().configure();

        //2. 创建SessionFactory 对象
        sessionFactory = config.buildSessionFactory();

        //3. 创建Session会话对象
        session  = sessionFactory.openSession();

        //4. 开启事务
        transaction = session.beginTransaction();
    }


    @Test
    public void testSaveCustomer(){
        CustomerEntity customer = new CustomerEntity();
        customer.setCustName("sgdfhfdfhdghdh");

        //5. 保存
        session.save(customer);//保存对象进入数据库
    }

    @After
    public void destory(){
        //6. 提交事务
        transaction.commit();
        //7. 关闭session 关闭sessionFactory
        session.close();
        sessionFactory.close();
    }
}
