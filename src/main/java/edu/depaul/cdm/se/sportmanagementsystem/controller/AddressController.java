package edu.depaul.cdm.se.sportmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se.sportmanagementsystem.model.Address;
import edu.depaul.cdm.se.sportmanagementsystem.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	
	// get a user
	@GetMapping("/address/{id}")
	public Address getAddressById(@PathVariable("id") Long id) {
		return addressService.getAddress(id);
	}
	
	// get all users
	@GetMapping("/address")
	public List<Address> getAllAddresses() {
		return addressService.getAllAddress();
	}
	
	// save user
	@PostMapping("/address")
	public Long saveUser(@RequestBody Address address) {
		addressService.addAddress(address);
		
		return address.getAddressID();
	}
	
	// delete user
	@DeleteMapping("/address/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		addressService.deleteAddress(id);
	}
}
