package br.com.fiap.assistentx.service;

import br.com.fiap.assistentx.dto.ResumoCategoriaModeloDTO;
import br.com.fiap.assistentx.dto.ResumoModeloDTO;
import br.com.fiap.assistentx.model.CategoriaDoModelo;
import br.com.fiap.assistentx.model.Modelo;
import br.com.fiap.assistentx.model.Transacao;
import br.com.fiap.assistentx.repository.ModeloRepository;
import br.com.fiap.assistentx.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static br.com.fiap.assistentx.service.HelperService.buscar;

@Service
public class ResumoModeloService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    public ResumoModeloDTO obterResumo(Integer usuarioId, Integer modeloId) {

        Modelo modelo = buscar(modeloRepository,modeloId,"Modelo");

        List<Transacao> entradas = transacaoRepository.findByUsuarioIdAndValorGreaterThan(
                usuarioId,
                0
        );

        List<Transacao> saidas = transacaoRepository.findByUsuarioIdAndValorLessThan(
                usuarioId,
                0
        );

        double orcamento = entradas.stream()
                .mapToDouble(Transacao::getValor)
                .sum();

        ResumoModeloDTO resumo =
                new ResumoModeloDTO();

        resumo.setOrcamento(orcamento);

        Map<Integer, Double> gastosPorCategoria =
                agruparGastosPorCategoria(saidas);

        List<ResumoCategoriaModeloDTO> categorias =
                modelo.getCategorias()
                        .stream()
                        .map(modeloCategoria -> {

                            CategoriaDoModelo categoria = modeloCategoria.getCategoria();

                            double percentual = modeloCategoria.getValor();

                            double limite = orcamento * percentual;

                            double valorUtilizado =
                                    gastosPorCategoria.getOrDefault(
                                            categoria.getId(),
                                            0.0
                                    );

                            double sobra = limite - valorUtilizado;

                            double percentualUtilizado =
                                    limite == 0
                                            ? 0
                                            : (valorUtilizado / limite) * 100;

                            ResumoCategoriaModeloDTO dto = new ResumoCategoriaModeloDTO();

                            dto.setCategoriaId(categoria.getId());
                            dto.setCategoriaNome(categoria.getNome());
                            dto.setPercentualCategoria(percentual);
                            dto.setLimite(limite);
                            dto.setValorUtilizado(valorUtilizado);
                            dto.setSobra(sobra);
                            dto.setPercentualUtilizado(percentualUtilizado);
                            dto.setStatus(calcularStatus(percentualUtilizado));

                            return dto;
                        })
                        .toList();

        resumo.setCategorias(categorias);

        return resumo;
    }

    private String calcularStatus(double percentualUtilizado) {

        if (percentualUtilizado < 90) {
            return "ABAIXO_DO_LIMITE";
        }

        if (percentualUtilizado <= 100) {
            return "NO_LIMITE";
        }

        if (percentualUtilizado <= 110) {
            return "POUCO_ACIMA_DO_LIMITE";
        }

        return "MUITO_ACIMA_DO_LIMITE";
    }

    private Map<Integer, Double> agruparGastosPorCategoria(
            List<Transacao> saidas
    ) {

        return saidas.stream()

                .flatMap(transacao ->

                        transacao
                                .getOrigemTransacao()
                                .getCategorias()
                                .stream()

                                .map(categoriaOrigem ->
                                        Map.entry(
                                                categoriaOrigem
                                                        .getCategoria()
                                                        .getId(),

                                                Math.abs(
                                                        transacao.getValor()
                                                )
                                        )
                                )
                )

                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,

                        Collectors.summingDouble(
                                Map.Entry::getValue
                        )
                ));
    }
}