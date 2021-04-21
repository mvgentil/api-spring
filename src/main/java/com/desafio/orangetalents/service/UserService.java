package com.desafio.orangetalents.service;

import com.desafio.orangetalents.model.Address;
import com.desafio.orangetalents.model.User;
import com.desafio.orangetalents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressService addressService;

    @Autowired
    public UserService(UserRepository userRepository, AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }

    public User addUser(User user){
            return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException());
    }

    @Transactional
    public User addAddressToUser(Long userId, Long addressId){
        User user = getUser(userId);
        Address address = addressService.getAddress(addressId);
            user.addEndereco(address);
            return user;
    }

}
