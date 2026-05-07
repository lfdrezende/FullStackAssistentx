package br.com.fiap.assistentx.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Transacoes implements Iterable<Transacao>{

    List<Transacao> transacoes = new ArrayList<>();

    public double calcularTotal() {
        double total = 0;
        for (Transacao t : transacoes) {
            total += t.getValor();
        }
        return total;
    }

    public Iterator<Transacao> iterator() {
        return transacoes.iterator();
    }

    public abstract String getTipo();

    public abstract String getDescricao();

    public Transacoes adicionarTransacao(Transacao transacao) {
        if (transacao.getTipo().equals(getTipo())) {
            transacoes.add(transacao);
        } else {
            System.out.println("Tipo de transação inválido para esta operação.");
        }
        return this;
    }

}
