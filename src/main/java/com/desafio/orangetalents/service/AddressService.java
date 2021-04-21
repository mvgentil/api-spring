package com.desafio.orangetalents.service;

import com.desafio.orangetalents.model.Address;
import com.desafio.orangetalents.model.exception.EnderecoNotFoundException;
import com.desafio.orangetalents.repository.AddressRepository;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addEndereco(Address address){
            return addressRepository.save(address);
    }

    public Address getEndereco(Long id){
        return addressRepository.findById(id).orElseThrow(() ->
                new EnderecoNotFoundException(id));
    }

    public List<Address> getEnderecos(){
        return StreamSupport
                .stream(addressRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
