package com.desafio.orangetalents.controller;

import com.desafio.orangetalents.model.User;
import com.desafio.orangetalents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User registerNewUser(@RequestBody User user) {
        userService.addUsuario(user);
        return user;
    }

    @GetMapping(value = "{id}")
    public User getUser(@PathVariable final Long id){
        User user = userService.getUsuario(id);
        return user;
    }

    @PostMapping(value = "{usuarioId}/enderecos/{enderecoId}/add")
    public User addAddressToUser(@PathVariable final Long userId,
                                 @PathVariable final Long addressId){
        User user = userService.addEnderecoToUsuario(userId, addressId);
        return user;
    }

}
