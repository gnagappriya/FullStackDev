package com.fse.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @RequestMapping("/getEmployeeList")
    public java.util.List getEmployeeList() {
    	Employee e = new Employee();
    	e.setEmployeeName("test");
    	e.setEmployeeRole("test");;
    	employeeDAO.add(e);
    	
    	Cart c = new Cart();
    	c.setName("test");
    	
    	Items i = new Items();
    	i.setName("test");
    	c.setItems(Arrays.asList(i));
    	c.addItems(i);
    	employeeDAO.addCart(c);
        return employeeDAO.getEmployeeList();
    }
}
