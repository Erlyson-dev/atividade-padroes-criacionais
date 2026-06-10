package br.edu.ifpb.ads.padroes.atv1.rpg.model;

import java.util.Arrays;

/**
 * Representa um personagem do jogo RPG.
 * Construído via Builder; suporta clonagem via Prototype.
 */
public class Personagem implements Cloneable {

    private String nome;
    private String raca;
    private String classe;
    private int forca;
    private int inteligencia;
    private int agilidade;
    private int vida;
    private int mana;
    private Arma arma;
    private Armadura armadura;
    private String[] habilidades;

    // Construtor privado — uso exclusivo do Builder
    private Personagem() {}

    // ------------------------------------------------------------------ getters
    public String getNome()          { return nome; }
    public String getRaca()          { return raca; }
    public String getClasse()        { return classe; }
    public int getForca()            { return forca; }
    public int getInteligencia()     { return inteligencia; }
    public int getAgilidade()        { return agilidade; }
    public int getVida()             { return vida; }
    public int getMana()             { return mana; }
    public Arma getArma()            { return arma; }
    public Armadura getArmadura()    { return armadura; }
    public String[] getHabilidades() { return habilidades; }

    // ------------------------------------------------------------------ Prototype
    @Override
    public Personagem clone() {
        try {
            Personagem copia = (Personagem) super.clone();
            copia.arma      = this.arma.clone();
            copia.armadura  = this.armadura.clone();
            copia.habilidades = Arrays.copyOf(this.habilidades, this.habilidades.length);
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar Personagem", e);
        }
    }

    @Override
    public String toString() {
        return String.format(
            "%s - %s %s (F:%d, I:%d, A:%d, V:%d, M:%d) | Arma: %s | Armadura: %s | Habilidades: %s",
            nome, raca, classe, forca, inteligencia, agilidade, vida, mana,
            arma, armadura, Arrays.toString(habilidades));
    }

    // ================================================================== Builder
    public static class Builder {

        private final Personagem personagem = new Personagem();

        public Builder nome(String nome)                   { personagem.nome = nome;               return this; }
        public Builder raca(String raca)                   { personagem.raca = raca;               return this; }
        public Builder classe(String classe)               { personagem.classe = classe;           return this; }
        public Builder forca(int v)                        { personagem.forca = v;                 return this; }
        public Builder inteligencia(int v)                 { personagem.inteligencia = v;          return this; }
        public Builder agilidade(int v)                    { personagem.agilidade = v;             return this; }
        public Builder vida(int v)                         { personagem.vida = v;                  return this; }
        public Builder mana(int v)                         { personagem.mana = v;                  return this; }
        public Builder arma(Arma arma)                     { personagem.arma = arma;               return this; }
        public Builder armadura(Armadura armadura)         { personagem.armadura = armadura;       return this; }
        public Builder habilidades(String... habilidades)  { personagem.habilidades = habilidades; return this; }

        public Personagem build() {
            if (personagem.nome == null || personagem.raca == null || personagem.classe == null)
                throw new IllegalStateException("Nome, raça e classe são obrigatórios.");
            if (personagem.arma == null || personagem.armadura == null)
                throw new IllegalStateException("Arma e armadura são obrigatórias.");
            return personagem;
        }
    }
}
