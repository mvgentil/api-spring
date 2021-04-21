package com.desafio.orangetalents.controller;

import com.desafio.orangetalents.model.User;
import com.desafio.orangetalents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            userService.addUser(user);
            return user;
    }

    @GetMapping(value = "{id}")
    public User getUser(@PathVariable final Long id){
            User user = userService.getUser(id);
            return user;
    }

    @PostMapping(value = "{userId}/enderecos/{addressId}/add")
    public User addAddressToUser(@PathVariable final Long userId,
                                 @PathVariable final Long addressId){
            User user = userService.addAddressToUser(userId, addressId);
            return user;
    }

}
