package com.example.SIGACTI.controllers;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Inexigibilidade;
import com.example.SIGACTI.model.entities.NotasInexigibilidade;
import com.example.SIGACTI.model.repositories.InexigibilidadeRepository;
import com.example.SIGACTI.model.repositories.NotasInexigibilidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/notasInexigibilidade")
public class NotasInexigibilidadeController {

    @Autowired
    private NotasInexigibilidadeRepository notasInexigibilidadeRepository;
    @Autowired
    private InexigibilidadeRepository inexigibilidadeRepository;

    @PostMapping
    public ResponseEntity<NotasInexigibilidade> criarNotasInexigibilidade(@RequestBody Map<String, Object> payload) {
        String portariaId = (String) payload.get("portaria");
        Optional<Inexigibilidade> inexigibilidadeOpt = inexigibilidadeRepository.findById(portariaId);

        // Se a inexigibilidade não existir, criamos uma nova entrada
        Inexigibilidade inexigibilidade = inexigibilidadeOpt.orElseGet(() -> {
            Inexigibilidade novaInexigibilidade = new Inexigibilidade();
            novaInexigibilidade.setPortaria(portariaId);
            // Define valores padrão ou obtidos do payload, se necessário
            novaInexigibilidade.setObjeto("Objeto não especificado");
            novaInexigibilidade.setResumoObjeto("Resumo não informado");
            novaInexigibilidade.setStatusContrato("Pendente");
            novaInexigibilidade.setProcesso(null); // Se não houver processo no JSON, pode ser ajustado depois
            return inexigibilidadeRepository.save(novaInexigibilidade);
        });

        NotasInexigibilidade nota = new NotasInexigibilidade();
        nota.setNotaFiscal((String) payload.get("notaFiscal"));
        nota.setInexigibilidade(inexigibilidade);  // Referencia a inexigibilidade existente ou criada
        nota.setSgd((String) payload.get("sgd"));
        nota.setProcesso((String) payload.get("processo"));
        nota.setUnidade((String) payload.get("unidade"));
        nota.setObjeto((String) payload.get("objeto"));
        nota.setContratado((String) payload.get("contratado"));
        nota.setCnpj((String) payload.get("cnpj"));
        nota.setValorTotal(((Number) payload.get("valorTotal")).doubleValue());
        nota.setEmissao(new Date()); // Ajuste conforme necessário
        nota.setAtesto((String) payload.get("atesto"));
        nota.setResponsavelRecebimento((String) payload.get("responsavelRecebimento"));

        NotasInexigibilidade novaNota = notasInexigibilidadeRepository.save(nota);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaNota);
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
