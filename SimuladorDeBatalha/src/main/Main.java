package main;

import model.entidades.Ataque;
import model.entidades.Criatura;
import model.equipamentos.ArmaduraDraconica;
import model.equipamentos.ElmodoSabio;
import model.interfaces.Equipamento;
import service.BatalhaService;
import util.TipoElemental;


public class Main {
    public static void main(String[] args) {
        Criatura dragao = new Criatura("Dragão de Fogo", 80, 15, 8, 10, TipoElemental.FOGO);
        //aplicar equipamentos
        new ArmaduraDraconica().equipar(dragao);
        dragao.getAtaques().add(new Ataque("Bola de Fogo", 12, "FOGO", "Queima o inimigo"));
        dragao.getAtaques().add(new Ataque("Garra Dracônica", 10, "NORMAL", "Corte poderoso"));
        dragao.getAtaques().add(new Ataque("Explosão de Lava", 14, "FOGO", "Erupção flamejante"));
        dragao.getAtaques().add(new Ataque("Asas Cortantes", 9, "AR", "Golpe rápido com as asas"));

        Criatura golem = new Criatura("Golem de Pedra", 100, 12, 15, 5, TipoElemental.TERRA);
        new ElmodoSabio().equipar(golem);
        golem.getAtaques().add(new Ataque("Soco de Pedra", 10, "TERRA", "Soco maciço que pode esmagar"));
        golem.getAtaques().add(new Ataque("Terremoto", 14, "TERRA", "Abala o chão e fere o inimigo"));
        golem.getAtaques().add(new Ataque("Arremesso de Rocha", 11, "TERRA", "Lança pedras afiadas"));
        golem.getAtaques().add(new Ataque("Esmagar", 13, "NORMAL", "Golpe físico brutal"));

        Criatura magoGelo = new Criatura("Mago de Gelo", 60, 14, 6, 12, TipoElemental.AGUA);

        magoGelo.getAtaques().add(new Ataque("Raio Congelante", 12, "GELO", "Congela o inimigo por 1 turno"));
        magoGelo.getAtaques().add(new Ataque("Bloco de Gelo", 10, "GELO", "CURAR"));
        magoGelo.getAtaques().add(new Ataque("Bola de Água", 11, "AGUA", "Molha e enfraquece o inimigo"));
        magoGelo.getAtaques().add(new Ataque("Punho Gélido", 9, "NORMAL", "Ataque físico com efeito frio"));

        Criatura serpente = new Criatura("Serpente Venenosa", 70, 13, 7, 15, TipoElemental.TREVAS);

        serpente.getAtaques().add(new Ataque("Mordida Venenosa", 10, "VENENO", "Envenena o inimigo"));
        serpente.getAtaques().add(new Ataque("Ataque Sorrateiro", 12, "NORMAL", "Golpe físico rápido"));
        serpente.getAtaques().add(new Ataque("Sopro Tóxico", 11, "VENENO", "Sopro envenenado"));
        serpente.getAtaques().add(new Ataque("Cobra Sombra", 13, "TREVAS", "Causa dano sombrio"));

        Criatura anjo = new Criatura("Anjo da Luz", 75, 14, 9, 14, TipoElemental.LUZ);

        anjo.getAtaques().add(new Ataque("Luz Divina", 12, "LUZ", "Fere o inimigo com luz sagrada"));
        anjo.getAtaques().add(new Ataque("Brilho Gentil", 15, "LUZ", "CURAR"));
        anjo.getAtaques().add(new Ataque("Golpe Celestial", 11, "NORMAL", "Ataque físico com poder celestial"));
        anjo.getAtaques().add(new Ataque("Luz Purificante", 10, "FOGO", "Queima o inimigo com luz"));

        Criatura vampiro = new Criatura("Vampiro Sombrio", 65, 15, 8, 13, TipoElemental.TREVAS);

        vampiro.getAtaques().add(new Ataque("Mordida Vampírica", 12, "TREVAS", "Drena a vida do inimigo"));
        vampiro.getAtaques().add(new Ataque("Garras Sombrias", 11, "NORMAL", "Ataque físico com garras afiadas"));
        vampiro.getAtaques().add(new Ataque("Sopro Noturno", 10, "VENENO", "Envenena o inimigo com veneno sombrio"));
        vampiro.getAtaques().add(new Ataque("Explosão Sombria", 14, "TREVAS", "Causa dano sombrio intenso"));

        Criatura elementalAr = new Criatura("Elemental do Ar", 70, 13, 7, 16, TipoElemental.AR);

        elementalAr.getAtaques().add(new Ataque("Rajada de Vento", 11, "AR", "Golpe rápido com vento cortante"));
        elementalAr.getAtaques().add(new Ataque("Tornado", 14, "AR", "Cria um tornado que atinge o inimigo"));
        elementalAr.getAtaques().add(new Ataque("Corte Aéreo", 10, "NORMAL", "Ataque físico com lâminas de ar"));
        elementalAr.getAtaques().add(new Ataque("Voo Rasante", 12, "AR", "Ataca o inimigo em alta velocidade"));


        BatalhaService batalha = new BatalhaService(dragao, golem);
        batalha.iniciarBatalha();
    }
}
