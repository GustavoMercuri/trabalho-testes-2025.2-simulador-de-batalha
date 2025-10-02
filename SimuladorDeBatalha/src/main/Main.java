package main;

import model.entidades.Ataque;
import model.entidades.Criatura;
import model.equipamentos.ArmaduraDraconica;
import model.equipamentos.ElmodoSabio;
import model.interfaces.Equipamento;
import model.itens.Antidoto;
import model.itens.ElixirdeFogo;
import model.itens.ElixirdeGelo;
import model.itens.PocaoCura;
import model.itens.SuperPocao;
import service.BatalhaService;
import util.StatusEfeito;
import util.TipoElemental;


public class Main {
    public static void main(String[] args) {
        Criatura dragao = new Criatura("Dragão de Fogo", 80, 15, 8, 10, TipoElemental.FOGO);
        //aplicar equipamentos
        new ArmaduraDraconica().equipar(dragao);
        dragao.getAtaques().add(new Ataque("Bola de Fogo", 20, TipoElemental.FOGO, StatusEfeito.QUEIMADO, 0.3));
        dragao.getAtaques().add(new Ataque("Garra Dracônica", 10, TipoElemental.NORMAL));
        dragao.getAtaques().add(new Ataque("Explosão de Lava", 14, TipoElemental.FOGO, StatusEfeito.QUEIMADO, 0.4));
        dragao.getAtaques().add(new Ataque("Asas Cortantes", 9, TipoElemental.AR));
        
        dragao.adicionarItem(new PocaoCura(20));
        dragao.adicionarItem(new Antidoto());
        dragao.adicionarItem(new ElixirdeFogo());

        Criatura golem = new Criatura("Golem de Pedra", 100, 12, 15, 5, TipoElemental.TERRA);
        new ElmodoSabio().equipar(golem);
        golem.getAtaques().add(new Ataque("Soco de Pedra", 10, TipoElemental.TERRA));
        golem.getAtaques().add(new Ataque("Terremoto", 14, TipoElemental.TERRA));
        golem.getAtaques().add(new Ataque("Arremesso de Rocha", 11, TipoElemental.TERRA));
        golem.getAtaques().add(new Ataque("Esmagar", 13, TipoElemental.NORMAL));
        
        golem.adicionarItem(new SuperPocao(30));
        golem.adicionarItem(new ElixirdeGelo());
        golem.adicionarItem(new ElixirdeFogo());

        Criatura magoGelo = new Criatura("Mago de Gelo", 60, 14, 6, 12, TipoElemental.AGUA);

        magoGelo.getAtaques().add(new Ataque("Raio Congelante", 12, TipoElemental.GELO, StatusEfeito.CONGELADO, 0.25));
        magoGelo.getAtaques().add(new Ataque("Bloco de Gelo", 10, true));
        magoGelo.getAtaques().add(new Ataque("Bola de Água", 11, TipoElemental.AGUA));
        magoGelo.getAtaques().add(new Ataque("Punho Gélido", 9, TipoElemental.NORMAL));

        Criatura serpente = new Criatura("Serpente Venenosa", 70, 13, 7, 15, TipoElemental.TREVAS);

        serpente.getAtaques().add(new Ataque("Mordida Venenosa", 10, TipoElemental.TREVAS, StatusEfeito.ENVENENADO, 0.2));
        serpente.getAtaques().add(new Ataque("Ataque Sorrateiro", 12, TipoElemental.NORMAL));
        serpente.getAtaques().add(new Ataque("Sopro Tóxico", 11, TipoElemental.TREVAS, StatusEfeito.ENVENENADO, 0.3));
        serpente.getAtaques().add(new Ataque("Cobra Sombra", 13, TipoElemental.TREVAS));

        Criatura anjo = new Criatura("Anjo da Luz", 75, 14, 9, 14, TipoElemental.LUZ);

        anjo.getAtaques().add(new Ataque("Luz Divina", 12, TipoElemental.LUZ));
        anjo.getAtaques().add(new Ataque("Brilho Gentil", 15, true));
        anjo.getAtaques().add(new Ataque("Golpe Celestial", 11, TipoElemental.NORMAL));
        anjo.getAtaques().add(new Ataque("Luz Purificante", 10, TipoElemental.FOGO, StatusEfeito.QUEIMADO, 0.2));

        Criatura vampiro = new Criatura("Vampiro Sombrio", 65, 15, 8, 13, TipoElemental.TREVAS);

        vampiro.getAtaques().add(new Ataque("Mordida Vampírica", 12, TipoElemental.TREVAS));
        vampiro.getAtaques().add(new Ataque("Garras Sombrias", 11, TipoElemental.NORMAL));
        vampiro.getAtaques().add(new Ataque("Sopro Noturno", 10, TipoElemental.TREVAS, StatusEfeito.ENVENENADO, 0.25));
        vampiro.getAtaques().add(new Ataque("Explosão Sombria", 14, TipoElemental.TREVAS));

        Criatura elementalAr = new Criatura("Elemental do Ar", 70, 13, 7, 16, TipoElemental.AR);

        elementalAr.getAtaques().add(new Ataque("Rajada de Vento", 11, TipoElemental.AR));
        elementalAr.getAtaques().add(new Ataque("Tornado", 14, TipoElemental.AR));
        elementalAr.getAtaques().add(new Ataque("Corte Aéreo", 10, TipoElemental.NORMAL));
        elementalAr.getAtaques().add(new Ataque("Voo Rasante", 12, TipoElemental.AR));


        BatalhaService batalha = new BatalhaService(dragao, golem);
        batalha.iniciarBatalha();
    }
}
