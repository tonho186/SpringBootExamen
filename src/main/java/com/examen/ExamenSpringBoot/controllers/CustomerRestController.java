package com.examen.ExamenSpringBoot.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examen.ExamenSpringBoot.models.entity.Customers;
import com.examen.ExamenSpringBoot.models.services.ICustomerService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private ICustomerService customerService;

	@GetMapping("/customers")
	public List<Customers> index() {
		return customerService.findAll();
	}

//	@GetMapping("/customers/statistics")
//	public Customers show() {
//		
//	}

	@PostMapping("/customers")
	@ResponseStatus(HttpStatus.CREATED)
	public Customers create(@RequestBody Customers customer) {
		Date fechaActual = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    String hoy = formato.format(fechaActual);
	    String fecha_nac = formato.format(customer.getFechaNac());
	    String[] dat1 = fecha_nac.split("/");
	    String[] dat2 = hoy.split("/");
	    int anhos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
	    customer.setEdad(anhos);
		this.customerService.save(customer);
		return customer;
	}

}
