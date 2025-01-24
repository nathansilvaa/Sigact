package com.example.SIGACTI.controllers;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/contrato")
public class ContratoController {
    @Autowired
    private ContratoRepository contratoRepository;
    @Autowired
    private ProcessoRepository processoRepository;

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    public @ResponseBody Contrato novoContrato(@Valid Contrato contrato){
        contratoRepository.save(contrato);
        return contrato;
    }

    @GetMapping(path = "/todos")
    public Iterable<Contrato> obterContrato(){
        return contratoRepository.findAll();
    };
    //http://localhost:8080/api/processo?parteProcesso=2021
    @GetMapping(params = "parteContrato")
    public Iterable<Contrato> ObterContratoPorParteNome(@RequestParam String parteContrato){
        return contratoRepository.findByContratoContainingIgnoreCase(parteContrato);
    };

    //buscar contrato
    @GetMapping
    public Optional<Contrato> obterContrato(@RequestParam String contrato){
        return contratoRepository.findById(contrato);
    }

    @DeleteMapping(params = "contrato")
    public void removerContrato(@RequestParam String contrato){
        contratoRepository.deleteById(contrato);
    }
}
