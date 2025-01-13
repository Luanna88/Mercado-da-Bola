package model;

import tiposdejogador.Jogador;

import java.math.BigDecimal;

public class Negociacao {
    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse) {
        if (!jogadorDeInteresse.temInteresseEmClube(clubeInteressado)) {
            return false;
        }

        BigDecimal valorDeCompra = jogadorDeInteresse.getValorDeCompra();
        if (clubeInteressado.getSaldoDisponivel().compareTo(valorDeCompra) < 0) {
            return false; // Saldo insuficiente
        }

        clubeInteressado.debitar(valorDeCompra);
        jogadorDeInteresse.transferirParaClube(clubeInteressado);
        return true;
            }
}
