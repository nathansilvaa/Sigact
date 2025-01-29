package com.example.SIGACTI.controllers;

import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/processo")
public class ProcessoController {
    @Autowired
    private ProcessoRepository processoRepository;

    @PostMapping
    public @ResponseBody Processo novoProcesso(@RequestBody @Valid Processo processo){
        processoRepository.save(processo);
        return processo;
    }
    @GetMapping("/todos")
    public Iterable<Processo> obterProcessos(){
        return processoRepository.findAll();
    };

    //http://localhost:8080/api/processo?parteProcesso=2021
    @GetMapping(params = "parteProcesso")
    public Iterable<Processo> ObterProcessosPorNome(@RequestParam String parteProcesso){
        return processoRepository.findByProcessoContainingIgnoreCase(parteProcesso);
    };
    //buscar processo
    @GetMapping
    public Optional<Processo> obterProcesso(@RequestParam String processo){
        return processoRepository.findById(processo);
    }

    @DeleteMapping(params = "processo")
    public void excluirProcesso(@RequestParam String processo){
        processoRepository.deleteById(processo);
    }

}

