package com.example.SIGACTI.controllers.compraDireta;

import com.example.SIGACTI.dto.CompraDiretaRequest;
import com.example.SIGACTI.dto.CompraDiretaResponse;
import com.example.SIGACTI.services.compraDireta.UpdateCompraDiretaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/compraDireta")
public class UpdateCompraDiretaController {

    private final UpdateCompraDiretaService service;

    public UpdateCompraDiretaController(UpdateCompraDiretaService service) {
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<CompraDiretaResponse> atualizarCompraDireta(
            @RequestParam String portaria,
            @RequestBody @Valid CompraDiretaRequest compraDiretaDto) {

        Optional<CompraDiretaResponse> compraDiretaAtualizada = service.atualizarCompraDireta(portaria, compraDiretaDto);

        return compraDiretaAtualizada
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrar e atualizar a compra direta
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrar a compra direta
    }
}
