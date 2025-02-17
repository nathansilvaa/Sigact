package com.example.SIGACTI.controllers.contratado;

import com.example.SIGACTI.dto.*;
import com.example.SIGACTI.services.contratado.CreateContratadoService;
import com.example.SIGACTI.services.contrato.CreateContratoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contratado")
public class CreateContratadoController {
    private final CreateContratadoService createContratadoService;

    public CreateContratadoController(CreateContratadoService createContratadoService) {
        this.createContratadoService = createContratadoService;
    }

    @PostMapping
    public ResponseEntity<ContratadoResponse> adicionarContrato(@RequestBody ContratadoRequest contratadoRequestDto) {
        ContratadoResponse contratado = createContratadoService.criarContratado(contratadoRequestDto);
        return ResponseEntity.ok(contratado);
    }
}
