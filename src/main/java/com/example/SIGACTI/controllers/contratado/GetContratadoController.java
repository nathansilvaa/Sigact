package com.example.SIGACTI.controllers.contratado;

import com.example.SIGACTI.dto.ContratadoResponse;
import com.example.SIGACTI.services.contratado.GetContratadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contratado")
public class GetContratadoController {
    private final GetContratadoService getContratadoService;

    public GetContratadoController(GetContratadoService getContratadoService) {
        this.getContratadoService = getContratadoService;
    }
    @GetMapping("/todos")
    public ResponseEntity<List<ContratadoResponse>> obterTodosContratado() {
        List<ContratadoResponse> contratados = getContratadoService.obterTodosContratados();
        return ResponseEntity.ok(contratados);
    }
}
