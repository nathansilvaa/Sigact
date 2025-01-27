package com.example.SIGACTI.controllers;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Inexigibilidade;
import com.example.SIGACTI.model.repositories.InexigibilidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/inexigibilidade")
public class InexigibilidadeController {
    @Autowired
    private InexigibilidadeRepository inexigibilidadeRepository;


    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    public @ResponseBody Inexigibilidade novaInexigibilidade(@Valid Inexigibilidade inexigibilidade){
        inexigibilidadeRepository.save(inexigibilidade);
        return inexigibilidade;
    }

    @GetMapping(path = "/todos")
    public Iterable<Inexigibilidade> obterInexigibilidade(){
        return inexigibilidadeRepository.findAll();
    };
    //http://localhost:8080/api/processo?parteProcesso=2021
    @GetMapping(params = "parteInexigibilidade")
    public Iterable<Inexigibilidade> ObterInexigibilidadePorParteNome(@RequestParam String portaria){
        return inexigibilidadeRepository.findByPortariaContainingIgnoreCase(portaria);
    };

    //buscar inexigibilidade
    @GetMapping
    public Optional<Inexigibilidade> obterInexigibilidade(@RequestParam String contrato){
        return inexigibilidadeRepository.findById(contrato);
    }

    @DeleteMapping(params = "inexigibilidade")
    public void removerInexigibilidade(@RequestParam String portaria) {
        inexigibilidadeRepository.deleteById(portaria);
    }


}
