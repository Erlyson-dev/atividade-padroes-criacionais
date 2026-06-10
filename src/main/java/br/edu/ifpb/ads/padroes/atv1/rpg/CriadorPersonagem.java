package br.edu.ifpb.ads.padroes.atv1.rpg;

import br.edu.ifpb.ads.padroes.atv1.rpg.abstractfactory.FabricaEquipamentos;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.FabricaEquipamentosFactory;
import br.edu.ifpb.ads.padroes.atv1.rpg.model.Personagem;
import br.edu.ifpb.ads.padroes.atv1.rpg.prototype.RegistroPrototipos;
import br.edu.ifpb.ads.padroes.atv1.rpg.singleton.ConfiguracaoJogo;

/**
 * Fachada principal do sistema de criação de personagens.
 *
 * Orquestra os padrões:
 *   - Factory Method  → seleciona a fábrica correta via FabricaEquipamentosFactory
 *   - Abstract Factory → FabricaEquipamentos cria arma/armadura/habilidades coesas
 *   - Builder         → Personagem.Builder monta o objeto passo a passo
 *   - Singleton       → consulta ConfiguracaoJogo para regras globais
 *   - Prototype       → clona protótipos registrados quando disponíveis
 */
public class CriadorPersonagem {

    private final RegistroPrototipos registro;

    public CriadorPersonagem() {
        this.registro = new RegistroPrototipos();
    }

    public CriadorPersonagem(RegistroPrototipos registro) {
        this.registro = registro;
    }

    // ------------------------------------------------------------------ API pública

    /**
     * Cria um novo Personagem.
     * Se existir um protótipo registrado para raça+classe, clona-o e ajusta o nome.
     * Caso contrário, constrói do zero usando Factory Method + Abstract Factory + Builder.
     */
    public Personagem criarPersonagem(String nome, String raca, String classe) {
        String chave = chavePrototipo(raca, classe);

        if (registro.contem(chave)) {
            // Prototype: clona e personaliza
            Personagem clone = registro.clonar(chave);
            // O Builder não é necessário aqui pois o clone já está completo;
            // ajustamos apenas o nome via setter público mínimo exposto pelo modelo.
            return ajustarNome(clone, nome);
        }

        return construirDoZero(nome, raca, classe);
    }

    /**
     * Registra um personagem já criado como protótipo reutilizável.
     */
    public void registrarPrototipo(String raca, String classe, Personagem personagem) {
        registro.registrar(chavePrototipo(raca, classe), personagem);
    }

    // ------------------------------------------------------------------ internos

    private Personagem construirDoZero(String nome, String raca, String classe) {
        // Factory Method → devolve a Abstract Factory correta
        FabricaEquipamentos fabrica = FabricaEquipamentosFactory.criar(raca, classe);

        // Abstract Factory → cria família de equipamentos coesa
        // Builder → monta o Personagem passo a passo
        return new Personagem.Builder()
                .nome(nome)
                .raca(raca)
                .classe(classe)
                .forca(atributoForca(raca, classe))
                .inteligencia(atributoInteligencia(raca, classe))
                .agilidade(atributoAgilidade(raca, classe))
                .vida(atributoVida(raca, classe))
                .mana(atributoMana(raca, classe))
                .arma(fabrica.criarArma())
                .armadura(fabrica.criarArmadura())
                .habilidades(fabrica.criarHabilidades())
                .build();
    }

    /** Clona e redefine o nome (Personagem.Builder aceita somente construção completa). */
    private Personagem ajustarNome(Personagem clone, String nome) {
        // Usa o Builder a partir do clone para garantir imutabilidade controlada
        return new Personagem.Builder()
                .nome(nome)
                .raca(clone.getRaca())
                .classe(clone.getClasse())
                .forca(clone.getForca())
                .inteligencia(clone.getInteligencia())
                .agilidade(clone.getAgilidade())
                .vida(clone.getVida())
                .mana(clone.getMana())
                .arma(clone.getArma().clone())
                .armadura(clone.getArmadura().clone())
                .habilidades(clone.getHabilidades().clone())
                .build();
    }

