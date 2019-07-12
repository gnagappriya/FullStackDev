package com.fse.test;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public java.util.List<Employee> getEmployeeList() {
    	
        return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
    }
    
    
    public void add(Employee e) {
    	sessionFactory.getCurrentSession().saveOrUpdate(e);
    }
    
    public void addCart(Cart c) {
    	sessionFactory.getCurrentSession().saveOrUpdate(c);
    }
}
