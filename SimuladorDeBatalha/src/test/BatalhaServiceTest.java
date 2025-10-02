package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import model.entidades.Criatura;
import service.BatalhaService;
import model.entidades.Ataque;
import util.StatusEfeito;
import util.TipoElemental;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatalhaServiceTest {

    @Mock
    private Criatura atacante;

    @Mock
    private Criatura defensor;

    private BatalhaService batalha;

    @BeforeEach
    void setup() {
        batalha = new BatalhaService(atacante, defensor);
    }

    @Test
    void testCalculoDeDanoSimples() {
        Ataque ataque = new Ataque("Garra Dracônica", 10, TipoElemental.NORMAL);

        when(atacante.getAtaque()).thenReturn(20);
        when(defensor.getDefesa()).thenReturn(10);
        when(defensor.getTipo()).thenReturn(TipoElemental.TERRA);

        int dano = batalha.calcularDano(atacante, defensor, ataque);

        assertEquals(20, dano); // (20 + 10 - 10) * 1 = 20
    }

    @Test
    void testDanoComMultiplicadorElemental() {
        Ataque ataque = new Ataque("Jato de Água", 15, TipoElemental.AGUA, StatusEfeito.NORMAL, 0.0);

        when(atacante.getAtaque()).thenReturn(30);
        when(defensor.getDefesa()).thenReturn(5);
        when(defensor.getTipo()).thenReturn(TipoElemental.FOGO);

        int dano = batalha.calcularDano(atacante, defensor, ataque);

        assertEquals(80, dano); // (30 + 15 - 5) * 2 = 80
    }
    
    @Test
    void testAtaqueQueEnvenena() {
        Ataque veneno = new Ataque("Mordida Venenosa", 5, TipoElemental.NORMAL, StatusEfeito.ENVENENADO, 1.0);

        when(atacante.getAtaque()).thenReturn(20);
        when(defensor.getDefesa()).thenReturn(5);
        when(defensor.getTipo()).thenReturn(TipoElemental.NORMAL);
        when(defensor.getNome()).thenReturn("Goblin");

        batalha.calcularDano(atacante, defensor, veneno);

        verify(defensor).aplicarStatus(StatusEfeito.ENVENENADO, 5);
    }

    
    @Test
    void testAtaqueDeCura() {
        Ataque cura = new Ataque("Cura Mágica", 20, TipoElemental.NORMAL);
        cura.setCura(true);

        when(atacante.getNome()).thenReturn("Clérigo");

        int curaRecebida = batalha.calcularDano(atacante, defensor, cura);

        assertEquals(20, curaRecebida);
        verify(atacante).curar(20);
    }

    @Test
    void testDanoMinimoNuncaZero() {
        Ataque ataque = new Ataque("Soco Fraco", 5, TipoElemental.NORMAL);

        when(atacante.getAtaque()).thenReturn(5);
        when(defensor.getDefesa()).thenReturn(100);
        when(defensor.getTipo()).thenReturn(TipoElemental.NORMAL);

        int dano = batalha.calcularDano(atacante, defensor, ataque);

        assertEquals(1, dano);
    }

    @Test
    void testAplicarEfeitosEnvenenado() {
        when(defensor.getStatus()).thenReturn(StatusEfeito.ENVENENADO);

        batalha.aplicarEfeitos(defensor);

        verify(defensor).receberDano(3);
        verify(defensor).reduzirDuracaoStatus();
    }

    @Test
    void testAplicarEfeitosQueimado() {
        when(defensor.getStatus()).thenReturn(StatusEfeito.QUEIMADO);

        batalha.aplicarEfeitos(defensor);

        verify(defensor).receberDano(5);
        verify(defensor).reduzirDuracaoStatus();
    }

    @Test
    void testAplicarEfeitosCongelado() {
        when(defensor.getStatus()).thenReturn(StatusEfeito.CONGELADO);

        batalha.aplicarEfeitos(defensor);

        verify(defensor).reduzirDuracaoStatus();
    }


}
