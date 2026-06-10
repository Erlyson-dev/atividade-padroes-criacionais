package br.edu.ifpb.ads.padroes.atv1.rpg.factory;

import br.edu.ifpb.ads.padroes.atv1.rpg.abstractfactory.FabricaEquipamentos;
import br.edu.ifpb.ads.padroes.atv1.rpg.abstractfactory.FabricasConcretas;

/**
 * Factory Method — centraliza a decisão de qual FabricaEquipamentos
 * (Abstract Factory) instanciar com base na combinação raça+classe.
 *
 * Isola o código cliente do conhecimento das fábricas concretas,
 * respeitando o OCP: novas raças/classes exigem apenas nova fábrica
 * concreta + uma entrada neste mapa.
 */
public class FabricaEquipamentosFactory {

    private FabricaEquipamentosFactory() {}   // utilitária — sem instância

    /**
     * Retorna a fábrica adequada à combinação raça+classe.
     *
     * @throws IllegalArgumentException para combinações não suportadas
     */
    public static FabricaEquipamentos criar(String raca, String classe) {
        String chave = raca.toLowerCase() + "_" + classe.toLowerCase();
        return switch (chave) {
            case "humano_guerreiro"  -> new FabricasConcretas.HumanoGuerreiroFabrica();
            case "humano_mago"       -> new FabricasConcretas.HumanoMagoFabrica();
            case "humano_arqueiro"   -> new FabricasConcretas.HumanoArqueiroFabrica();
            case "elfo_guerreiro"    -> new FabricasConcretas.ElfoGuerreiroFabrica();
            case "elfo_mago"         -> new FabricasConcretas.ElfoMagoFabrica();
            case "elfo_arqueiro"     -> new FabricasConcretas.ElfoArqueiroFabrica();
            case "orc_guerreiro"     -> new FabricasConcretas.OrcGuerreiroFabrica();
            case "orc_mago"          -> new FabricasConcretas.OrcMagoFabrica();
            case "orc_arqueiro"      -> new FabricasConcretas.OrcArqueiroFabrica();
            default -> throw new IllegalArgumentException(
                "Combinação não suportada: " + raca + " + " + classe);
        };
    }
}
