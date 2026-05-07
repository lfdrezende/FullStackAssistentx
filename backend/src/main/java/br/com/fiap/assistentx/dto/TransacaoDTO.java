package br.com.fiap.assistentx.dto;

import br.com.fiap.assistentx.model.Transacao;
import java.time.OffsetDateTime;

public class TransacaoDTO {

    private Integer transacaoId;
    private Integer usuarioId;
    private Double valor;
    private OffsetDateTime dataHora;
    private Integer origemId;
    private String origemNome;
    private String origemTipo;

    public TransacaoDTO (
            Integer transacaoId,
            Integer usuarioId,
            Double valor,
            OffsetDateTime dataHora,
            Integer origemId,
            String origemNome,
            String origemTipo
    ) {
        this.transacaoId = transacaoId;
        this.usuarioId = usuarioId;
        this.valor = valor;
        this.dataHora = dataHora;
        this.origemId = origemId;
        this.origemNome = origemNome;
        this.origemTipo = origemTipo;
    }

    public Integer getTransacaoId() {
        return transacaoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public Integer getOrigemId() {
        return origemId;
    }

    public String getOrigemNome() {
        return origemNome;
    }

    public String getOrigemTipo() {
        return origemTipo;
    }


}
