package com.example.SIGACTI.controllers.compraDireta;

import com.example.SIGACTI.dto.CompraDiretaResponse;
import com.example.SIGACTI.services.compraDireta.GetCompraDiretaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compraDireta")
public class GetCompraDiretaController {

    private final GetCompraDiretaService getCompraDiretaService;

    public GetCompraDiretaController(GetCompraDiretaService getCompraDiretaService) {
        this.getCompraDiretaService = getCompraDiretaService;
    }

    // GET - Buscar todas as compras diretas
    @GetMapping("/todas")
    public ResponseEntity<List<CompraDiretaResponse>> obterTodasComprasDiretas() {
        List<CompraDiretaResponse> comprasDiretas = getCompraDiretaService.obterTodasComprasDiretas();
        return ResponseEntity.ok(comprasDiretas);
    }

    // GET - Buscar compra direta por ID
    @GetMapping
    public ResponseEntity<CompraDiretaResponse> obterCompraDiretaPorId(@RequestParam Long idCompraDireta) {
        Optional<CompraDiretaResponse> compraDiretaOpt = getCompraDiretaService.obterCompraDiretaPorId(idCompraDireta);

        return compraDiretaOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
