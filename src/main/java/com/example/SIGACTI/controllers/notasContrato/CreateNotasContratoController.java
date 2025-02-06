package com.example.SIGACTI.controllers.notasContrato;


import com.example.SIGACTI.dto.NotasContratoRequest;
import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.services.notasContrato.CreateNotasContratoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notasContrato")
public class CreateNotasContratoController {

    private final CreateNotasContratoService service;

    public CreateNotasContratoController(CreateNotasContratoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<NotasContratoResponse> salvar(@RequestBody @Valid NotasContratoRequest notasContratoDto) {
        NotasContratoResponse response = service.salvar(notasContratoDto);
        if (response == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response);
    }
}
