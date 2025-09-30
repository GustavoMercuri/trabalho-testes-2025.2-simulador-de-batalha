package model.itens;

import model.entidades.Criatura;
import model.interfaces.Item;
import util.StatusEfeito;

public class ElixirdeFogo implements Item{

    @Override
    public void aplicar(Criatura criatura) {
        if (criatura.getStatus() == StatusEfeito.QUEIMADO) {
            criatura.setStatus(StatusEfeito.NORMAL);
            System.out.println(criatura.getNome() + " foi curado da queimadura.");
        } else {
            System.out.println(criatura.getNome() + " não está queimado.");
        }
    }
}
