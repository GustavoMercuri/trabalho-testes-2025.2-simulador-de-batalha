package model.entidades;

import util.StatusEfeito;
import util.TipoElemental;

import java.util.Random;

public class Ataque {
    private String nome;
    private int poder;
    private TipoElemental tipo;
    private StatusEfeito efeitoStatus;
    private double chanceEfeito;
    private boolean cura;

    public Ataque(String nome, int poder, TipoElemental tipo) {
        this(nome, poder, tipo, StatusEfeito.NORMAL, 0.0, false);
    }

    public Ataque(String nome, int poder, TipoElemental tipo, StatusEfeito efeitoStatus, double chanceEfeito) {
        this(nome, poder, tipo, efeitoStatus, chanceEfeito, false);
    }

    public Ataque(String nome, int poder, boolean cura) {
        this(nome, poder, TipoElemental.NORMAL, StatusEfeito.NORMAL, 0.0, cura);
    }

    public Ataque(String nome, int poder, TipoElemental tipo, StatusEfeito efeitoStatus, double chanceEfeito, boolean cura) {
        this.nome = nome;
        this.poder = poder;
        this.tipo = tipo;
        this.efeitoStatus = efeitoStatus;
        this.chanceEfeito = chanceEfeito;
        this.cura = cura;
    }


    public boolean aplicaEfeito() {
        if (efeitoStatus == StatusEfeito.NORMAL) return false;
        Random random = new Random();
        return random.nextDouble() <= chanceEfeito;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getPoder() { return poder; }
    public void setPoder(int poder) { this.poder = poder; }

    public StatusEfeito getEfeitoStatus() { return efeitoStatus; }
    public void setEfeitoStatus(StatusEfeito efeitoStatus) { this.efeitoStatus = efeitoStatus; }

    public double getChanceEfeito() { return chanceEfeito; }
    public void setChanceEfeito(double chanceEfeito) { this.chanceEfeito = chanceEfeito; }

    public boolean isCura() { return cura; }
    public void setCura(boolean cura) { this.cura = cura; }

	public TipoElemental getTipo() {
		return tipo;
	}

	public void setTipo(TipoElemental tipo) {
		this.tipo = tipo;
	}

	
}
