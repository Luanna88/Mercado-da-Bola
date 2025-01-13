package tiposdejogador;

import model.ApetiteFinanceiro;
import model.Clube;
import java.math.BigDecimal;

public class Atacante extends Jogador {
    private int golsFeitos;

    public Atacante(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int golsFeitos) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.golsFeitos = golsFeitos;
    }

    @Override
    public BigDecimal getValorDeCompra() {
        BigDecimal valorBase = super.getValorDeCompra();
        BigDecimal adicional = valorBase.multiply(BigDecimal.valueOf(0.01 * golsFeitos));
        if (getIdade() > 30) {
            return valorBase.add(adicional).multiply(BigDecimal.valueOf(0.75));
        }
        return valorBase.add(adicional);
    }

    @Override
    public boolean temInteresseEmClube(Clube clube) {
        return clube.getReputacaoHistorica() > getReputacaoHistorica();
    }
}
