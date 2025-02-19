package com.example.SIGACTI.controllers.itemContrato;

import com.example.SIGACTI.dto.ItemContratoRequest;
import com.example.SIGACTI.dto.ItemContratoResponse;
import com.example.SIGACTI.services.itemContrato.CreateItemContratoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemContrato")
public class CreateItemContratoController {
    private final CreateItemContratoService service;

    public CreateItemContratoController(CreateItemContratoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<ItemContratoResponse> salvar(@RequestBody @Valid ItemContratoRequest request) {
        ItemContratoResponse response = service.salvar(request);
        return ResponseEntity.ok(response);
    }
}

