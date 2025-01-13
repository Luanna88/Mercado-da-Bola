package model;

import java.math.BigDecimal;

public enum ApetiteFinanceiro {
    INDIFERENTE(BigDecimal.ZERO),
    CONSERVADOR(BigDecimal.valueOf(0.40)),
    MERCENARIO(BigDecimal.valueOf(0.80));

    private final BigDecimal ajustePercentual;

    ApetiteFinanceiro(BigDecimal ajustePercentual) {
        this.ajustePercentual = ajustePercentual;
    }

    public BigDecimal getAjustePercentual() {
        return ajustePercentual;
    }
}