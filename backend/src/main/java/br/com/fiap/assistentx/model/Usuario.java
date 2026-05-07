package br.com.fiap.assistentx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_ax_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "nm_usuario")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    public Usuario() {}

    public Usuario(String email, String nome, Modelo modelo) {
        this.email = email;
        this.nome = nome;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}