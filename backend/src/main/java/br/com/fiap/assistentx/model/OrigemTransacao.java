package br.com.fiap.assistentx.model;

import jakarta.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "origem")
    private List<CategoriaOrigem> categorias;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public List<CategoriaOrigem> getCategorias() {
        return categorias;
    }
}