package br.com.fiap.assistentx.service;


import br.com.fiap.assistentx.dto.TransacaoDTO;
import br.com.fiap.assistentx.model.Transacao;
import br.com.fiap.assistentx.repository.OrigemTransacaoRepository;
import br.com.fiap.assistentx.repository.TransacaoRepository;
import br.com.fiap.assistentx.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        String tipoOrigem = HelperService.buscar(
                origemTransacaoRepository,
                transacaoDTO.getOrigemId(),
                "Origem da Transação").getTipo();

        if(tipoOrigem.equals("E") && transacaoDTO.getValor() < 0 ||
                tipoOrigem.equals("S") && transacaoDTO.getValor() > 0) {
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

    public TransacaoDTO buscarPorId(Integer usuarioId, Integer transacaoId, String tipo) {
        Transacao transacao = HelperService.buscarDoUsuario(transacaoRepository
                .findByIdAndUsuarioId(transacaoId, usuarioId),"Transação");

        validarTipo(transacao, tipo);

        return toDTO(transacao);
    }

    public List<TransacaoDTO> listar(Integer usuarioId, String tipo) {
        List<Transacao> transacoes;

        if (tipo.equals("E")) {
            transacoes = transacaoRepository.findByUsuarioIdAndValorGreaterThan(usuarioId, 0);
        } else if (tipo.equals("S")) {
            transacoes = transacaoRepository.findByUsuarioIdAndValorLessThan(usuarioId, 0);
        } else {
            throw new RuntimeException("Tipo inválido");
        }

        return transacoes.stream()
                .map(this::toDTO)
                .toList();
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

    public void excluir(Integer usuarioId, Integer transacaoId, String tipo) {

        Transacao transacao = HelperService.buscarDoUsuario(transacaoRepository
                .findByIdAndUsuarioId(transacaoId, usuarioId),"Transação");

        validarTipo(transacao, tipo);

        transacaoRepository.delete(transacao);
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