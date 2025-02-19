package com.example.SIGACTI.controllers.ocorrencia;

import com.example.SIGACTI.dto.NotasContratoRequest;
import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.dto.OcorreciasRequest;
import com.example.SIGACTI.dto.OcorrenciaResponse;
import com.example.SIGACTI.services.ocorrencias.UpdateOcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ocorrencia")
public class UpdateOcorrenciaController {

    private final UpdateOcorrenciaService service;
    @Autowired
    public UpdateOcorrenciaController(UpdateOcorrenciaService service) {
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<OcorrenciaResponse> atualizarOcorrencia(
            @RequestParam Long id,
            @RequestBody @Valid OcorreciasRequest request) {

        Optional<OcorrenciaResponse> ocorrenciaAtualizada = service.atualizarOcorrencia(id, request);

        return ocorrenciaAtualizada
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrar e atualizar a nota de contrato
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrar a nota de contrato
    }
}
