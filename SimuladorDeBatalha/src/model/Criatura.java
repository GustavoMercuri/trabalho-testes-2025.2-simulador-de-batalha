package model;

public class Criatura {
	private String nome;
	private int vida;
	private int vidaMax;
	private int ataque;
	private int defesa;
	private int velocidade;
	private String tipo;
	private String status;

	public Criatura(String nome, int vida, int ataque, int defesa, int velocidade, String tipo) {
		this.nome = nome;
		this.vida = vida;
		this.vidaMax = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.tipo = tipo;
		this.status = "normal";
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
