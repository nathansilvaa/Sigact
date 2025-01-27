package com.example.SIGACTI.controllers;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Inexigibilidade;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.repositories.InexigibilidadeRepository;
import com.example.SIGACTI.model.repositories.NotasContratoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/notasContrato")
public class NotasContratoController {
    @Autowired
    private NotasContratoRepository notasContratoRepository;


    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    public @ResponseBody NotasContrato novaNotaContrato(@Valid NotasContrato notasContrato){
        notasContratoRepository.save(notasContrato);
        return notasContrato;
    }

    @GetMapping(path = "/todos")
    public Iterable<NotasContrato> obterNotaContrato(){
        return notasContratoRepository.findAll();
    };
    //http://localhost:8080/api/processo?parteProcesso=2021
    @GetMapping(params = "parteNotaContrato")
    public Iterable<NotasContrato> ObterNotaContratoParteNome(@RequestParam String parteNotaFiscal){
        return notasContratoRepository.findByNotaFiscalContainingIgnoreCase(parteNotaFiscal);
    };

    //buscar NotasContrato
    @GetMapping
    public Optional<NotasContrato> obterNotasContrato(@RequestParam String notaFiscal){
        return notasContratoRepository.findById(Long.valueOf(notaFiscal));
    }

    @DeleteMapping(params = "inexigibilidade")
    public void removerNotaContrato(@RequestParam String notaContrato) {
        notasContratoRepository.deleteById(Long.valueOf(notaContrato));
    }
}
