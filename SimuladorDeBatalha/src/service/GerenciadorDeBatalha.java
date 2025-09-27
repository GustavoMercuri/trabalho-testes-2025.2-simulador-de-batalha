package service;

import model.entidades.Criatura;

public class GerenciadorDeBatalha {
    private Criatura criatura1;
    private Criatura criatura2;
    private int contTurnos;

    public GerenciadorDeBatalha(Criatura criatura1, Criatura criatura2) {
        this.criatura1 = criatura1;
        this.criatura2 = criatura2;
        this.contTurnos = 1;
    }

    public void batalha(){
        int turno = (criatura1.getVelocidade() > criatura2.getVelocidade()) ? 0 : 1;

        while(criatura1.estaViva() && criatura2.estaViva()){
            if (turno == 0){
                //Ataque da criatura1
            } else {
                //Ataque da criatura2
            }
            contTurnos++;
        }
        if (criatura1.estaViva() && !criatura2.estaViva()){
            System.out.println("Vencedor:" + criatura1.getNome());
        } else{
            System.out.println("Vencedor:" + criatura2.getNome());
        }
    }
}
