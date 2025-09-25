package model.interfaces;

import model.entidades.Criatura;

public interface Equipamento {
    void equipar(Criatura criatura);
    void desequipar(Criatura criatura);
    String getNome();
}
