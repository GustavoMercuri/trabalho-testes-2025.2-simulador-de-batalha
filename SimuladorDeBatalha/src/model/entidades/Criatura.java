package model.entidades;

import util.StatusEfeito;
import util.TipoElemental;

import java.util.ArrayList;
import java.util.List;

public class Criatura {

	private String nome;
	private int vida;
	private int vidaMax;
	private int ataque;
	private int defesa;
	private int velocidade;
	private TipoElemental tipo;
	private StatusEfeito status;
    private int duracaoStatus;
    private List<Ataque> ataques;

	public Criatura(String nome, int vida, int ataque, int defesa, int velocidade, TipoElemental tipo) {
		this.nome = nome;
		this.vida = vida;
		this.vidaMax = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.tipo = tipo;
        this.status = StatusEfeito.NORMAL;
        this.ataques = new ArrayList<>();
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

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }

    public void aplicarStatus(StatusEfeito status, int duracao) {
        this.status = status;
        this.duracaoStatus = duracao;
    }

    public void reduzirDuracaoStatus() {
        if (this.status != StatusEfeito.NORMAL) {
            this.duracaoStatus--;
            if (this.duracaoStatus <= 0) {
                this.status = StatusEfeito.NORMAL;
                duracaoStatus = 0;
            }
        }
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

    public StatusEfeito getStatus() {
        return status;
    }

    public void setStatus(StatusEfeito status) {
        this.status = status;
    }

    public TipoElemental getTipo() {
        return tipo;
    }

    public void setTipo(TipoElemental tipo) {
        this.tipo = tipo;
    }
}
