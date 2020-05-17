package edu.depaul.cdm.se.sportmanagementsystem.user.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import edu.depaul.cdm.se.sportmanagementsystem.user.UserRepository;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    // get all address
    public List<Address> getAllAddress() {
        List<Address> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);

        return addresses;
    }

    // save address
    public Address saveAddress(Long userID, Address address) {
        User user = userRepository.findById(userID).get();
        user.setAddress(address);

        return addressRepository.save(address);
    }

	public Address updateAddress(Long userID, Long addressID, Address address) {
        User user = userRepository.findById(userID).get();

        user.setId(userID);
        address.setId(addressID);

        return addressRepository.save(address);
	}
}
