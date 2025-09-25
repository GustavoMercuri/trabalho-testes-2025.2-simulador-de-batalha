package model.itens;

import model.entidades.Criatura;
import model.interfaces.Item;

public class PocaoCura implements Item {
    private int valorCura;

    public PocaoCura(int valorCura) {
        this.valorCura = valorCura;
    }

    @Override
    public void aplicar(Criatura criatura) {
        criatura.curar(valorCura);
        System.out.println(criatura.getNome() + " foi curado em " + valorCura + " pontos de vida.");
    }
}
