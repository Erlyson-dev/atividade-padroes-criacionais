package br.edu.ifpb.ads.padroes.atv1.rpg.model;

/**
 * Representa uma arma equipável por um personagem.
 * Implementa Cloneable para suporte ao padrão Prototype.
 */
public class Arma implements Cloneable {

    private String nome;
    private int dano;
    private String tipo;

    public Arma(String nome, int dano, String tipo) {
        this.nome = nome;
        this.dano = dano;
        this.tipo = tipo;
    }

    public String getNome()  { return nome; }
    public int getDano()     { return dano; }
    public String getTipo()  { return tipo; }

    @Override
    public Arma clone() {
        try {
            return (Arma) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar Arma", e);
        }
    }

    @Override
    public String toString() {
        return nome + " (dano: " + dano + ", tipo: " + tipo + ")";
    }
}
