package com.examen.ExamenSpringBoot.models.services;

import java.util.List;

import com.examen.ExamenSpringBoot.models.entity.Customers;

public interface ICustomerService {
	
	public List<Customers> findAll();
	
	public void save(Customers empleado);

}
