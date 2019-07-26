package com.examen.ExamenSpringBoot.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.examen.ExamenSpringBoot.models.entity.Customers;

public interface ICustomerDao extends CrudRepository<Customers, Long> {

}
