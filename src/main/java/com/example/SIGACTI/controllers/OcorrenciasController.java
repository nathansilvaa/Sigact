package com.example.SIGACTI.controllers;

import com.example.SIGACTI.dto.NotasContratoRequest;
import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.dto.OcorreciasRequest;
import com.example.SIGACTI.dto.OcorrenciaResponse;
import com.example.SIGACTI.services.ocorrencias.CreateOcorrenciasService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ocorrencia")
public class OcorrenciasController {
    private final CreateOcorrenciasService service;

    public OcorrenciasController(CreateOcorrenciasService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OcorrenciaResponse> salvar(@RequestBody @Valid OcorreciasRequest ocorreciasRequest) {
        OcorrenciaResponse response = service.salvar(ocorreciasRequest);
        if (response == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response);
    }
}
