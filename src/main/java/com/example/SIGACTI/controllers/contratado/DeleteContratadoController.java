package com.example.SIGACTI.controllers.contratado;

import com.example.SIGACTI.services.contratado.DeleteContratadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contratado")
public class DeleteContratadoController {
    private final DeleteContratadoService deleteContratadoService;

    public DeleteContratadoController(DeleteContratadoService deleteContratadoService) {
        this.deleteContratadoService = deleteContratadoService;
    }

    @DeleteMapping("/{idContratado}")
    public ResponseEntity<String> deletarProcesso(@PathVariable Long idContratado) {
        try {
            deleteContratadoService.deletarContratado(idContratado);
            return ResponseEntity.ok("Contratado deletado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
