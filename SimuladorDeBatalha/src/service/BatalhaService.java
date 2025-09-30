package service;

import model.entidades.Ataque;
import model.entidades.Criatura;
import model.interfaces.Item;
import model.itens.*;
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

    private int duracaoPadrao(StatusEfeito status) {
        if (status == null) return 0;
        switch (status) {
            case QUEIMADO: return 3;
            case ENVENENADO: return 5;
            case CONGELADO: return 1;
            default: return 0;
        }
    }

    private void realizarAtaque(Criatura atacante, Criatura defensor, Ataque ataque) {

        if (ataque.isCura()) {
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

        if (ataque.getEfeitoStatus() != StatusEfeito.NORMAL && ataque.aplicaEfeito()) {
            int dur = duracaoPadrao(ataque.getEfeitoStatus());
            defensor.aplicarStatus(ataque.getEfeitoStatus(), dur);
            System.out.println(defensor.getNome() + " foi afetado por " + ataque.getEfeitoStatus() + " por " + dur + " turnos!");
        }
    }

    private void usarItem(Criatura criatura, Item item) {
        item.aplicar(criatura);
        System.out.println(criatura.getNome() + " usou " + item.getNome() + "!");
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
                if (atacante.getStatus() != StatusEfeito.NORMAL && random.nextInt(100) < 30) {
                    Item itemParaStatus = null;
                    for (Item it : atacante.getInventario()) {
                        if ( (atacante.getStatus() == StatusEfeito.ENVENENADO && it instanceof Antidoto)
                                || (atacante.getStatus() == StatusEfeito.QUEIMADO && it instanceof ElixirdeFogo)
                                || (atacante.getStatus() == StatusEfeito.CONGELADO && it instanceof ElixirdeGelo) ) {
                            itemParaStatus = it;
                            break;
                        }
                    }
                    if (itemParaStatus != null) {
                        usarItem(atacante, itemParaStatus);
                        atacante.getInventario().remove(itemParaStatus);
                    } else {
                        if (!atacante.getAtaques().isEmpty()) {
                            Ataque ataque = atacante.getAtaques().get(random.nextInt(atacante.getAtaques().size()));
                            realizarAtaque(atacante, defensor, ataque);
                        }
                    }
                } else if (atacante.getVida() < atacante.getVidaMax() * 0.3) {
                    Item pocao = null;
                    for (Item it : atacante.getInventario()) {
                        if (it instanceof SuperPocao) { pocao = it; break; } // prioriza super poção
                    }
                    if (pocao == null) {
                        for (Item it : atacante.getInventario()) {
                            if (it instanceof PocaoCura) { pocao = it; break; }
                        }
                    }
                    if (pocao != null) {
                        usarItem(atacante, pocao);
                        atacante.getInventario().remove(pocao);
                    } else if (!atacante.getAtaques().isEmpty()) {
                        Ataque ataque = atacante.getAtaques().get(random.nextInt(atacante.getAtaques().size()));
                        realizarAtaque(atacante, defensor, ataque);
                    }
                } else {
                    if (!atacante.getAtaques().isEmpty()) {
                        Ataque ataque = atacante.getAtaques().get(random.nextInt(atacante.getAtaques().size()));
                        realizarAtaque(atacante, defensor, ataque);
                    }
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
