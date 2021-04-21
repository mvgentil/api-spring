package com.desafio.orangetalents.controller;

import com.desafio.orangetalents.model.Address;
import com.desafio.orangetalents.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public Address addEndereco(@RequestBody Address address) {
        addressService.addEndereco(address);
        return address;
    }

}
