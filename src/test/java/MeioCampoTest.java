import model.ApetiteFinanceiro;
import org.junit.Assert;
import org.junit.Test;
import tiposdejogador.MeioCampo;
import model.Clube;

import java.math.BigDecimal;

public class MeioCampoTest {
    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos() {
        MeioCampo meioCampo = new MeioCampo("Kevin De Bruyne", 28, null, 8, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(500000));

        BigDecimal precoEsperado = BigDecimal.valueOf(500000).multiply(BigDecimal.valueOf(1.4));
        BigDecimal precoCalculado = meioCampo.getValorDeCompra();

        Assert.assertEquals(precoEsperado, precoCalculado);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos() {
        MeioCampo meioCampo = new MeioCampo("Luka Modric", 35, null, 9, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(1000000));

        BigDecimal valorBase = BigDecimal.valueOf(1000000).multiply(BigDecimal.valueOf(1.4));
        BigDecimal precoEsperado = valorBase.multiply(BigDecimal.valueOf(0.70));
        BigDecimal precoCalculado = meioCampo.getValorDeCompra();

        Assert.assertEquals(precoEsperado, precoCalculado);
    }
    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComExatamenteTrintaAnos() {
        MeioCampo meioCampo = new MeioCampo("Casemiro", 30, null, 8, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(800000));

        BigDecimal precoEsperado = BigDecimal.valueOf(800000).multiply(BigDecimal.valueOf(1.4));
        BigDecimal precoCalculado = meioCampo.getValorDeCompra();

        Assert.assertEquals(precoEsperado, precoCalculado);
    }
    @Test
    public void deveRetornarZeroParaJogadorComPrecoBaseZero() {
        MeioCampo meioCampo = new MeioCampo("Jorginho", 28, null, 7, ApetiteFinanceiro.CONSERVADOR, BigDecimal.ZERO);
        BigDecimal precoEsperado = BigDecimal.ZERO;

        BigDecimal precoCalculado = meioCampo.getValorDeCompra();

        Assert.assertEquals(0, precoCalculado.compareTo(precoEsperado));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoParaIdadeNegativa() {
        MeioCampo meioCampo = new MeioCampo("Jogador Invalido", -5, null, 6, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(500000));
        meioCampo.getValorDeCompra(); // Não é necessário chamar, o erro ocorre na criação
    }
    @Test
    public void deveCalcularCorretamenteParaJogadorComPrecoMuitoAlto() {
        MeioCampo meioCampo = new MeioCampo("Neymar Jr.", 28, null, 10, ApetiteFinanceiro.MERCENARIO, BigDecimal.valueOf(1000000000));
        BigDecimal precoEsperado = BigDecimal.valueOf(1000000000).multiply(BigDecimal.valueOf(1.4));
        BigDecimal precoCalculado = meioCampo.getValorDeCompra();

        Assert.assertEquals(precoEsperado, precoCalculado);
    }

    @Test
    public void deveCalcularCorretamenteParaJogadorComIdadeMuitoAlta() {
        MeioCampo meioCampo = new MeioCampo("Jogador Experiente", 105, null, 5, ApetiteFinanceiro.INDIFERENTE, BigDecimal.valueOf(100000));

        BigDecimal valorBase = BigDecimal.valueOf(100000).multiply(BigDecimal.valueOf(1.4));
        BigDecimal precoEsperado = valorBase.multiply(BigDecimal.valueOf(0.70));
        BigDecimal precoCalculado = meioCampo.getValorDeCompra();

        Assert.assertEquals(precoEsperado, precoCalculado);
    }

    @Test
    public void deveRetornarInteresseQuandoReputacaoHistoricaDoClubeForAdequada() {
        Clube clube = new Clube("Clube de Interesse", 5, BigDecimal.valueOf(5000000));
        MeioCampo meioCampo = new MeioCampo("Jogador Interessado", 25, clube, 7, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(100000));

        Assert.assertTrue(meioCampo.temInteresseEmClube(clube));
    }

    @Test
    public void naoDeveRetornarInteresseQuandoReputacaoHistoricaDoClubeForMuitoAlta() {
        Clube clube = new Clube("Clube Muito Famoso", 10, BigDecimal.valueOf(10000000));
        MeioCampo meioCampo = new MeioCampo("Jogador Não Interessado", 25, clube, 7, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(100000));

        Assert.assertFalse(meioCampo.temInteresseEmClube(clube));
    }

    @Test
    public void naoDeveRetornarInteresseComClubeNulo() {
        MeioCampo meioCampo = new MeioCampo("Jogador Sem Clube", 25, null, 7, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(100000));

        Assert.assertFalse(meioCampo.temInteresseEmClube(null));
    }
}
