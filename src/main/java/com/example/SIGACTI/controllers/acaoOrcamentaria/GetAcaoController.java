package com.example.SIGACTI.controllers.acaoOrcamentaria;

import com.example.SIGACTI.dto.AcaoOrcamentariaResponse;
import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.services.acaoOrcamentaria.GetAcaoOrcamentariaService;
import com.example.SIGACTI.services.processo.GetProcessoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acao")
public class GetAcaoController {

    private final GetAcaoOrcamentariaService service;

    public GetAcaoController(GetAcaoOrcamentariaService service) {
        this.service = service;
    }


    @GetMapping("/todos")
    public ResponseEntity<List<AcaoOrcamentariaResponse>> obterTodasAcoes() {
        List<AcaoOrcamentariaResponse> acoes = service.obterTodasAcoes();
        return ResponseEntity.ok(acoes);
    }

    // Endpoint para buscar um processo específico pelo ID
    @GetMapping
    public ResponseEntity<AcaoOrcamentariaResponse> obterAcaoPorId(@RequestParam Long id) {
        Optional<AcaoOrcamentariaResponse> acao = service.obterProcessoPorId(id);
        return acao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}