import model.ApetiteFinanceiro;
import model.Clube;
import model.Negociacao;
import org.junit.Assert;
import org.junit.Test;
import tiposdejogador.Jogador;

import java.math.BigDecimal;

public class NegociacaoTest {

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Clube Pequeno", 5, BigDecimal.valueOf(500000));

        Jogador jogador = new Jogador("Jogador X", 28, null, 5, ApetiteFinanceiro.CONSERVADOR, BigDecimal.valueOf(700000)) {
            @Override
            public boolean temInteresseEmClube(Clube clube) {
                return true;
            }
        };

        boolean foiPossivelNegociar = negociacao.negociar(clube, jogador);

        Assert.assertFalse(foiPossivelNegociar);
    }
}
