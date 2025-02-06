package com.example.SIGACTI.controllers.processo;

import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.services.processo.GetProcessoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/processo")
public class GetProcessoController {

    private final GetProcessoService service;

    public GetProcessoController(GetProcessoService service) {
        this.service = service;
    }

    // Endpoint para buscar todos os processos
    @GetMapping("/todos")
    public ResponseEntity<List<ProcessoResponse>> obterTodosProcessos() {
        List<ProcessoResponse> processos = service.obterTodosProcessos();
        return ResponseEntity.ok(processos);
    }

    // Endpoint para buscar um processo específico pelo ID
    @GetMapping
    public ResponseEntity<ProcessoResponse> obterProcessoPorId(@RequestParam String idProcesso) {
        Optional<ProcessoResponse> processo = service.obterProcessoPorId(idProcesso);
        return processo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}