package edu.depaul.cdm.se.sportmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se.sportmanagementsystem.model.Address;
import edu.depaul.cdm.se.sportmanagementsystem.model.User;
import edu.depaul.cdm.se.sportmanagementsystem.repository.AddressRepository;
import edu.depaul.cdm.se.sportmanagementsystem.repository.UserRepository;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    // get address 
    public Address getAddress(Long id) {
        return addressRepository.findById(id).get();
    }

    // get addresses
    public List<Address> getAllAddress() {
        final List<Address> addresses = new ArrayList<Address>();

        addressRepository.findAll().forEach(address -> addresses.add(address));

        return addresses;
    }

    // save/update address
    public void addAddress(Address address) {
        // User user = userRepository.findById(address.getUser().getUserID()).get();
        
        // user.setAddress(address);
        // address.setUser(user);
        addressRepository.save(address);
        // userRepository.save(user);
    }

    // delete address
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
