package model.equipamentos;

import model.entidades.Criatura;
import model.interfaces.Equipamento;

public class BotasdoVento implements Equipamento{
    private final String nome = "Botas do Vento";
    private final int bonusVida = 0;
    private final int bonusAtaque = 0;
    private final int bonusDefesa = 0;
    private final int bonusVelocidade = 10;

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
