package com.example.SIGACTI.controllers;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Inexigibilidade;
import com.example.SIGACTI.model.entities.NotasInexigibilidade;
import com.example.SIGACTI.model.repositories.InexigibilidadeRepository;
import com.example.SIGACTI.model.repositories.NotasInexigibilidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/notasInexigibilidade")
public class NotasInexigibilidadeController {

    @Autowired
    private NotasInexigibilidadeRepository notasInexigibilidadeRepository;


    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    public @ResponseBody NotasInexigibilidade novaNotaInexigibilidade(@RequestBody @Valid NotasInexigibilidade notasInexigibilidade){
        notasInexigibilidadeRepository.save(notasInexigibilidade);
        return notasInexigibilidade;
    }

    @GetMapping(path = "/todos")
    public Iterable<NotasInexigibilidade> obterNotasInexigibilidade(){
        return notasInexigibilidadeRepository.findAll();
    };
    //http://localhost:8080/api/processo?parteProcesso=2021
    @GetMapping(params = "parteNotaInexigibilidade")
    public Iterable<NotasInexigibilidade> ObterNotaInexigibilidadePorParteNome(@RequestParam String parteNotaFiscal){
        return notasInexigibilidadeRepository.findByNotaFiscalContainingIgnoreCase(parteNotaFiscal);
    };

    //buscar inexigibilidade
    @GetMapping
    public Optional<NotasInexigibilidade> obterNotaInexigibilidade(@RequestParam String notaInexigibilidade){
        return notasInexigibilidadeRepository.findById(Long.valueOf(notaInexigibilidade));
    }

    @DeleteMapping(params = "notaInexigibilidade")
    public void removerNotaInexigibilidade(@RequestParam String notaInexigibilidade) {
        notasInexigibilidadeRepository.deleteById(Long.valueOf(notaInexigibilidade));
    }
}
