package com.balu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

	private int id;
	
	@NotNull
	@Size(min=1)
	private String city;
	
	@NotNull
	@Size(min=1)
	private String state;
	
	@NotNull
	@Size(min=1, max=10)
	private int pincode;
}