package com.chetan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.beans.Address;
import com.chetan.beans.Bank;
import com.chetan.entities.BankEntity;
import com.chetan.entities.CustomerEntity;
import com.chetan.services.CustomerService;
import com.chetan.util.GenericMessages;

@RestController
@RequestMapping("bank/address")
public class AddressController {

	@Autowired
	CustomerService addressService;
	
	static {
		System.out.println("Inside Address Controller...!");
	}
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public List<Address> fetchEntities() {
		return addressService.getAllAddresses();
	}	
	
	@RequestMapping(value = "/{eid}",method = RequestMethod.GET)
	public ResponseEntity fetchEntity(@PathVariable("eid") int eid) {
		return new ResponseEntity(addressService.getAddress(eid),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{eid}",method = RequestMethod.DELETE)
	public String removeEntity(@PathVariable("eid") int eid) {
		return addressService.deleteAddress(eid);
	}
	
	@RequestMapping(value = "/bank/",method = RequestMethod.GET)
	public ResponseEntity getBank() {
		List<CustomerEntity> entities = new ArrayList<CustomerEntity>();
		entities.add(new CustomerEntity(1111, "AAAAA"));
		entities.add(new CustomerEntity(22, "AAAAA"));
		entities.add(new CustomerEntity(3411, "AAAAA"));
		entities.add(new CustomerEntity(1411, "AAAAA"));
		BankEntity entity = new BankEntity(1111, "SBI", entities);
		return new ResponseEntity(entity,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public ResponseEntity saveEntity(@RequestBody Address address) {
		int  id= addressService.addAddress(address);
		if(id>0) {
			return new ResponseEntity(new GenericMessages("1111","Success"),HttpStatus.OK);
		}
		return new ResponseEntity(new GenericMessages("1111","Update Failed..!..!"),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{eid}",method = RequestMethod.PUT)
	public ResponseEntity updateEntity(@RequestBody Address address,@PathVariable("eid") int eid) {
		Address adr= addressService.updateAddress(address);
		if(adr==null)
			return new ResponseEntity(new GenericMessages("1111","Failed"),HttpStatus.OK);
		else
			return new ResponseEntity(new GenericMessages("1111","Success"),HttpStatus.OK);
		
	}
	
}
