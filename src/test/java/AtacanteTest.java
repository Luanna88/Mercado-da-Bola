import model.ApetiteFinanceiro;
import model.Clube;
import model.Negociacao;
import org.junit.Assert;
import org.junit.Test;
import tiposdejogador.Atacante;
import java.math.BigDecimal;

public class AtacanteTest {
    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(100000000));
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 10, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(800500), 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void deveAplicarDescontoParaJogadorComMaisDeTrintaAnos() {
        Atacante atacante = new Atacante("Cristiano Ronaldo", 31, null, 5, ApetiteFinanceiro.INDIFERENTE, BigDecimal.valueOf(500000), 20);

        BigDecimal valorBase = BigDecimal.valueOf(500000);
        BigDecimal adicional = valorBase.multiply(BigDecimal.valueOf(0.01 * 20));
        BigDecimal valorEsperado = valorBase.add(adicional).multiply(BigDecimal.valueOf(0.75));

        Assert.assertEquals(valorEsperado, atacante.getValorDeCompra());
    }

    @Test
    public void naoDeveAplicarDescontoParaJogadorComMenosDeTrintaAnos() {
        Atacante atacante = new Atacante("Cristiano Ronaldo", 25, null, 7, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(700000), 10);

        BigDecimal valorBase = BigDecimal.valueOf(700000).multiply(BigDecimal.valueOf(1.4));
        BigDecimal adicional = valorBase.multiply(BigDecimal.valueOf(0.01 * 10));
        BigDecimal valorEsperado = valorBase.add(adicional);

        Assert.assertEquals(valorEsperado, atacante.getValorDeCompra());
    }

    @Test
    public void deveTerInteresseEmClubeComReputacaoMaior() {
        Atacante atacante = new Atacante("Cristiano Ronaldo", 28, null, 5, ApetiteFinanceiro.MERCENARIO, BigDecimal.valueOf(1000000), 15);

        Clube clubeInteressante = new Clube("Clube Reputado", 6, BigDecimal.valueOf(5000000));

        Assert.assertTrue(atacante.temInteresseEmClube(clubeInteressante));
    }

    @Test
    public void naoDeveTerInteresseEmClubeComReputacaoMenorOuIgual() {
        Atacante atacante = new Atacante("Cristiano Ronaldo", 30, null, 7, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(1200000), 12);

        Clube clubeNaoInteressante = new Clube("Clube Pequeno", 5, BigDecimal.valueOf(3000000));

        Assert.assertFalse(atacante.temInteresseEmClube(clubeNaoInteressante));
    }
}
