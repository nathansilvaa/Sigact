package com.example.SIGACTI.controllers.contratado;

import com.example.SIGACTI.dto.ContratadoRequest;
import com.example.SIGACTI.dto.ContratadoResponse;
import com.example.SIGACTI.services.contratado.UpdateContratadoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contratado")
public class UpdateContratadoController {
    private final UpdateContratadoService updateContratadoService;

    public UpdateContratadoController(UpdateContratadoService service) {
        this.updateContratadoService = service;
    }

    @PutMapping
    public ResponseEntity<ContratadoResponse> atualizarContratado(
            @RequestParam Long idContratado,
            @RequestBody @Valid ContratadoRequest request) {

        Optional<ContratadoResponse> contratadoAtualizado = updateContratadoService.atualizarContratado(idContratado, request);

        return contratadoAtualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
