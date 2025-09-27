package model.entidades;

import java.util.ArrayList;
import java.util.List;

import util.StatusEfeito;

public class Criatura {

	private String nome;
	private int vida;
	private int vidaMax;
	private int ataque;
	private int defesa;
	private int velocidade;
	private String tipo;
	private StatusEfeito status;
    private List<Ataque> ataqueList;

	public Criatura(String nome, int vida, int ataque, int defesa, int velocidade, String tipo) {
		this.nome = nome;
		this.vida = vida;
		this.vidaMax = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.tipo = tipo;
        this.status = StatusEfeito.NORMAL;
        this.ataqueList = new ArrayList<>();
	}

    public void receberDano(int dano){
    	this.vida = Math.max(0, this.vida - dano);
    }

    public void curar(int valor){
        this.vida += valor;
        if(this.vida > this.vidaMax) {
            this.vida = this.vidaMax;
        }
    }

    public boolean estaViva() {
        return this.vida > 0;
    }

    public List<Ataque> getAtaqueList() {
        return ataqueList;
    }

    public void setAtaqueList(List<Ataque> ataqueList) {
        this.ataqueList = ataqueList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public StatusEfeito getStatus() {
        return status;
    }

    public void setStatus(StatusEfeito status) {
        this.status = status;
    }

}
