package com.examen.ExamenSpringBoot.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.ExamenSpringBoot.models.dao.ICustomerDao;
import com.examen.ExamenSpringBoot.models.entity.Customers;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public List<Customers> findAll() {
		// TODO Auto-generated method stub
		return (List<Customers>) customerDao.findAll();
	}

	@Override
	public void save(Customers customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
	}

}
