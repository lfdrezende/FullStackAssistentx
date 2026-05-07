package br.com.fiap.assistentx.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Patrimonio implements Iterable <Investimento> {

    private final List<Investimento> patrimonio = new ArrayList<>();

    public Patrimonio adicionarInvestimento(Investimento investimento) {
        patrimonio.add(investimento);
        return this;
    }

    @Override
    public Iterator<Investimento> iterator() {
        return patrimonio.iterator();
    }

    /*public List<Investimento> getPatrimonio() {
        return Collections.unmodifiableList(patrimonio); //serve para criar lista imutavel, encapsulando a classe
    }*/

    public String calcularTotal() {

        double totalMontante = 0;
        double totalReceitaMensal = 0;
        double totalMontanteParaJuros = 0;
        double totalReceitaMensalParaJuros = 0;
        double jurosEstimados;

        for (Investimento i : patrimonio) {
            totalMontante += i.getValorAtual();
            totalReceitaMensal += i.getUltimaReceitaMensal();

            if (i.getTipo().getValorizacao().equals("S")) {
                totalReceitaMensalParaJuros += i.getUltimaReceitaMensal();
                totalMontanteParaJuros += i.getValorAtual();
            }
        }

        if (totalMontanteParaJuros > 0) {
            jurosEstimados = totalReceitaMensalParaJuros / totalMontanteParaJuros;
        } else {
            jurosEstimados = 0;
        }
        return String.format(
                "Montante Total: R$ %.2f, Valorização ativos financeiros: %.2f%%, Receita no último mês: R$ %.2f",
                totalMontante,
                jurosEstimados * 100,
                totalReceitaMensal
        );
    }
}
