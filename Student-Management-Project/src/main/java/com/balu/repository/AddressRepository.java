package com.balu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balu.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
