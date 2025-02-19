package com.example.SIGACTI.controllers.itemContrato;

import com.example.SIGACTI.services.itemContrato.DeleteItemContratoService;
import com.example.SIGACTI.services.notasContrato.DeleteNotasContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/itemContrato")
public class DeleteItemContratoController {

    private final DeleteItemContratoService service;

    public DeleteItemContratoController(DeleteItemContratoService service) { this.service = service; }

    @DeleteMapping(params = "idItem")
    public ResponseEntity<String> deletarNotasContrato(@RequestParam Long idItem) {
        return service.deletarItemContrato(idItem)
            ? ResponseEntity.ok("Nota de contrato deletada com sucesso!")
            : ResponseEntity.status(404).body("Nota de contrato não encontrada.");
    }
}
