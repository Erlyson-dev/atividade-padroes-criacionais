package br.edu.ifpb.ads.padroes.atv1.rpg.model;

/**
 * Representa uma armadura equipável por um personagem.
 * Implementa Cloneable para suporte ao padrão Prototype.
 */
public class Armadura implements Cloneable {

    private String nome;
    private int defesa;
    private String tipo;

    public Armadura(String nome, int defesa, String tipo) {
        this.nome = nome;
        this.defesa = defesa;
        this.tipo = tipo;
    }

    public String getNome()   { return nome; }
    public int getDefesa()    { return defesa; }
    public String getTipo()   { return tipo; }

    @Override
    public Armadura clone() {
        try {
            return (Armadura) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar Armadura", e);
        }
    }

    @Override
    public String toString() {
        return nome + " (defesa: " + defesa + ", tipo: " + tipo + ")";
    }
}
