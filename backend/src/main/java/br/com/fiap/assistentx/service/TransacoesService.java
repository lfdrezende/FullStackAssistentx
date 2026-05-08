package br.com.fiap.assistentx.service;


import br.com.fiap.assistentx.dto.ResumoEntradasDTO;
import br.com.fiap.assistentx.dto.ResumoOrigemTransacaoDTO;
import br.com.fiap.assistentx.dto.ResumoSaidasDTO;
import br.com.fiap.assistentx.model.Transacao;
import br.com.fiap.assistentx.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacoesService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    private List<ResumoOrigemTransacaoDTO> resumirPorOrigem(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .collect(Collectors.groupingBy(
                        transacao ->
                                transacao.getOrigemTransacao().getId()
                ))
                .values()
                .stream()
                .map(lista -> {

                    Transacao primeira = lista.get(0);

                    double total = lista.stream()
                            .mapToDouble(Transacao::getValor)
                            .sum();

                    ResumoOrigemTransacaoDTO dto =
                            new ResumoOrigemTransacaoDTO();

                    dto.setOrigemId(
                            primeira.getOrigemTransacao().getId()
                    );

                    dto.setOrigemNome(
                            primeira.getOrigemTransacao().getNome()
                    );

                    dto.setValorTotal(Math.abs(total));

                    return dto;
                })
                .toList();
    }

    public ResumoEntradasDTO obterResumoEntradas(Integer usuarioId) {

        List<Transacao> entradas = transacaoRepository.findByUsuarioIdAndValorGreaterThan(usuarioId, 0);

        double total = entradas.stream()
                .mapToDouble(Transacao::getValor)
                .sum();

        ResumoEntradasDTO dto =
                new ResumoEntradasDTO();

        dto.setValorTotalEntradas(total);

        dto.setOrigens(
                resumirPorOrigem(entradas)
        );

        return dto;
    }

    public ResumoSaidasDTO obterResumoSaidas(Integer usuarioId) {

        List<Transacao> saidas = transacaoRepository.findByUsuarioIdAndValorLessThan(usuarioId, 0);

        double total = saidas.stream()
                .mapToDouble(Transacao::getValor)
                .sum();

        ResumoSaidasDTO dto =
                new ResumoSaidasDTO();

        dto.setValorTotalSaidas(Math.abs(total));

        dto.setOrigens(
                resumirPorOrigem(saidas)
        );

        return dto;
    }
}