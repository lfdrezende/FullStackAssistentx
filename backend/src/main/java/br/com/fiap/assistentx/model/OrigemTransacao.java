package br.com.fiap.assistentx.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "t_ax_origem")
public class OrigemTransacao {

    @Id
    @Column(name = "id_origem")
    private Integer id;

    @Column(name = "nm_origem")
    private String nome;

    @Column(name = "tipo_origem")
    private String tipo;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}