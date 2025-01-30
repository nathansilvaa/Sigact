package com.example.SIGACTI.controllers;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Inexigibilidade;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.InexigibilidadeRepository;
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
@RequestMapping("/api/inexigibilidade")
public class InexigibilidadeController {
    @Autowired
    private InexigibilidadeRepository inexigibilidadeRepository;

    @Autowired
    private ProcessoRepository processoRepository;


    @PostMapping
    public ResponseEntity<Inexigibilidade> criarInexigibilidade(@RequestBody Map<String, Object> payload) {
        String processoId = (String) payload.get("processo");
        Optional<Processo> processoOpt = processoRepository.findById(processoId);

        if (!processoOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Inexigibilidade inexigibilidade = new Inexigibilidade();
        inexigibilidade.setProcesso(processoOpt.get());
        inexigibilidade.setPortaria((String) payload.get("portaria"));
        inexigibilidade.setResumoObjeto((String) payload.get("resumoObjeto"));
        inexigibilidade.setInteressado((String) payload.get("interessado"));
        inexigibilidade.setSgd((String) payload.get("sgd"));
        inexigibilidade.setObjeto((String) payload.get("objeto"));
        inexigibilidade.setStatusContrato((String) payload.get("statusContrato"));
        inexigibilidade.setFunLegal((String) payload.get("funLegal"));
        inexigibilidade.setNaturezaServiço((String) payload.get("naturezaServiço"));
        inexigibilidade.setDataContrato(new Date()); // Ajuste conforme necessário
        inexigibilidade.setVigencia(new Date()); // Ajuste conforme necessário
        inexigibilidade.setValorContrato(((Number) payload.get("valorContrato")).doubleValue());
        inexigibilidade.setSaldo(((Number) payload.get("saldo")).doubleValue());
        inexigibilidade.setConsumido(((Number) payload.get("consumido")).floatValue());
        inexigibilidade.setSituacaoVigencia((String) payload.get("situacaoVigencia"));

        Inexigibilidade novaInexigibilidade = inexigibilidadeRepository.save(inexigibilidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaInexigibilidade);
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
