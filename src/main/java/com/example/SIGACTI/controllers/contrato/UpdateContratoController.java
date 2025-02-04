package com.example.SIGACTI.controllers.contrato;

import com.example.SIGACTI.dto.ContratoRequest;
import com.example.SIGACTI.dto.ContratoResponse;
import com.example.SIGACTI.services.contrato.UpdateContratoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contrato")
public class UpdateContratoController {

    private final UpdateContratoService service;

    public UpdateContratoController(UpdateContratoService service) {
        this.service = service;
    }

    @PutMapping()
    public ResponseEntity<ContratoResponse> atualizarContrato(
            @RequestParam String idNumeroContrato,
            @RequestBody @Valid ContratoRequest contratoDto) {

        Optional<ContratoResponse> contratoAtualizado = service.atualizarContrato(idNumeroContrato, contratoDto);

        return contratoAtualizado
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrar e atualizar o contrato
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrar o contrato
    }
}