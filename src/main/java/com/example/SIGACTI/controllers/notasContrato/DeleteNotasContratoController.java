package com.example.SIGACTI.controllers.notasContrato;

import com.example.SIGACTI.services.notasContrato.DeleteNotasContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notasContrato")
public class DeleteNotasContratoController {

    private final DeleteNotasContratoService service;

    public DeleteNotasContratoController(DeleteNotasContratoService service) {
        this.service = service;
    }

    @DeleteMapping(params = "notaFiscal")
    public ResponseEntity<String> deletarNotasContrato(@RequestParam String notaFiscal) {
        boolean deletado = service.deletarNotasContrato(notaFiscal);

        if (deletado) {
            return ResponseEntity.ok("Nota de contrato deletada com sucesso!");
        } else {
            return ResponseEntity.status(404).body("Nota de contrato não encontrada.");
        }
    }
}
