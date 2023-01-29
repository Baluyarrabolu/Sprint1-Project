package com.balu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balu.entity.Address;
import com.balu.repository.AddressRepository;
import com.balu.util.AddressConverter;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	AddressConverter addressConverter;
	
	public String createAddress(Address address) {
		String message=null;
		addressRepository.save(address);
		if(address!=null)
		{
			message="New address saved successfully!!";
		}
		else
		{
			message="Address was not saved!!";
		}
		return message;
	}
	
}
