package com.example.SIGACTI.controllers.itemContrato;

import com.example.SIGACTI.dto.ItemContratoRequest;
import com.example.SIGACTI.dto.ItemContratoResponse;
import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.services.itemContrato.UpdateItemContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/itemContrato")
public class UpdateItemContratoController {
    private final UpdateItemContratoService service;

    public UpdateItemContratoController(UpdateItemContratoService service) {this.service = service;}

    @PutMapping("/{idItem}")
    public ResponseEntity<ItemContratoResponse> atualizarItemContrato(
            @PathVariable Long idItem,
            @RequestBody ItemContratoRequest itemContratoDto) {
        Optional<ItemContratoResponse> itemContratoAtualizado = service.atualizarItemsContrato(idItem, itemContratoDto);
        return itemContratoAtualizado
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
