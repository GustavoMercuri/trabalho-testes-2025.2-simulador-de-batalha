package model.entidades;

public class Ataque {
    private String nome;
    private int poder;
    private TipoElemental tipo;
    private StatusEfeito efeito;

    public Ataque(String nome, int poder, TipoElemental tipo, StatusEfeito efeito) {
        this.nome = nome;
        this.poder = poder;
        this.tipo = tipo;
        this.efeito = efeito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public TipoElemental getTipo() {
        return tipo;
    }

    public void setTipo(TipoElemental tipo) {
        this.tipo = tipo;
    }

    public StatusEfeito getEfeito() {
        return efeito;
    }

    public void setEfeito(StatusEfeito efeito) {
        this.efeito = efeito;
    }
}
