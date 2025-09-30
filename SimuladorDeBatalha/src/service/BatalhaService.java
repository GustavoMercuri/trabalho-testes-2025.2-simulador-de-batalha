package service;

import model.entidades.Ataque;
import model.entidades.Criatura;
import model.interfaces.Equipamento;
import util.StatusEfeito;

import java.util.Random;

public class BatalhaService {

    private Criatura criatura1;
    private Criatura criatura2;
    private Random random;

    public BatalhaService(Criatura criatura1, Criatura criatura2) {
        this.criatura1 = criatura1;
        this.criatura2 = criatura2;
        this.random = new Random();
    }

    private void aplicarEfeitos(Criatura criatura) {
        switch (criatura.getStatus()) {
            case QUEIMADO:
                criatura.receberDano(5);
                System.out.println(criatura.getNome() + " sofre 5 de dano por queimadura!");
                break;
            case ENVENENADO:
                criatura.receberDano(3);
                System.out.println(criatura.getNome() + " sofre 3 de dano por veneno!");
                break;
            case CONGELADO:
                System.out.println(criatura.getNome() + " está congelado e não pode agir!");
                break;
            default:
                break;
        }

        criatura.reduzirDuracaoStatus();
    }

    private void realizarAtaque(Criatura atacante, Criatura defensor, Ataque ataque) {

        if (ataque.getEfeito() != null && ataque.getEfeito().equalsIgnoreCase("CURAR")) {
            int cura = ataque.getPoder();
            atacante.curar(cura);
            System.out.println(atacante.getNome() + " usou " + ataque.getNome() + " e curou " + cura + " de vida! (HP: " + atacante.getVida() + ")");
            return;
        }

        double multiplicador = CalculadoraElemental.calcularMultiplicador(atacante.getTipo(), defensor.getTipo());
        int dano = (int) ((atacante.getAtaque() + ataque.getPoder() - defensor.getDefesa()) * multiplicador);

        if (dano < 1) dano = 1;

        defensor.receberDano(dano);

        System.out.println(atacante.getNome() + " usou " + ataque.getNome() + " e causou " + dano + " de dano em " + defensor.getNome());

        switch (ataque.getTipo().toUpperCase()) {
            case "FOGO":
                defensor.aplicarStatus(StatusEfeito.QUEIMADO, 3);
                break;
            case "VENENO":
                defensor.aplicarStatus(StatusEfeito.ENVENENADO, 5);
                break;
            case "GELO":
                defensor.aplicarStatus(StatusEfeito.CONGELADO, 1);
                break;
            default:
                break;
        }
    }

    public void iniciarBatalha() {
        System.out.println("Batalha entre " + criatura1.getNome() + " e " + criatura2.getNome() + " começou!");

        Criatura atacante, defensor;

        if (criatura1.getVelocidade() > criatura2.getVelocidade()) {
            atacante = criatura1;
            defensor = criatura2;
        } else if (criatura2.getVelocidade() > criatura1.getVelocidade()) {
            atacante = criatura2;
            defensor = criatura1;
        } else {
            if (random.nextBoolean()) {
                atacante = criatura1;
                defensor = criatura2;
            } else {
                atacante = criatura2;
                defensor = criatura1;
            }
        }

        while (criatura1.estaViva() && criatura2.estaViva()) {

            if (atacante.getStatus() == StatusEfeito.CONGELADO) {
                System.out.println(atacante.getNome() + " está congelado e perdeu o turno!");
                atacante.reduzirDuracaoStatus();
            } else {
                if (!atacante.getAtaques().isEmpty()) {
                    int index = random.nextInt(atacante.getAtaques().size());
                    Ataque ataque = atacante.getAtaques().get(index);
                    realizarAtaque(atacante, defensor, ataque);
                }
            }

            aplicarEfeitos(atacante);
            aplicarEfeitos(defensor);

            if (!criatura1.estaViva() || !criatura2.estaViva()) {
                break;
            }

            Criatura temp = atacante;
            atacante = defensor;
            defensor = temp;
        }

        Criatura vencedor;
        if (criatura1.estaViva()) {
            vencedor = criatura1;
        } else {
            vencedor = criatura2;
        } System.out.println("A batalha terminou! O vencedor é " + vencedor.getNome());
    }



}
