package com.example.SIGACTI.controllers.contrato;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.services.contrato.CreateContratoService;
import com.example.SIGACTI.services.contrato.GetContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/contrato")
public class GetContratoController {

    private final GetContratoService service;

    public GetContratoController(GetContratoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Contrato>> listarTodos(){
        List<Contrato> contrato = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(contrato);
    }
}
