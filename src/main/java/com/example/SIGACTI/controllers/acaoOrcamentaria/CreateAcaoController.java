package com.example.SIGACTI.controllers.acaoOrcamentaria;

import com.example.SIGACTI.dto.AcaoOrcamentariaRequest;
import com.example.SIGACTI.dto.AcaoOrcamentariaResponse;
import com.example.SIGACTI.dto.ProcessoRequest;
import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.services.acaoOrcamentaria.CreateAcaoOrcamentariaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acao")
public class CreateAcaoController {


    private final CreateAcaoOrcamentariaService acaoOrcamentariaService;
    private final CreateAcaoOrcamentariaService createAcaoOrcamentariaService;

    public CreateAcaoController(CreateAcaoOrcamentariaService acaoOrcamentariaService, CreateAcaoOrcamentariaService createAcaoOrcamentariaService) {
        this.acaoOrcamentariaService = acaoOrcamentariaService;
        this.createAcaoOrcamentariaService = createAcaoOrcamentariaService;
    }

    @PostMapping
    public ResponseEntity<AcaoOrcamentariaResponse> criarProcesso(@RequestBody @Valid AcaoOrcamentariaRequest acaoOrcamentariaRequest) {
        AcaoOrcamentariaResponse acaoOrcamentariaResponse = createAcaoOrcamentariaService.criarAcao(acaoOrcamentariaRequest);
        return ResponseEntity.ok(acaoOrcamentariaResponse);
    }
}
