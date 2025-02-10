package com.example.SIGACTI.controllers.NotasCompraDireta;

import com.example.SIGACTI.services.notasCompraDireta.DeleteNotaCompraDiretaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notasCompraDireta")
public class DeleteNotaCompraDiretaController {

    private final DeleteNotaCompraDiretaService service;

    public DeleteNotaCompraDiretaController(DeleteNotaCompraDiretaService service) {
        this.service = service;
    }

    @DeleteMapping
    public ResponseEntity<String> deletarNotaCompraDireta(@RequestParam String notaFiscal) {
        boolean deletado = service.deletarNotaCompraDireta(notaFiscal);

        if (deletado) {
            return ResponseEntity.ok("Nota de compra direta deletada com sucesso!");
        } else {
            return ResponseEntity.status(404).body("Nota de compra direta não encontrada.");
        }
    }
}
