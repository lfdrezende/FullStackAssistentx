package br.com.assistentx.fintech.model;

import java.util.ArrayList;
import java.util.List;

public class Modelo {
    List<CategoriaModelo> modelo = new ArrayList<>();
    private int id;
    private String nome;
    private String descricao;
    private double saidas;
    private double entradas;
    private double patrimonio;

    public Modelo adicionarCategoria(CategoriaModelo categoriaModelo) {
        modelo.add(categoriaModelo);
        return this;
    }

    /*public Modelo calcularTransacoes(Usuario usuario) {
        TransacaoDAO transacaoDAO = new TransacaoDAO();

        try {
            Transacoes saidas = transacaoDAO.getAll(usuario, "S");
            this.saidas = saidas.calcularTotal();
            Transacoes entradas = transacaoDAO.getAll(usuario, "E");
            this.entradas = entradas.calcularTotal();

        } catch (Exception e) {
            System.out.println("Erro ao buscar transações: " + e.getMessage());
        } finally {
            transacaoDAO.fecharConexao();
        }
        return this;

    }
    public Modelo calcularPatrimonio(Usuario usuario) {
        InvestimentoDAO investimentoDAO = new InvestimentoDAO();

        try {
            Patrimonio investimentos = investimentoDAO.getAll(usuario);

            double totalMontante=0;

            for (Investimento i : investimentos) {
                totalMontante += i.getValorAtual();

            }
            this.patrimonio = totalMontante;

        } catch (Exception e) {
            System.out.println("Erro ao buscar Investimentos: " + e.getMessage());
        } finally {
            investimentoDAO.fecharConexao();
        }
        return this;

    }*/

    public String getNome() {
        return nome;
    }

    public double getEntradas() {
        return entradas;
    }

    public double getSaidas() {
        return saidas;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public List<CategoriaModelo> getCategorias() {
        return modelo;
    }

    public void setEntradas(double entradas) {
        this.entradas = entradas;
    }

    public void setSaidas(double saidas) {
        this.saidas = saidas;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
