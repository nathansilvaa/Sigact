package com.example.SIGACTI.services.notasContrato;

import com.example.SIGACTI.dto.NotasContratoRequest;
import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.NotasContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.InvalidAttributesException;
import java.util.Optional;

@Service
@Transactional
public class CreateNotasContratoService {

    @Autowired
    private final NotasContratoRepository notasContratoRepository;
    @Autowired
    private final ContratoRepository contratoRepository;
    @Autowired
    private final ProcessoRepository processoRepository;

    public CreateNotasContratoService(NotasContratoRepository notasContratoRepository,
                                      ContratoRepository contratoRepository,
                                      ProcessoRepository processoRepository) {
        this.notasContratoRepository = notasContratoRepository;
        this.contratoRepository = contratoRepository;
        this.processoRepository = processoRepository;
    }

    public NotasContratoResponse salvar(NotasContratoRequest notasContratoDto) {
        try {
            NotasContrato notasContrato = notasContratoDto.converterNotasContrato(processoRepository, contratoRepository);

            Optional<Processo> processo = processoRepository.findById(notasContratoDto.processo());
            Optional<Contrato> contrato = contratoRepository.findById(notasContratoDto.contrato());

            if (processo.isPresent()) {
                notasContrato.setProcesso(processo.get());
            } else {
                throw new InvalidAttributesException("ID do processo inválido: " + notasContratoDto.processo());
            }

            if (contrato.isPresent()) {
                notasContrato.setContrato(contrato.get());
            } else {
                throw new InvalidAttributesException("ID do contrato inválido: " + notasContratoDto.contrato());
            }

            notasContratoRepository.save(notasContrato);
            return new NotasContratoResponse(
                    notasContrato.getNotaFiscal(),
                    notasContrato.getContrato(),
                    notasContrato.getProcesso(),
                    notasContrato.getObjeto(),
                    notasContrato.getContratado(),
                    notasContrato.getCnpj(),
                    notasContrato.getValorContrato(),
                    notasContrato.getAtesto(),
                    notasContrato.getFiscalContrato(),
                    notasContrato.getGestorContrato()
            );
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }
}
