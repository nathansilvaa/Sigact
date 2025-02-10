package com.example.SIGACTI.controllers.NotasCompraDireta;


import com.example.SIGACTI.dto.NotasCompraDiretaRequest;
import com.example.SIGACTI.dto.NotasCompraDiretaResponse;

import com.example.SIGACTI.services.notasCompraDireta.CreateNotaCompraDiretaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notaCompraDireta")
public class CreateNotaCompraDiretaController {

    private final CreateNotaCompraDiretaService service;

    public CreateNotaCompraDiretaController(CreateNotaCompraDiretaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<NotasCompraDiretaResponse> salvar(@RequestBody @Valid NotasCompraDiretaRequest request) {
        NotasCompraDiretaResponse response = service.salvar(request);

        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
