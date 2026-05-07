package br.com.fiap.assistentx.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "t_ax_investimento")
@AttributeOverrides({
        @AttributeOverride(name = "valor", column = @Column(name = "vl_inicial")),
        @AttributeOverride(name = "dataHora", column = @Column(name = "dt_inicio"))
})
public class Investimento extends EntidadeFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_investimento")
    @SequenceGenerator(
            name = "seq_investimento",
            sequenceName = "sequencia_investimento",
            allocationSize = 1
    )
    @Column(name = "id_investimento")
    private Integer id;

    @Column(name = "vl_atual")
    private double montanteAtual;

    @ManyToOne
    @JoinColumn(name = "id_investimento_tipo")
    private TipoInvestimento tipo;

    @Transient
    private double ultimaReceitaMensal;

    @Transient
    private Double jurosEstimados;

    public Investimento() {}

    public Investimento(
            Usuario usuario,
            double valor,
            double montanteAtual,
            TipoInvestimento tipo,
            OffsetDateTime dataHora
    ) {
        this(usuario, valor, montanteAtual, tipo, dataHora,null);
    }

    public Investimento(
            Usuario usuario,
            double valor,
            double montanteAtual,
            TipoInvestimento tipo,
            OffsetDateTime dataHora,
            Integer id
    ) {
        super(usuario, valor, dataHora);

        if (valor < 0) {
            throw new IllegalArgumentException("O valor inical do investimento não pode ser negativo.");
        }

        this.montanteAtual = montanteAtual;
        this.tipo = tipo;
        this.id = id;
    }

    // ======================
    // LÓGICA DE NEGÓCIO (OK)
    // ======================

    private long calcularMeses(){
        return ChronoUnit.MONTHS.between(
                this.dataHora.toLocalDate(),
                LocalDate.now());
    }

    public void calcularJuros() {

        long meses = calcularMeses();

        if (meses <= 0) {
            this.jurosEstimados = 0.0;
            return;
        }

        if (this.valor == 0) {
            throw new ArithmeticException("Montante inicial não pode ser zero.");
        }

        this.jurosEstimados = Math.pow(
                (this.montanteAtual / this.valor),
                (1.0 / meses)
        ) - 1;
    }

    public void calcularUltimaReceitaMensal() {

        long meses = calcularMeses();

        if (meses <= 0) {
            this.ultimaReceitaMensal = 0;
            return;
        }

        double taxaMensal = Math.pow(
                (this.montanteAtual / this.valor),
                (1.0 / meses)
        ) - 1;

        this.ultimaReceitaMensal = this.montanteAtual * taxaMensal;
    }

    // ======================
    // GETTERS E SETTERS
    // ======================

    public double getMontanteAtual() {
        return montanteAtual;
    }

    public double getValorAtual() {
        return montanteAtual;
    }

    public double getUltimaReceitaMensal() {
        return ultimaReceitaMensal;
    }

    public Double getJurosEstimados() {
        return jurosEstimados;
    }

    public TipoInvestimento getTipo() {
        return tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMontanteAtual(double montanteAtual) {
        this.montanteAtual = montanteAtual;
    }

    public void setTipo(TipoInvestimento tipo) {
        this.tipo = tipo;
    }

    public void setUltimaReceitaMensal(double ultimaReceitaMensal) {
        this.ultimaReceitaMensal = ultimaReceitaMensal;
    }

    public void setJurosEstimados(Double jurosEstimados) {
        this.jurosEstimados = jurosEstimados;
    }
}
