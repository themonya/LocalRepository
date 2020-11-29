package com.chetan.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.beans.Customer;

@RestController
@RequestMapping("bank/customer")
public class CustomerController {



	@RequestMapping(value = "/",method = RequestMethod.GET)
	public void fetchEntities() {
		
	}
	
	@RequestMapping(value = "/{eid}",method = RequestMethod.GET)
	public void fetchEntity(@PathVariable("eid") int eid) {
		
	}
	
	@RequestMapping(value = "/{eid}",method = RequestMethod.DELETE)
	public void removeEntity(@PathVariable("eid") int eid) {
		
	}
	
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public void saveEntity(@RequestBody Customer cust) {
		
	}
	
	@RequestMapping(value = "/{eid}",method = RequestMethod.PUT)
	public void updateEntity(@RequestBody Customer cust,@PathVariable("eid") int eid) {
		
	}
	

}
