package com.example.SIGACTI.controllers.contrato;

import com.example.SIGACTI.dto.ContratoRequest;
import com.example.SIGACTI.dto.ContratoResponse;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.services.contrato.CreateContratoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/contrato")
public class CreateContratoController {

    private final CreateContratoService service;

    public CreateContratoController(CreateContratoService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<ContratoResponse> salvar(@RequestBody @Valid ContratoRequest contratoDto) {
        // Converter DTO para Entidade
        ContratoResponse contrato = service.salvar(contratoDto);

        return ResponseEntity.ok(contrato);
    }
}
