package br.edu.ifpb.ads.padroes.atv1.rpg;

import br.edu.ifpb.ads.padroes.atv1.rpg.model.Personagem;
import br.edu.ifpb.ads.padroes.atv1.rpg.singleton.ConfiguracaoJogo;

/**
 * Demonstração do sistema refatorado.
 */
public class Main {

    public static void main(String[] args) {

        // ── Singleton ──────────────────────────────────────────────────────────
        ConfiguracaoJogo config = ConfiguracaoJogo.getInstance();
        System.out.println("Configuração: " + config);

        CriadorPersonagem criador = new CriadorPersonagem();

        // ── Factory Method + Abstract Factory + Builder ────────────────────────
        System.out.println("\n=== Personagens criados do zero ===");

        Personagem guerreiro = criador.criarPersonagem("Arthur", "Humano", "Guerreiro");
        System.out.println(guerreiro);

        Personagem mago = criador.criarPersonagem("Gandalf", "Elfo", "Mago");
        System.out.println(mago);

        Personagem orc = criador.criarPersonagem("Grommash", "Orc", "Guerreiro");
        System.out.println(orc);

        // ── Prototype ──────────────────────────────────────────────────────────
        System.out.println("\n=== Prototype: registrar e clonar ===");

        // Registra Arthur como protótipo de Humano Guerreiro
        criador.registrarPrototipo("Humano", "Guerreiro", guerreiro);

        // Clona — muito mais rápido que construir do zero
        Personagem arthur2 = criador.criarPersonagem("Arthur II", "Humano", "Guerreiro");
        System.out.println("Clone: " + arthur2);
        System.out.println("São objetos distintos? " + (guerreiro != arthur2));

        // ── Singleton: escalonamento por dificuldade ───────────────────────────
        System.out.println("\n=== Dificuldade aumentada (nível 3) ===");
        config.setNivelDificuldade(3);

        // Limpa protótipo para forçar reconstrução com novo escalonamento
        CriadorPersonagem criadorDificil = new CriadorPersonagem();
        Personagem orcDificil = criadorDificil.criarPersonagem("Grommash Elite", "Orc", "Guerreiro");
        System.out.println(orcDificil);
    }
}
