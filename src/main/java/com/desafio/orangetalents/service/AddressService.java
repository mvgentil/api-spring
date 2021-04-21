package com.desafio.orangetalents.service;

import com.desafio.orangetalents.model.Address;
import com.desafio.orangetalents.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(Address address){
            return addressRepository.save(address);
    }

    public Address getAddress(Long id){
        return addressRepository.findById(id).orElseThrow(() ->
                new RuntimeException());
    }

    public List<Address> getAddresses(){
        return StreamSupport
                .stream(addressRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
