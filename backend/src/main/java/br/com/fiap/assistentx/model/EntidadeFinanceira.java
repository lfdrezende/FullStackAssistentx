package br.com.assistentx.fintech.model;

import java.time.OffsetDateTime;

public abstract class EntidadeFinanceira {

    final double valor;
    final OffsetDateTime dataHora;
    int id;
    final Usuario usuario;

    public EntidadeFinanceira(Usuario usuario, double valor, OffsetDateTime dataHora, int id) {
        if (valor == 0) {
            throw new IllegalArgumentException("O valor não pode ser nulo.");
        }
        this.usuario = usuario;
        this.valor = valor;
        this.dataHora = dataHora;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public OffsetDateTime getDataHora(){
        return dataHora;
    }
}
