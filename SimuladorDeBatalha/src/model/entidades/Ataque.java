package model.entidades;

public class Ataque {
    private String nome;
    private int poder;
    private String tipo;
    private String efeito;

    public Ataque(String nome, int poder, String tipo, String efeito) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }
}
