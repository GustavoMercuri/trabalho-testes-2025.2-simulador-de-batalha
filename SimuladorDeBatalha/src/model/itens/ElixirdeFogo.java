package model.itens;

import model.entidades.Criatura;
import model.interfaces.Item;

public class ElixirdeFogo implements Item{

    @Override
    public void aplicar(Criatura criatura) {
        if (criatura.getStatus().equals(Criatura.STATUS_QUEIMADO)) {
            criatura.aplicarStatus(Criatura.STATUS_NORMAL);
            System.out.println(criatura.getNome() + " foi curado da queimadura.");
        } else {
            System.out.println(criatura.getNome() + " não está queimado.");
        }
    }
}
