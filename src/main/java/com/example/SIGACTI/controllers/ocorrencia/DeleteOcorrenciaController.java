package com.example.SIGACTI.controllers.ocorrencia;

import com.example.SIGACTI.services.ocorrencias.DeleteOcorrenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ocorrencia")
public class DeleteOcorrenciaController {
    private final DeleteOcorrenciaService deleteOcorrenciaService;

    public DeleteOcorrenciaController(DeleteOcorrenciaService deleteOcorrenciaService) {
        this.deleteOcorrenciaService = deleteOcorrenciaService;
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deletarOcorrencia(@RequestParam Long id) {
        boolean deletado = deleteOcorrenciaService.deletarOcorrencia(id);

        if (deletado) {
            return ResponseEntity.ok("Nota de contrato deletada com sucesso!");
        } else {
            return ResponseEntity.status(404).body("Nota de contrato não encontrada.");
        }
    }
}
