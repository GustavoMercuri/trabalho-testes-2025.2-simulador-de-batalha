package service;

import model.entidades.Criatura;

public class GerenciadorDeBatalha {
    private Criatura criaturaA;
    private Criatura criaturaB;
    private int turno;

    public GerenciadorDeBatalha(Criatura criaturaA, Criatura criaturaB) {
        this.criaturaA = criaturaA;
        this.criaturaB = criaturaB;
        this.turno = 1;
    }

    public void batalha(){
        while(criaturaA.estaViva() && criaturaB.estaViva()){
            
            turno++;
        }
    }
}
