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

import java.util.Optional;

@Service
@Transactional
public class UpdateNotasContratoService {

    private final NotasContratoRepository notasContratoRepository;
    private final ContratoRepository contratoRepository;
    private final ProcessoRepository processoRepository;

    @Autowired
    public UpdateNotasContratoService(NotasContratoRepository notasContratoRepository,
                                      ContratoRepository contratoRepository,
                                      ProcessoRepository processoRepository) {
        this.notasContratoRepository = notasContratoRepository;
        this.contratoRepository = contratoRepository;
        this.processoRepository = processoRepository;
    }

    public Optional<NotasContratoResponse> atualizarNotasContrato(String notaFiscal, NotasContratoRequest notasContratoDto) {
        Optional<NotasContrato> notasContratoOpt = notasContratoRepository.findById(notaFiscal);

        if (notasContratoOpt.isPresent()) {
            NotasContrato notasContrato = notasContratoOpt.get();

            // Atualizando os campos da nota de contrato
            notasContrato.setObjeto(notasContratoDto.objeto());
            notasContrato.setContratado(notasContratoDto.contratado());
            notasContrato.setCnpj(notasContratoDto.cnpj());
            notasContrato.setValorContrato(notasContratoDto.valorContrato());
            notasContrato.setAtesto(notasContratoDto.atesto());
            notasContrato.setFiscalContrato(notasContratoDto.fiscalContrato());
            notasContrato.setGestorContrato(notasContratoDto.gestorContrato());

            // Atualiza o processo, se necessário
            if (notasContratoDto.processo() != null) {
                Optional<Processo> processoOpt = processoRepository.findById(notasContratoDto.processo());
                processoOpt.ifPresent(notasContrato::setProcesso);
            }

            // Atualiza o contrato, se necessário
            if (notasContratoDto.contrato() != null) {
                Optional<Contrato> contratoOpt = contratoRepository.findById(notasContratoDto.contrato());
                contratoOpt.ifPresent(notasContrato::setContrato);
            }

            notasContratoRepository.save(notasContrato);

            return Optional.of(new NotasContratoResponse(
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
            ));
        } else {
            return Optional.empty(); // Retorna vazio caso a nota de contrato não seja encontrada
        }
    }
}
