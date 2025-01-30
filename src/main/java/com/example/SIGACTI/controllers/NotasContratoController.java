package com.example.SIGACTI.controllers;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Inexigibilidade;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.InexigibilidadeRepository;
import com.example.SIGACTI.model.repositories.NotasContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/notasContrato")
public class NotasContratoController {
    @Autowired
    private NotasContratoRepository notasContratoRepository;

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ProcessoRepository processoRepository;


    @PostMapping
    public ResponseEntity<NotasContrato> criarNotaContrato(@RequestBody Map<String, Object> payload) {
        // Obtém o contrato pelo ID informado no payload
        String contratoId = (String) payload.get("contrato");
        Optional<Contrato> contratoOpt = contratoRepository.findById(contratoId);

        if (!contratoOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Obtém o processo pelo ID informado no payload
        String processoId = (String) payload.get("processo");
        Optional<Processo> processoOpt = processoRepository.findById(processoId);

        if (!processoOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Criação da NotaContrato
        NotasContrato notaContrato = new NotasContrato();
        notaContrato.setNotaFiscal((String) payload.get("notaFiscal"));
        notaContrato.setContrato(contratoOpt.get());
        notaContrato.setProcesso(processoOpt.get()); // Pegando apenas a String do processo
        notaContrato.setObjeto((String) payload.get("objeto"));
        notaContrato.setContratado((String) payload.get("contratado"));
        notaContrato.setCnpj((String) payload.get("cnpj"));
        notaContrato.setValorContra(((Number) payload.get("valorContra")).doubleValue());
        notaContrato.setAtesto((String) payload.get("atesto"));
        notaContrato.setFiscalContrato((String) payload.get("fiscalContrato"));
        notaContrato.setGestorContrato((String) payload.get("gestorContrato"));

        NotasContrato novaNota = notasContratoRepository.save(notaContrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaNota);
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
