package com.example.SIGACTI.controllers.contrato;

import com.example.SIGACTI.dto.ContratoResponse;
import com.example.SIGACTI.services.contrato.GetContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contrato")
public class GetContratoController {

    private final GetContratoService getContratoService;

    public GetContratoController(GetContratoService getContratoService) {
        this.getContratoService = getContratoService;
    }

    // GET - Buscar todos os contratos
    @GetMapping("/todos")
    public ResponseEntity<List<ContratoResponse>> obterTodosContratos() {
        List<ContratoResponse> contratos = getContratoService.obterTodosContratos();
        return ResponseEntity.ok(contratos);
    }

    // GET - Buscar contrato por ID
    @GetMapping
    public ResponseEntity<ContratoResponse> obterContratoPorId(@RequestParam Long idContrato) {
        Optional<ContratoResponse> contratoOpt = getContratoService.obterContratoPorId(idContrato);

        return contratoOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
