package br.com.assistentx.fintech.model;

public class Usuario {
    private int id;
    private String email;
    private String nome;
    private int modelo;

    public Usuario (int id, String email, String nome, int modelo) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public int getModelo() {
        return modelo;
    }
}
