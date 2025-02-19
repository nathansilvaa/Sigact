package com.example.SIGACTI.controllers.ocorrencia;

import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.dto.OcorrenciaResponse;
import com.example.SIGACTI.services.ocorrencias.GetOcorrenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ocorrencia")
public class GetOcorrenciaController {

    private final GetOcorrenciaService getOcorrenciaService;

    public GetOcorrenciaController(GetOcorrenciaService getOcorrenciaService) {
        this.getOcorrenciaService = getOcorrenciaService;
    }

    // Endpoint para buscar todas as notas de contrato
    @GetMapping("/todos")
    public ResponseEntity<List<OcorrenciaResponse>> obterTodasOcorrencias() {
        List<OcorrenciaResponse> ocorrencias = getOcorrenciaService.obterTodasOcorrencias();
        return ResponseEntity.ok(ocorrencias);
    }

    // Endpoint para buscar uma nota de contrato específica pelo ID (notaFiscal)
    @GetMapping
    public ResponseEntity<OcorrenciaResponse> obterOcorrenciaPorId(@RequestParam Long id) {
        Optional<OcorrenciaResponse> nota = getOcorrenciaService.obterOcorrenciaPorId(id);
        return nota.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
