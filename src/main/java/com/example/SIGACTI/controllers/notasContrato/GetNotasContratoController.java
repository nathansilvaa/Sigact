package com.example.SIGACTI.controllers.notasContrato;

import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.services.notasContrato.GetNotasContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notasContrato")
public class GetNotasContratoController {

    private final GetNotasContratoService service;

    public GetNotasContratoController(GetNotasContratoService service) {
        this.service = service;
    }

    // Endpoint para buscar todas as notas de contrato
    @GetMapping("/todos")
    public ResponseEntity<List<NotasContratoResponse>> obterTodasNotasContrato() {
        List<NotasContratoResponse> notas = service.obterTodasNotasContrato();
        return ResponseEntity.ok(notas);
    }

    // Endpoint para buscar uma nota de contrato específica pelo ID (notaFiscal)
    @GetMapping
    public ResponseEntity<NotasContratoResponse> obterNotaContratoPorId(@RequestParam Long notaFiscal) {
        Optional<NotasContratoResponse> nota = service.obterNotaContratoPorId(notaFiscal);
        return nota.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
