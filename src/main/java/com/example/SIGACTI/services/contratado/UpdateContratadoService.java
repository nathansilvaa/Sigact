package com.example.SIGACTI.services.contratado;

import com.example.SIGACTI.dto.ContratadoRequest;
import com.example.SIGACTI.dto.ContratadoResponse;
import com.example.SIGACTI.model.entities.Contratado;
import com.example.SIGACTI.model.repositories.ContratadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UpdateContratadoService {

    private final ContratadoRepository contratadoRepository;

    @Autowired
    public UpdateContratadoService(ContratadoRepository contratadoRepository) {
        this.contratadoRepository = contratadoRepository;
    }

    public Optional<ContratadoResponse> atualizarContratado(Long idContratado, ContratadoRequest request) {
        Optional<Contratado> contratadoOpt = contratadoRepository.findById(idContratado);

        if (contratadoOpt.isPresent()) {
            Contratado contratado = contratadoOpt.get();

            // Atualizando os dados do contratado e salvando
            contratado.setCpfOuCnpj(request.cpfOuCnpj());
            contratado.setNomeRazaoSocial(request.nomeRazaoSocial());
            contratado.setEmail(request.email());

            contratadoRepository.save(contratado);

            return Optional.of(ContratadoResponse.converterContratado(contratado));
        }
        return Optional.empty();
    }
}
