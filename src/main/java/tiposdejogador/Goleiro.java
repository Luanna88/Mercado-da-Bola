package tiposdejogador;

import model.ApetiteFinanceiro;
import model.Clube;
import java.math.BigDecimal;

public class Goleiro extends Jogador{
    private int penaltisDefendidos;

    public Goleiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int penaltisDefendidos) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.penaltisDefendidos = penaltisDefendidos;
    }

    @Override
    public BigDecimal getValorDeCompra() {
        BigDecimal valorBase = super.getValorDeCompra();
        BigDecimal adicional = valorBase.multiply(BigDecimal.valueOf(0.04 * penaltisDefendidos));
        return valorBase.add(adicional);
    }

    @Override
    public boolean temInteresseEmClube(Clube clube) {
        return clube.getReputacaoHistorica() >= 1;
    }
}
