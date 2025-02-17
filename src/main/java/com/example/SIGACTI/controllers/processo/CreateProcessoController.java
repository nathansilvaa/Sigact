package com.example.SIGACTI.controllers.processo;

import com.example.SIGACTI.dto.ProcessoRequest;
import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.services.processo.CreateProcessoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/processo")
public class CreateProcessoController {

    private final CreateProcessoService createProcessoService;

    public CreateProcessoController(CreateProcessoService createProcessoService) {
        this.createProcessoService = createProcessoService;
    }

    @PostMapping
    public ResponseEntity<ProcessoResponse> criarProcesso(@RequestBody @Valid ProcessoRequest processoRequest) {
        ProcessoResponse processoResponse = createProcessoService.criarProcesso(processoRequest);
        return ResponseEntity.ok(processoResponse);
    }
}