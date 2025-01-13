package tiposdejogador;

import model.ApetiteFinanceiro;
import model.Clube;
import java.math.BigDecimal;

public abstract class Jogador {
    private String nome;
    private int idade;
    private Clube clubeAtual;
    private int reputacaoHistorica;
    private ApetiteFinanceiro apetiteFinanceiro;
    private BigDecimal preco;

    public Jogador(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
        if (reputacaoHistorica < 0 || reputacaoHistorica > 10) {
            throw new IllegalArgumentException("Reputação inválida. Deve estar entre 0 e 10.");
        }
        this.nome = nome;
        this.idade = idade;
        this.clubeAtual = clubeAtual;
        this.reputacaoHistorica = reputacaoHistorica;
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.preco = preco;
    }

    public String getNomeClubeAtual() {
        return clubeAtual == null ? "Sem Clube" : clubeAtual.getNome();
    }

    public abstract boolean temInteresseEmClube(Clube clube);

    public BigDecimal getValorDeCompra() {
        BigDecimal ajuste = apetiteFinanceiro.getAjustePercentual();
        return preco.add(preco.multiply(ajuste));
    }

    public void transferirParaClube(Clube novoClube) {
        this.clubeAtual = novoClube;
    }

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getIdade() {
        return idade;
    }
}