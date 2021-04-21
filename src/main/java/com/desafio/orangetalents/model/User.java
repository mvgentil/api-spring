package com.desafio.orangetalents.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String CPF;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Address> addresses = new ArrayList<>();


    public void addEndereco(Address address){
        addresses.add(address);
    }

    public User(){
    }

}
