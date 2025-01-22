import model.Clube;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class ClubeTest {
    @Test
    public void testGetNome() {
        Clube clube = new Clube("Clube A", 100, new BigDecimal("1000.00"));
        Assert.assertEquals("Clube A", clube.getNome());
    }

    @Test
    public void testGetReputacaoHistorica() {
        Clube clube = new Clube("Clube A", 100, new BigDecimal("1000.00"));
        Assert.assertEquals(100, clube.getReputacaoHistorica());
    }

    @Test
    public void testSetReputacaoHistorica() {
        Clube clube = new Clube("Clube A", 100, new BigDecimal("1000.00"));
        clube.setReputacaoHistorica(200);
        Assert.assertEquals(200, clube.getReputacaoHistorica());
    }

    @Test
    public void testGetSaldoDisponivel() {
        Clube clube = new Clube("Clube A", 100, new BigDecimal("1000.00"));
        Assert.assertEquals(new BigDecimal("1000.00"), clube.getSaldoDisponivel());
    }

    @Test
    public void testDebitarComSaldoSuficiente() {
        Clube clube = new Clube("Clube A", 100, new BigDecimal("1000.00"));
        clube.debitar(new BigDecimal("500.00"));
        Assert.assertEquals(new BigDecimal("500.00"), clube.getSaldoDisponivel());
    }

    @Test
    public void testDebitarComSaldoInsuficiente() {
        Clube clube = new Clube("Clube A", 100, new BigDecimal("100.00"));
        Exception exception = Assert.assertThrows(IllegalStateException.class, () -> {
            clube.debitar(new BigDecimal("200.00"));
        });
        Assert.assertEquals("Saldo insuficiente", exception.getMessage());
    }
}
