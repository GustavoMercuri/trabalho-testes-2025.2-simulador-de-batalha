package model.itens;

import model.entidades.Criatura;
import model.interfaces.Item;
import model.entidades.StatusEfeito;

public class Antidoto implements Item {

    @Override
    public void aplicar(Criatura criatura) {
        if (criatura.getStatus() == StatusEfeito.ENVENENADO) {
            criatura.setStatus(StatusEfeito.NORMAL);
            System.out.println(criatura.getNome() + " foi curado do envenenamento.");
        } else {
            System.out.println(criatura.getNome() + " não está envenenado.");
        }
    }
}
