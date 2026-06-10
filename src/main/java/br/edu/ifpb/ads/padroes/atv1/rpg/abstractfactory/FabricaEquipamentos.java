package br.edu.ifpb.ads.padroes.atv1.rpg.abstractfactory;

import br.edu.ifpb.ads.padroes.atv1.rpg.model.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.model.Armadura;

/**
 * Abstract Factory — define a interface para criação de famílias de
 * equipamentos (Arma + Armadura) coerentes entre si.
 *
 * Cada implementação concreta representa a combinação raça+classe,
 * garantindo que arma e armadura sempre sejam compatíveis.
 */
public interface FabricaEquipamentos {
    Arma criarArma();
    Armadura criarArmadura();
    String[] criarHabilidades();
}
