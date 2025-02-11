package com.example.SIGACTI.controllers.processo;

import com.example.SIGACTI.dto.ProcessoRequest;
import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.services.processo.UpdateProcessoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/processo")
public class UpdateProcessoController {

    private final UpdateProcessoService service;

    public UpdateProcessoController(UpdateProcessoService service) {
        this.service = service;
    }

    // Endpoint para atualizar um processo existente
    @PutMapping
    public ResponseEntity<ProcessoResponse> atualizarProcesso(
            @RequestParam Long idProcesso,
            @RequestBody @Valid ProcessoRequest request) {

        Optional<ProcessoResponse> processoAtualizado = service.atualizarProcesso(idProcesso, request);

        return processoAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}