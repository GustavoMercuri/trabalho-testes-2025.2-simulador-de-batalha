package model.interfaces;

import model.entidades.Criatura;

public interface Item {
    void aplicar(Criatura criatura);
    String getNome();
}
