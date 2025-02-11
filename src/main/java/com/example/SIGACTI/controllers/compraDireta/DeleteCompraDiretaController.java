package com.example.SIGACTI.controllers.compraDireta;

import com.example.SIGACTI.services.compraDireta.DeleteCompraDiretaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compraDireta")
public class DeleteCompraDiretaController {

    private final DeleteCompraDiretaService service;

    public DeleteCompraDiretaController(DeleteCompraDiretaService service) {
        this.service = service;
    }

    @DeleteMapping(params = "portaria")
    public ResponseEntity<String> deletarCompraDireta(@RequestParam Long portaria) {
        boolean deletado = service.deletarCompraDireta(portaria);

        if (deletado) {
            return ResponseEntity.ok("Compra direta deletada com sucesso!");
        } else {
            return ResponseEntity.status(404).body("Compra direta não encontrada.");
        }
    }
}
