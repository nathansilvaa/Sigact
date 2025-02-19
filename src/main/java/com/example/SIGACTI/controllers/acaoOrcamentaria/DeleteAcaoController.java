package com.example.SIGACTI.controllers.acaoOrcamentaria;

import com.example.SIGACTI.services.acaoOrcamentaria.DeleteAcaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acao")
public class DeleteAcaoController {

    private final DeleteAcaoService deleteAcaoService;

    public DeleteAcaoController(DeleteAcaoService deleteAcaoService) {
        this.deleteAcaoService = deleteAcaoService;
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deletarAcao(@RequestParam Long id) {
        try {
            deleteAcaoService.deletarAcaoOrcamentaria(id);
            return ResponseEntity.ok("Ação Orcamentaria deletada com sucesso");
        }catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
