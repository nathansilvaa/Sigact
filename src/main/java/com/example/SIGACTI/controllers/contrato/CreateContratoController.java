package com.example.SIGACTI.controllers.contrato;

import com.example.SIGACTI.dto.ContratoDto;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.services.contrato.CreateContratoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
    public ResponseEntity<Contrato> salvar(@RequestBody @Valid ContratoDto contratoDto) {
        // Converter DTO para Entidade
        Contrato contrato = service.converterDtoParaEntidade(contratoDto);

        // Salvar contrato no banco
        Contrato contratoSalvo = service.salvar(contrato);

        return ResponseEntity.ok(contratoSalvo);
    }
}
