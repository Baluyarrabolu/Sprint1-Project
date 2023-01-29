package com.balu.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.balu.entity.Address;
import com.balu.model.AddressDTO;

@Component
public class AddressConverter {

	//convert from addressDTO to entity(address)
	public Address convertToAddressEntity(AddressDTO addressDTO)
	{
		Address address = new Address();
		if(addressDTO!=null)
		{
			BeanUtils.copyProperties(addressDTO, address);
		}
		return address;
	}
	
	//convert from entity to addressDTO
	public AddressDTO convertToAddressDTO(Address address)
	{
		AddressDTO addressDTO = new AddressDTO();
		if(address!=null)
		{
			BeanUtils.copyProperties(address, addressDTO);
		}
		return addressDTO;
	}
}