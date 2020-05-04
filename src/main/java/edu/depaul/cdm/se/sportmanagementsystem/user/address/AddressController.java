package edu.depaul.cdm.se.sportmanagementsystem.user.address;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class AddressController {
    @Autowired
    AddressService addressService;
    
    // get all addresses
    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok().body(addressService.getAllAddress());
    }

    // save address
    @PostMapping("/{user_id}/address")
    public ResponseEntity<Address> saveAddress(@PathVariable(name = "user_id") Long userID, @Valid @RequestBody Address address) {
        addressService.saveAddress(userID, address);

        return ResponseEntity.ok().body(address);
    }

    // update address
    @PutMapping("/{user_id}/address/{address_id}")
    public ResponseEntity<Address> updateAddress(@PathVariable(name = "user_id") Long userID, @PathVariable(name = "address_id") Long addressID, @Valid @RequestBody Address address) {
        addressService.updateAddress(userID, addressID, address);

        return ResponseEntity.ok().body(address);
    }
}