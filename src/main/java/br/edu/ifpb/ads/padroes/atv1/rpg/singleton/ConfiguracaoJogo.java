package br.edu.ifpb.ads.padroes.atv1.rpg.singleton;

/**
 * Singleton — garante que exista apenas uma instância de ConfiguracaoJogo
 * em toda a aplicação (thread-safe via inicialização sob demanda).
 *
 * Centraliza configurações globais do jogo, como nível de dificuldade,
 * sem expor estado mutável via variáveis estáticas avulsas.
 */
public class ConfiguracaoJogo {

    private int nivelDificuldade;
    private int maxPersonagensPorPartida;
    private boolean modoDebug;

    // Inicialização sob demanda (lazy + thread-safe sem synchronized)
    private static class Holder {
        private static final ConfiguracaoJogo INSTANCE = new ConfiguracaoJogo();
    }

    private ConfiguracaoJogo() {
        this.nivelDificuldade        = 1;
        this.maxPersonagensPorPartida = 4;
        this.modoDebug               = false;
    }

    public static ConfiguracaoJogo getInstance() {
        return Holder.INSTANCE;
    }

    // ------------------------------------------------------------------ getters/setters
    public int getNivelDificuldade()                  { return nivelDificuldade; }
    public void setNivelDificuldade(int nivel)        { this.nivelDificuldade = nivel; }

    public int getMaxPersonagensPorPartida()          { return maxPersonagensPorPartida; }
    public void setMaxPersonagensPorPartida(int max)  { this.maxPersonagensPorPartida = max; }

    public boolean isModoDebug()                      { return modoDebug; }
    public void setModoDebug(boolean modoDebug)       { this.modoDebug = modoDebug; }

    @Override
    public String toString() {
        return "ConfiguracaoJogo{nivelDificuldade=" + nivelDificuldade
               + ", maxPersonagens=" + maxPersonagensPorPartida
               + ", debug=" + modoDebug + "}";
    }
}