    private String chavePrototipo(String raca, String classe) {
        return raca.toLowerCase() + "_" + classe.toLowerCase();
    }

    // ------------------------------------------------------------------ atributos base
    // Singleton consultado: nível de dificuldade pode escalar os atributos no futuro.

    private int atributoForca(String raca, String classe) {
        int base = switch (raca.toLowerCase() + "_" + classe.toLowerCase()) {
            case "humano_guerreiro" -> 15;
            case "humano_mago"      -> 6;
            case "humano_arqueiro"  -> 10;
            case "elfo_guerreiro"   -> 12;
            case "elfo_mago"        -> 4;
            case "elfo_arqueiro"    -> 8;
            case "orc_guerreiro"    -> 20;
            case "orc_mago"         -> 10;
            case "orc_arqueiro"     -> 14;
            default -> throw new IllegalArgumentException("Raça/classe inválida");
        };
        return escalar(base);
    }

    private int atributoInteligencia(String raca, String classe) {
        int base = switch (raca.toLowerCase() + "_" + classe.toLowerCase()) {
            case "humano_guerreiro" -> 8;
            case "humano_mago"      -> 18;
            case "humano_arqueiro"  -> 12;
            case "elfo_guerreiro"   -> 14;
            case "elfo_mago"        -> 20;
            case "elfo_arqueiro"    -> 16;
            case "orc_guerreiro"    -> 6;
            case "orc_mago"         -> 14;
            case "orc_arqueiro"     -> 8;
            default -> throw new IllegalArgumentException("Raça/classe inválida");
        };
        return escalar(base);
    }

    private int atributoAgilidade(String raca, String classe) {
        int base = switch (raca.toLowerCase() + "_" + classe.toLowerCase()) {
            case "humano_guerreiro" -> 10;
            case "humano_mago"      -> 8;
            case "humano_arqueiro"  -> 16;
            case "elfo_guerreiro"   -> 16;
            case "elfo_mago"        -> 14;
            case "elfo_arqueiro"    -> 20;
            case "orc_guerreiro"    -> 8;
            case "orc_mago"         -> 6;
            case "orc_arqueiro"     -> 12;
            default -> throw new IllegalArgumentException("Raça/classe inválida");
        };
        return escalar(base);
    }

    private int atributoVida(String raca, String classe) {
        int base = switch (raca.toLowerCase() + "_" + classe.toLowerCase()) {
            case "humano_guerreiro" -> 120;
            case "humano_mago"      -> 80;
            case "humano_arqueiro"  -> 100;
            case "elfo_guerreiro"   -> 100;
            case "elfo_mago"        -> 70;
            case "elfo_arqueiro"    -> 90;
            case "orc_guerreiro"    -> 150;
            case "orc_mago"         -> 100;
            case "orc_arqueiro"     -> 120;
            default -> throw new IllegalArgumentException("Raça/classe inválida");
        };
        return escalar(base);
    }

    private int atributoMana(String raca, String classe) {
        int base = switch (raca.toLowerCase() + "_" + classe.toLowerCase()) {
            case "humano_guerreiro" -> 30;
            case "humano_mago"      -> 150;
            case "humano_arqueiro"  -> 70;
            case "elfo_guerreiro"   -> 60;
            case "elfo_mago"        -> 180;
            case "elfo_arqueiro"    -> 100;
            case "orc_guerreiro"    -> 20;
            case "orc_mago"         -> 120;
            case "orc_arqueiro"     -> 40;
            default -> throw new IllegalArgumentException("Raça/classe inválida");
        };
        return escalar(base);
    }

    /**
     * Aplica escalonamento baseado no nível de dificuldade (Singleton).
     * Nível 1 → sem modificador. Acima disso, inimigos ganham bônus.
     */
    private int escalar(int base) {
        int nivel = ConfiguracaoJogo.getInstance().getNivelDificuldade();
        return (nivel <= 1) ? base : (int) (base * (1 + (nivel - 1) * 0.1));
    }
}
