package com.example.SIGACTI.controllers.notasContrato;

import com.example.SIGACTI.dto.NotasContratoRequest;
import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.services.notasContrato.UpdateNotasContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/notasContrato")
public class UpdateNotasContratoController {

    private final UpdateNotasContratoService service;

    public UpdateNotasContratoController(UpdateNotasContratoService service) {
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<NotasContratoResponse> atualizarNotasContrato(
            @RequestParam String notaFiscal,
            @RequestBody @Valid NotasContratoRequest notasContratoDto) {

        Optional<NotasContratoResponse> notasContratoAtualizada = service.atualizarNotasContrato(notaFiscal, notasContratoDto);

        return notasContratoAtualizada
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrar e atualizar a nota de contrato
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrar a nota de contrato
    }
}
