package com.example.SIGACTI.controllers.NotasCompraDireta;

import com.example.SIGACTI.dto.NotasCompraDiretaRequest;
import com.example.SIGACTI.dto.NotasCompraDiretaResponse;
import com.example.SIGACTI.services.notasCompraDireta.UpdateNotaCompraDiretaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/notasCompraDireta")
public class UpdateNotaCompraDiretaController {

    private final UpdateNotaCompraDiretaService service;

    public UpdateNotaCompraDiretaController(UpdateNotaCompraDiretaService service) {
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<NotasCompraDiretaResponse> atualizarNotaCompraDireta(
            @RequestParam String notaFiscal,
            @RequestBody @Valid NotasCompraDiretaRequest request) {

        Optional<NotasCompraDiretaResponse> notaAtualizada = service.atualizarNotaCompraDireta(notaFiscal, request);

        return notaAtualizada
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrar e atualizar a nota
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrar a nota
    }
}
