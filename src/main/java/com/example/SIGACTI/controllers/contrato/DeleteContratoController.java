package com.example.SIGACTI.controllers.contrato;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.services.contrato.DeleteContratoService;
import com.example.SIGACTI.services.contrato.GetContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contrato")
public class DeleteContratoController {

    private final DeleteContratoService service;

    public DeleteContratoController(DeleteContratoService service) {
        this.service = service;
    }

    @DeleteMapping(params = "idNumeroContrato")
    public ResponseEntity<String> deletarContrato(@RequestParam String idNumeroContrato) {
        boolean deletado = service.deletarContrato(idNumeroContrato);

        if (deletado) {
            return ResponseEntity.ok("Contrato deletado com sucesso!");
        } else {
            return ResponseEntity.status(404).body("Contrato não encontrado.");
        }
    }
}
