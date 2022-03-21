package com.example.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.bean.Address;
import com.example.project1.service.IAddressService;

@RestController
public class AddressController {
	
	@Autowired
	IAddressService addrServ;
	// Get Address by id
	@GetMapping("/addresses/{empId}")
	ResponseEntity<List<Address>> getAddressById(@PathVariable("empId") int id) {
		List<Address> addresses = addrServ.getAddressById(id);
		return new ResponseEntity<>(addresses, HttpStatus.OK); 
	};
	@DeleteMapping("/addresses/{id}")
	ResponseEntity<Address> delteAddressById(int id) {
		Address addr = addrServ.delteAddressById(id);
		return new ResponseEntity<>(addr, HttpStatus.OK);
	};
	
//	// Update Address
//	@PutMapping("/addresses")
//	Address updateAddress(Address address);
	
	@PostMapping("/addresses")
    ResponseEntity<Address> addAddress(@RequestBody Address address) {
		Address addr = addrServ.addAddress(address);
		return new ResponseEntity<>(addr, HttpStatus.OK);
	};


}
