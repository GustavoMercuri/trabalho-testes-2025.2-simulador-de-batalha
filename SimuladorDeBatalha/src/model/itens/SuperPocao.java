package model.itens;

import model.entidades.Criatura;
import model.interfaces.Item;

public class SuperPocao implements Item{
    private int valorCura;

    public SuperPocao(int valorCura) {
        this.valorCura = valorCura;
    }

    @Override
    public void aplicar(Criatura criatura) {
        criatura.curar(valorCura * 2);
        System.out.println(criatura.getNome() + " foi curado em " + (valorCura * 2) + " pontos de vida.");
    }

    @Override
    public String getNome() {
        return "Super Poção";
    }
}
