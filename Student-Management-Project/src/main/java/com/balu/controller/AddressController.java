package com.balu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balu.entity.Address;
import com.balu.model.AddressDTO;
import com.balu.service.AddressService;
import com.balu.util.AddressConverter;

@RestController
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressConverter addressConverter;
	
	@PostMapping("/createAddress")
	public String createAddress(@RequestBody AddressDTO addressDTO)
	{
		final Address address= addressConverter.convertToAddressEntity(addressDTO);
		return addressService.createAddress(address);
	}

}
