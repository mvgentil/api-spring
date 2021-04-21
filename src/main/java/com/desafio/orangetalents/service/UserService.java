package com.desafio.orangetalents.service;

import com.desafio.orangetalents.model.Address;
import com.desafio.orangetalents.model.User;
import com.desafio.orangetalents.model.exception.UsuarioNotFoundException;
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

    public User addUsuario(User user){
            return userRepository.save(user);
    }

    public User getUsuario(Long id){
        return userRepository.findById(id).orElseThrow(() ->
                new UsuarioNotFoundException(id));
    }

    @Transactional
    public User addEnderecoToUsuario(Long usuarioId, Long enderecoId){
        User user = getUsuario(usuarioId);
        Address address = addressService.getEndereco(enderecoId);
            user.addEndereco(address);
        return user;
    }

}
