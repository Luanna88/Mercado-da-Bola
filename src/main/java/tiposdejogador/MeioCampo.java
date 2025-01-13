package tiposdejogador;

import model.ApetiteFinanceiro;
import model.Clube;
import java.math.BigDecimal;

public class MeioCampo extends Jogador{
    public MeioCampo(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    @Override
    public BigDecimal getValorDeCompra() {
        BigDecimal valorBase = this.getPreco().multiply(BigDecimal.valueOf(1.4));

        if (getIdade() > 30) {
            return valorBase.multiply(BigDecimal.valueOf(0.70));
        }

        return valorBase;
    }

    public boolean temInteresseEmClube(Clube clube) {
        if (clube == null) {
            return false; 
        }
        return clube.getReputacaoHistorica() <= (getReputacaoHistorica() - 2);
    }
}
