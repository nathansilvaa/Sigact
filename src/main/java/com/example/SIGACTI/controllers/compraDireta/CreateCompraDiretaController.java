package com.example.SIGACTI.controllers.compraDireta;

import com.example.SIGACTI.dto.CompraDiretaRequest;
import com.example.SIGACTI.dto.CompraDiretaResponse;
import com.example.SIGACTI.services.compraDireta.CreateCompraDiretaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compraDireta")
public class CreateCompraDiretaController {

    private final CreateCompraDiretaService service;

    public CreateCompraDiretaController(CreateCompraDiretaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CompraDiretaResponse> salvar(@RequestBody @Valid CompraDiretaRequest compraDiretaRequest) {
        // Converter DTO para Entidade e salvar
        CompraDiretaResponse compraDireta = service.salvar(compraDiretaRequest);

        if (compraDireta != null) {
            return ResponseEntity.ok(compraDireta);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
