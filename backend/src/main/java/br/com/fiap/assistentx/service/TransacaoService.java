package br.com.fiap.assistentx.service;


import br.com.fiap.assistentx.dto.TransacaoDTO;
import br.com.fiap.assistentx.model.Transacao;
import br.com.fiap.assistentx.repository.OrigemTransacaoRepository;
import br.com.fiap.assistentx.repository.TransacaoRepository;
import br.com.fiap.assistentx.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OrigemTransacaoRepository origemTransacaoRepository;

    private void validarTipo(Transacao transacao, String tipo){

        if (!transacao.getTipo().equals(tipo)) {
            throw new RuntimeException(
                    "Id não referente a uma " + transacao.getDescricao()
            );
        }
    }

    public TransacaoDTO salvar(TransacaoDTO transacaoDTO, String tipo){

        if(transacaoDTO.getOrigemTipo().equals("E") && transacaoDTO.getValor() < 0 ||
                transacaoDTO.getOrigemTipo().equals("S") && transacaoDTO.getValor() > 0) {
            throw new RuntimeException("Valor inválido para este tipo");
        }

        Transacao novaTransacao = new Transacao(
                HelperService.buscar(
                        usuarioRepository,
                        transacaoDTO.getUsuarioId(),
                        "Usuário"),
                transacaoDTO.getValor(),
                HelperService.buscar(
                        origemTransacaoRepository,
                        transacaoDTO.getOrigemId(),
                        "Origem da Transação"),
                transacaoDTO.getDataHora()
        );

        return toDTO(transacaoRepository.save(novaTransacao));
    }

    public TransacaoDTO buscarPorId(Integer id, String tipo) {

        Transacao transacao = HelperService.buscar(
                transacaoRepository,
                id,
                "Transação"
        );

        validarTipo(transacao, tipo);

        return toDTO(transacao);
    }

    public List<TransacaoDTO> listar(String tipo) {

        List<Transacao> transacoes;

        if (tipo.equals("E")) {
            transacoes = transacaoRepository.findByValorGreaterThan(0);
        } else if (tipo.equals("S")) {
            transacoes = transacaoRepository.findByValorLessThan(0);
        } else {
            throw new RuntimeException("Tipo inválido");
        }

        return transacoes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TransacaoDTO atualizar(TransacaoDTO transacaoDTO, String tipo){
        Transacao transacaoAtualizada = new Transacao(
                HelperService.buscar(
                        usuarioRepository,
                        transacaoDTO.getUsuarioId(),
                        "Usuário"),
                transacaoDTO.getValor(),
                HelperService.buscar(
                        origemTransacaoRepository,
                        transacaoDTO.getOrigemId(),
                        "Origem da Transação"),
                transacaoDTO.getDataHora(),
                HelperService.buscar(
                        transacaoRepository,
                        transacaoDTO.getTransacaoId(),
                        "Transação").getId()
        );
        return toDTO(transacaoRepository.save(transacaoAtualizada));
    }

    public void excluir(Integer id, String tipo){
        Transacao transacao = HelperService.buscar(
                transacaoRepository,
                id,
                "Transação"
        );

        validarTipo(transacao, tipo);

        transacaoRepository.deleteById(id);
    }

    private TransacaoDTO toDTO(Transacao transacao) {
        return new TransacaoDTO(
                transacao.getId(),
                transacao.getUsuario().getId(),
                transacao.getValor(),
                transacao.getDataHora(),
                transacao.getOrigemTransacao().getId(),
                transacao.getOrigemTransacao().getNome(),
                transacao.getOrigemTransacao().getTipo()
        );
    }
}