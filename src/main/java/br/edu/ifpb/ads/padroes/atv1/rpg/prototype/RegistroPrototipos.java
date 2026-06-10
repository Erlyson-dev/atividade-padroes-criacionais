package br.edu.ifpb.ads.padroes.atv1.rpg.prototype;

import br.edu.ifpb.ads.padroes.atv1.rpg.model.Personagem;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype Registry — mantém instâncias pré-configuradas (protótipos)
 * de Personagem que podem ser clonadas rapidamente.
 *
 * Evita reconstruir do zero personagens cujos atributos base já foram
 * calculados — útil para criar variações de um personagem existente
 * sem custo de reinicialização completa.
 */
public class RegistroPrototipos {

    private final Map<String, Personagem> prototipos = new HashMap<>();

    /** Registra um protótipo sob uma chave identificadora. */
    public void registrar(String chave, Personagem personagem) {
        prototipos.put(chave, personagem);
    }

    /**
     * Clona o protótipo registrado sob a chave informada.
     *
     * @throws IllegalArgumentException se a chave não existir
     */
    public Personagem clonar(String chave) {
        Personagem proto = prototipos.get(chave);
        if (proto == null)
            throw new IllegalArgumentException("Protótipo não encontrado: " + chave);
        return proto.clone();
    }

    public boolean contem(String chave) {
        return prototipos.containsKey(chave);
    }
}
