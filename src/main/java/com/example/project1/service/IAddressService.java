package com.example.project1.service;

import java.util.List;

import com.example.project1.bean.Address;

public interface IAddressService {
	
	List<Address> getAddressById(int id);
	Address delteAddressById(int id);
	Address updateAddress(Address address);
	Address addAddress(Address address);

}
