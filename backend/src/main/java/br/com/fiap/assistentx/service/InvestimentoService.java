package br.com.fiap.assistentx.service;

import br.com.fiap.assistentx.dto.InvestimentoDTO;
import br.com.fiap.assistentx.model.Investimento;
import br.com.fiap.assistentx.repository.InvestimentoRepository;
import br.com.fiap.assistentx.repository.TipoInvestimentoRepository;
import br.com.fiap.assistentx.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoInvestimentoRepository tipoInvestimentoRepository;

    public InvestimentoDTO salvar(InvestimentoDTO investimentoDTO){

        Investimento novoInvestimento =
                new Investimento(
                        HelperService.buscar(usuarioRepository,
                                investimentoDTO.getUsuarioId(),
                                "Usuário"),
                        investimentoDTO.getValorInicial(),
                        investimentoDTO.getValorAtual(),
                        HelperService.buscar(tipoInvestimentoRepository, investimentoDTO.getTipoInvestimentoId(),
                                "Tipo de Investimento"),
                        investimentoDTO.getDataInicio()
                );

        Investimento investimentoSalvo = investimentoRepository.save(novoInvestimento);

        return toDTO(investimentoSalvo);
    }

    public InvestimentoDTO buscarPorId(Integer usuarioId, Integer investimentoId) {

        Investimento investimento = HelperService.buscarDoUsuario(investimentoRepository
                .findByIdAndUsuarioId(investimentoId, usuarioId), "Investimento");

        investimento.calcularJuros();
        investimento.calcularUltimaMensalidade();

        return toDTO(investimento);
    }

    public InvestimentoDTO atualizar(InvestimentoDTO investimentoDTO){

        Investimento investimentoAtualizado =
                new Investimento(
                        HelperService.buscar(
                                usuarioRepository,
                                investimentoDTO.getUsuarioId(),
                                "Usuário"
                        ),
                        investimentoDTO.getValorInicial(),
                        investimentoDTO.getValorAtual(),
                        HelperService.buscar(
                                tipoInvestimentoRepository,
                                investimentoDTO.getTipoInvestimentoId(),
                                "Tipo de Investimento"
                        ),
                        investimentoDTO.getDataInicio(),
                        HelperService.buscar(
                                investimentoRepository,
                                investimentoDTO.getInvestimentoId(),
                                "Investimento)").getId()
                );
        return toDTO(investimentoRepository.save(investimentoAtualizado));
    }

    public void excluir(Integer usuarioId, Integer investimentoId) {

        Investimento investimento = HelperService.buscarDoUsuario(investimentoRepository
                .findByIdAndUsuarioId(investimentoId, usuarioId), "Investimento");

        investimentoRepository.delete(investimento);
    }

    public List<InvestimentoDTO> listar(Integer usuarioId){

        return investimentoRepository.findByUsuarioId(usuarioId)
                .stream()
                .peek(investimento -> {
                    investimento.calcularJuros();
                    investimento.calcularUltimaMensalidade();
                })
                .map(this::toDTO)
                .toList();
    }

    private InvestimentoDTO toDTO(Investimento investimento) {
        return new InvestimentoDTO(
                investimento.getId(),
                investimento.getUsuario().getId(),
                investimento.getTipo().getId(),
                investimento.getValor(),
                investimento.getValorAtual(),
                investimento.getUltimaMensalidade(),
                investimento.getJurosEstimados(),
                investimento.getTipo().getNome(),
                investimento.getTipo().getClassificacao(),
                investimento.getDataHora()
        );
    }

}