package model.itens;

import model.entidades.Criatura;
import model.interfaces.Item;
import util.StatusEfeito;

public class ElixirdeGelo implements Item{

    @Override
    public void aplicar(Criatura criatura) {
        if (criatura.getStatus() == StatusEfeito.CONGELADO) {
            criatura.setStatus(StatusEfeito.NORMAL);
            System.out.println(criatura.getNome() + " foi curado do congelamento.");
        } else {
            System.out.println(criatura.getNome() + " não está congelado.");
        }
    }
}
