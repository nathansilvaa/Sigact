package com.example.SIGACTI.controllers;

import com.example.SIGACTI.models.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {
    @GetMapping(path = "/qualquer")
    public Cliente obterCliente(){
        return new Cliente(28,"Pedro", "111-1111-111-12");
    }

}
