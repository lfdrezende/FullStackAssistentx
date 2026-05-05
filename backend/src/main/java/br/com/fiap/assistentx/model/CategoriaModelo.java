package br.com.assistentx.fintech.model;

import java.util.ArrayList;
import java.util.List;

public class CategoriaModelo {
    List<OrigemTransacao> categoriaModelo = new ArrayList<>();
    private int id;
    private String nome;
    private double valor;
    private double total;

    public CategoriaModelo(int id, String nome, double valor, double total) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.total = total;
    }

    /*public CategoriaModelo adicionarOrigem(OrigemTransacao origemTransacao) {
        categoriaModelo.add(origemTransacao);
        return this;
    }*/

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public double getTotal() {return total;}
}
