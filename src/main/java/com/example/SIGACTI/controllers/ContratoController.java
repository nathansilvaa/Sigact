package com.example.SIGACTI.controllers;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.entities.dto.ContratoDto;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/contrato")
public class ContratoController {
    @Autowired
    private ContratoRepository contratoRepository;
    @Autowired
    private ProcessoRepository processoRepository;

    @PostMapping
    public ResponseEntity<Contrato> criarContrato(@RequestBody Map<String, Object> payload) {
        String processoId = (String) payload.get("processo");
        Optional<Processo> processoOpt = processoRepository.findById(processoId);

        if (!processoOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Contrato contrato = new Contrato();
        contrato.setProcesso(processoOpt.get());
        contrato.setContrato((String) payload.get("contrato"));
        contrato.setOrcamento(new Date()); // Ajuste conforme necessário
        contrato.setAcaoOrcamentaria((Integer) payload.get("acaoOrcamentaria"));
        contrato.setFonteRecurso((Integer) payload.get("fonteRecurso"));
        contrato.setTipoContratacao((String) payload.get("tipoContratacao"));
        contrato.setContratado((String) payload.get("contratado"));
        contrato.setNumeroAltomatico((Integer) payload.get("numeroAltomatico"));
        contrato.setObjeto((String) payload.get("objeto"));
        contrato.setStatusContrato((String) payload.get("statusContrato"));
        contrato.setFunLegal((String) payload.get("funLegal"));
        contrato.setNaturezaServico((String) payload.get("naturezaServico"));
        contrato.setDataContrato(new Date()); // Ajuste conforme necessário
        contrato.setVigenciaInicial(new Date()); // Ajuste conforme necessário
        contrato.setValorContrato(((Number) payload.get("valorContrato")).doubleValue());
        contrato.setSaldo(((Number) payload.get("saldo")).doubleValue());
        contrato.setConsumido(((Number) payload.get("consumido")).floatValue());

        Contrato novoContrato = contratoRepository.save(contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoContrato);
    }


    //    @GetMapping(path = "/todos")
//    public Iterable<Contrato> obterContrato(){
//        return contratoRepository.findAll();
//    };
    //http://localhost:8080/api/processo?parteProcesso=2021
    @GetMapping(params = "parteContrato")
    public Iterable<Contrato> ObterContratoPorParteNome(@RequestParam String parteContrato){
        return contratoRepository.findByContratoContainingIgnoreCase(parteContrato);
    };

    //buscar contrato
    @GetMapping
    public ResponseEntity<?> obterContrato(@RequestParam(required = false) String contrato) {
        if(contrato == null) {
            return ResponseEntity.ok(contratoRepository.findAll());
        }
        Optional<Contrato> contrato2 = contratoRepository.findById(contrato);
        return contrato2.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(params = "contrato")
    public void removerContrato(@RequestParam String contrato){
        contratoRepository.deleteById(contrato);
    }
}
