package model.equipamentos;

import model.entidades.Criatura;
import model.interfaces.Equipamento;

public class ArmaduraDraconica implements Equipamento{
    private final String nome = "Armadura Dracônica";
    private final int bonusVida = 20;
    private final int bonusAtaque = 0;
    private final int bonusDefesa = 10;
    private final int bonusVelocidade = 0;

    @Override
    public void equipar(Criatura criatura) {
        criatura.setVidaMax(criatura.getVidaMax() + bonusVida);
        criatura.setVida(criatura.getVida() + bonusVida);
        criatura.setAtaque(criatura.getAtaque() + bonusAtaque);
        criatura.setDefesa(criatura.getDefesa() + bonusDefesa);
        criatura.setVelocidade(criatura.getVelocidade() + bonusVelocidade);
    }

    @Override
    public void desequipar(Criatura criatura) {
        criatura.setVidaMax(criatura.getVidaMax() - bonusVida);
        if (criatura.getVida() > criatura.getVidaMax()) {
            criatura.setVida(criatura.getVidaMax());
        }
        criatura.setAtaque(criatura.getAtaque() - bonusAtaque);
        criatura.setDefesa(criatura.getDefesa() - bonusDefesa);
        criatura.setVelocidade(criatura.getVelocidade() - bonusVelocidade);
    }

    @Override
    public String getNome() {
        return nome;
    }
}

