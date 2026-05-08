package br.com.fiap.assistentx.service;

import br.com.fiap.assistentx.dto.ResumoClassificacaoInvestimentoDTO;
import br.com.fiap.assistentx.dto.ResumoPatrimonioDTO;
import br.com.fiap.assistentx.model.Investimento;
import br.com.fiap.assistentx.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PatrimonioService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public ResumoPatrimonioDTO obterResumo(Integer usuarioId) {

        List<Investimento> investimentos = investimentoRepository.findByUsuarioId(usuarioId);

        ResumoPatrimonioDTO resumo = new ResumoPatrimonioDTO();

        double valorInicialTotal = investimentos.stream()
                .mapToDouble(Investimento::getValor)
                .sum();

        double valorAtualTotal = investimentos.stream()
                .mapToDouble(Investimento::getValorAtual)
                .sum();

        resumo.setValorInicialTotal(valorInicialTotal);
        resumo.setValorAtualTotal(valorAtualTotal);

        // cálculo agregado
        resumo.setJurosEstimados(
                calcularJurosPonderado(investimentos)
        );

        resumo.setUltimaMensalidade(
                calcularMensalidadeTotal(investimentos)
        );


        // agrupando por classificação
        Map<String, List<Investimento>> agrupados =
                investimentos.stream()
                        .collect(Collectors.groupingBy(
                                investimento ->
                                        investimento.getTipo().getClassificacao()
                        ));

        List<ResumoClassificacaoInvestimentoDTO> classificacoes =
                agrupados.entrySet()
                        .stream()
                        .map(entry -> {

                            String classificacao = entry.getKey();
                            List<Investimento> lista = entry.getValue();

                            double inicial = lista.stream()
                                    .mapToDouble(Investimento::getValor)
                                    .sum();

                            double atual = lista.stream()
                                    .mapToDouble(Investimento::getValorAtual)
                                    .sum();

                            ResumoClassificacaoInvestimentoDTO dto =
                                    new ResumoClassificacaoInvestimentoDTO();

                            dto.setClassificacao(classificacao);
                            dto.setValorInicialTotal(inicial);
                            dto.setValorAtualTotal(atual);

                            dto.setJurosEstimados(
                                    calcularJurosPonderado(lista)
                            );

                            dto.setUltimaMensalidade(
                                    calcularMensalidadeTotal(lista)
                            );

                            return dto;
                        })
                        .toList();

        resumo.setClassificacoes(classificacoes);

        return resumo;
    }

    private double calcularJurosPonderado(List<Investimento> investimentos) {

        double somaPesos = investimentos.stream()
                .mapToDouble(Investimento::getValor)
                .sum();

        if (somaPesos == 0) {
            return 0;
        }

        double somaPonderada = investimentos.stream()
                .mapToDouble(investimento -> {

                    investimento.calcularJuros();

                    return investimento.getValor()
                            * investimento.getJurosEstimados();
                })
                .sum();

        return somaPonderada / somaPesos;
    }

    private double calcularMensalidadeTotal(List<Investimento> investimentos) {

        return investimentos.stream()
                .mapToDouble(investimento -> {

                    investimento.calcularUltimaMensalidade();

                    return investimento.getUltimaMensalidade();
                })
                .sum();
    }
}
