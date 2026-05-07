package br.com.fiap.assistentx.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@MappedSuperclass
public abstract class EntidadeFinanceira {
    protected double valor;
    protected OffsetDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    protected Usuario usuario;

    public EntidadeFinanceira() {}

    public EntidadeFinanceira(Usuario usuario, double valor, OffsetDateTime dataHora) {
        if (valor == 0) {
            throw new IllegalArgumentException("O valor não pode ser 0.");
        }
        this.usuario = usuario;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}