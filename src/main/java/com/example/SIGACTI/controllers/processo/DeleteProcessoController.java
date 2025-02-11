package com.example.SIGACTI.controllers.processo;

import com.example.SIGACTI.services.processo.DeleteProcessoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/processo")
public class DeleteProcessoController {

    private final DeleteProcessoService deleteProcessoService;

    public DeleteProcessoController(DeleteProcessoService deleteProcessoService) {
        this.deleteProcessoService = deleteProcessoService;
    }

    @DeleteMapping("/{idProcesso}")
    public ResponseEntity<String> deletarProcesso(@PathVariable Long idProcesso) {
        try {
            deleteProcessoService.deletarProcesso(idProcesso);
            return ResponseEntity.ok("Processo deletado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
