package com.example.demo;

import com.example.demo.domain.Address;
import com.example.demo.domain.AddressRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    private final AddressRepository repository;

    public AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/addresses")
    Address createNewAddress(@RequestBody Address newAddress){
        return repository.save(newAddress);
    }

    @GetMapping("/addresses/{id}")
    Address getAddress(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PutMapping("/addresses/{id}")
    Address replaceEmployee(@RequestBody Address newAddress, @PathVariable Long id) {

        return repository.findById(id)
                .map(address -> {
                    address.setCity(newAddress.getCity());
                    address.setPostalCode(newAddress.getPostalCode());
                    return repository.save(address);
                })
                .orElseGet(() -> {
                    return repository.save(newAddress);
                });
    }

    //curl -X POST --header 'Content-Type: application/json' -d '{ "name": "John Doe", "city": "Berlin", "postalCode": "10585" }'  http://localhost:8080/addresses
}
