package com.fse.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class TestController {

	/*@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping(value="test")
	@PostMapping("insert")
	public String insert() {
		Cart c = new Cart();
		c.setName("test");
		Items i = new Items();
		i.setName("test");
		Set<Items> si = new HashSet<>();
		c.setItems(si);
		//sessionFactory.getCurrentSession().saveOrUpdate(Cart.class);
		
		return "success";
	}*/
}
