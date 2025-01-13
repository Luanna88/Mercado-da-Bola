import model.ApetiteFinanceiro;
import model.Clube;
import model.Negociacao;
import org.junit.Assert;
import org.junit.Test;
import tiposdejogador.Goleiro;

import java.math.BigDecimal;

public class GoleiroTest {
    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, BigDecimal.valueOf(100000000));
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, ApetiteFinanceiro.INDIFERENTE, BigDecimal.valueOf(800500), 12);

        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        Assert.assertTrue(foiPossivelNegociar);
    }
    @Test
    public void deveRetornarTrueQuandoClubeTemReputacaoHistoricaMaiorOuIgualAUm() {
        Clube clube = new Clube("Internacional", 10, BigDecimal.valueOf(5000000));
        clube.setReputacaoHistorica(1); // Reputação igual a 1

        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, clube, 8, ApetiteFinanceiro.INDIFERENTE, BigDecimal.valueOf(800500), 12);
        boolean temInteresse = goleiro.temInteresseEmClube(clube);

        Assert.assertTrue(temInteresse);
    }

    @Test
    public void deveRetornarFalseQuandoClubeTemReputacaoHistoricaMenorQueUm() {
        Clube clube = new Clube("Juventude", 10, BigDecimal.valueOf(3000000));
        clube.setReputacaoHistorica(0); // Reputação menor que 1

        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, clube, 8, ApetiteFinanceiro.INDIFERENTE, BigDecimal.valueOf(800500), 12);
        boolean temInteresse = goleiro.temInteresseEmClube(clube);

        Assert.assertFalse(temInteresse);
    }
}
