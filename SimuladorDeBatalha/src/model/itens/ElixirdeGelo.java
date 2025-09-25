package model.itens;

import model.entidades.Criatura;
import model.interfaces.Item;

public class ElixirdeGelo implements Item{

    @Override
    public void aplicar(Criatura criatura) {
        if (criatura.getStatus().equals(Criatura.STATUS_CONGELADO)) {
            criatura.aplicarStatus(Criatura.STATUS_NORMAL);
            System.out.println(criatura.getNome() + " foi curado do congelamento.");
        } else {
            System.out.println(criatura.getNome() + " não está congelado.");
        }
    }
}
