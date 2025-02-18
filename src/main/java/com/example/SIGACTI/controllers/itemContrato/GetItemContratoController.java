package com.example.SIGACTI.controllers.itemContrato;

import com.example.SIGACTI.dto.ItemContratoResponse;
import com.example.SIGACTI.model.repositories.ItemContratoRepository;
import com.example.SIGACTI.services.itemContrato.GetItemContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itemContrato")
public class GetItemContratoController {
    private final GetItemContratoService service;

    public GetItemContratoController(GetItemContratoService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<ItemContratoResponse>> obterTodosItensContrato() {
        List<ItemContratoResponse> listaItens = service.obterTodosItensContrato();
        return ResponseEntity.ok(listaItens);
    }
}
