package com.example.SIGACTI.controllers.NotasCompraDireta;



import com.example.SIGACTI.dto.NotasCompraDiretaResponse;
import com.example.SIGACTI.services.notasCompraDireta.GetNotaCompraDiretaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notasCompraDireta")
public class GetNotaCompraDiretaController {

    private final GetNotaCompraDiretaService service;

    public GetNotaCompraDiretaController(GetNotaCompraDiretaService service) {
        this.service = service;
    }

    // GET - Buscar todas as notas de compra direta
    @GetMapping("/todas")
    public ResponseEntity<List<NotasCompraDiretaResponse>> obterTodasNotas() {
        List<NotasCompraDiretaResponse> notas = service.obterTodasNotas();
        return ResponseEntity.ok(notas);
    }

    // GET - Buscar uma nota de compra direta pelo ID (notaFiscal)
    @GetMapping
    public ResponseEntity<NotasCompraDiretaResponse> obterNotaPorId(@RequestParam Long notaFiscal) {
        Optional<NotasCompraDiretaResponse> notaOpt = service.obterNotaPorId(notaFiscal);

        return notaOpt
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrar a nota
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrar a nota
    }
}
