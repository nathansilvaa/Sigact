package com.example.SIGACTI.controllers.acaoOrcamentaria;

import com.example.SIGACTI.dto.AcaoOrcamentariaRequest;
import com.example.SIGACTI.dto.AcaoOrcamentariaResponse;
import com.example.SIGACTI.services.acaoOrcamentaria.UpdateAcaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/acao")
public class UpdateAcaoController {
    private final UpdateAcaoService updateAcaoService;

    public UpdateAcaoController(UpdateAcaoService updateAcaoService) {
        this.updateAcaoService = updateAcaoService;
    }

    @PutMapping
    public ResponseEntity<AcaoOrcamentariaResponse> atualizaracao(@RequestParam long id, @RequestBody @Valid AcaoOrcamentariaRequest request){
        Optional<AcaoOrcamentariaResponse> acaoAtualizada = updateAcaoService.atualizarAcao(id, request);
        return acaoAtualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
