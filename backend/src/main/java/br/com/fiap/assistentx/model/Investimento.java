package br.com.assistentx.fintech.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class Investimento extends EntidadeFinanceira {
    private double montanteAtual;
    private TipoInvestimento tipo;
    private double ultimaReceitaMensal;
    private Double jurosEstimados;

    public Investimento(Usuario usuario,double valor, double montanteAtual, TipoInvestimento tipo, OffsetDateTime dataHora) {
        this(usuario, valor, montanteAtual, tipo, dataHora, null, 0.0, 0);
    }

    public Investimento(Usuario usuario,double valor, double montanteAtual, TipoInvestimento tipo, OffsetDateTime dataHora, int id) {
        this(usuario, valor, montanteAtual, tipo, dataHora, null, 0.0, id);
    }

    public Investimento(Usuario usuario, double valor, double montanteAtual, TipoInvestimento tipo, OffsetDateTime dataHora, Double jurosEstimados, double ultimaReceitaMensal, int id) {
        super(usuario, valor, dataHora, id);
        if (montanteAtual <= 0) {
            throw new IllegalArgumentException("O valor do investimento não pode ser negativo.");
        }
        this.montanteAtual = montanteAtual;
        this.tipo = tipo;
        this.jurosEstimados = jurosEstimados;
        this.ultimaReceitaMensal = ultimaReceitaMensal;
    }

    private long calcularMeses(){
        return ChronoUnit.MONTHS.between(
                this.dataHora.toLocalDate(),
                LocalDate.now());
    }

    public Investimento calcularJuros() {

        long meses = calcularMeses();

        if (meses <= 0) {
            this.jurosEstimados = 0.0;
            return this;
        }

        if (this.valor == 0) {
            throw new ArithmeticException("Montante inicial não pode ser zero.");
        }

        this.jurosEstimados = Math.pow(
                (this.montanteAtual / this.valor),
                (1.0 / meses)
        ) - 1;
        return this;
    }

    public Investimento calcularUltimaReceitaMensal() {

        long meses = calcularMeses();

        if (meses <= 0) {
            this.ultimaReceitaMensal = 0;
            return this;
        }

        double taxaMensal = Math.pow(
                (this.montanteAtual / this.valor),
                (1.0 / meses)
        ) - 1;

        this.ultimaReceitaMensal = this.montanteAtual * taxaMensal;
        return this;
    }

    public double getValorAtual(){
        return montanteAtual;
    }

    public double getValorInicial() {
        return valor;
    }

    double getUltimaReceitaMensal (){
        return ultimaReceitaMensal;
    }

    public OffsetDateTime getData (){
        return dataHora;
    }
    
    public TipoInvestimento getTipo () {
        return tipo;
    }

    public String exibir() {

        String jurosFormatado =
                (jurosEstimados == null)
                        ? "N/A"
                        : String.format("%.2f%%", jurosEstimados * 100);

        return String.format(
                "Montante: %.2f, Tipo: %s, Juros: %s, Receita no último mês: %.2f, ID: %d",
                montanteAtual,
                tipo.getNome(),
                jurosFormatado,
                ultimaReceitaMensal,
                id
        );
    }

}
