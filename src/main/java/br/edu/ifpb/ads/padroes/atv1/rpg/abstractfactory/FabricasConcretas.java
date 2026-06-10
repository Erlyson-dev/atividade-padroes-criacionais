package br.edu.ifpb.ads.padroes.atv1.rpg.abstractfactory;

import br.edu.ifpb.ads.padroes.atv1.rpg.model.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.model.Armadura;

/**
 * Agrupa todas as implementações concretas de FabricaEquipamentos
 * como classes estáticas públicas aninhadas.
 */
public final class FabricasConcretas {

    private FabricasConcretas() {}

    // HUMANO
    public static class HumanoGuerreiroFabrica implements FabricaEquipamentos {
        @Override public Arma criarArma()           { return new Arma("Espada de Ferro", 25, "Espada"); }
        @Override public Armadura criarArmadura()   { return new Armadura("Armadura de Placas", 20, "Pesada"); }
        @Override public String[] criarHabilidades(){ return new String[]{"Investida", "Bloqueio"}; }
    }

    public static class HumanoMagoFabrica implements FabricaEquipamentos {
        @Override public Arma criarArma()           { return new Arma("Cajado Mágico", 15, "Cajado"); }
        @Override public Armadura criarArmadura()   { return new Armadura("Vestes Mágicas", 8, "Leve"); }
        @Override public String[] criarHabilidades(){ return new String[]{"Bola de Fogo", "Cura"}; }
    }

    public static class HumanoArqueiroFabrica implements FabricaEquipamentos {
        @Override public Arma criarArma()           { return new Arma("Arco Élfico", 20, "Arco"); }
        @Override public Armadura criarArmadura()   { return new Armadura("Armadura de Couro", 12, "Média"); }
        @Override public String[] criarHabilidades(){ return new String[]{"Tiro Certeiro", "Chuva de Flechas"}; }
    }

    // ELFO
    public static class ElfoGuerreiroFabrica implements FabricaEquipamentos {
        @Override public Arma criarArma()           { return new Arma("Lâmina Élfica", 22, "Espada"); }
        @Override public Armadura criarArmadura()   { return new Armadura("Cota de Malha Élfica", 15, "Média"); }
        @Override public String[] criarHabilidades(){ return new String[]{"Dança das Lâminas", "Agilidade Élfica"}; }
    }

    public static class ElfoMagoFabrica implements FabricaEquipamentos {
        @Override public Arma criarArma()           { return new Arma("Cajado da Natureza", 18, "Cajado"); }
        @Override public Armadura criarArmadura()   { return new Armadura("Mantos Élficos", 10, "Leve"); }
        @Override public String[] criarHabilidades(){ return new String[]{"Magia da Natureza", "Teleporte"}; }
    }

    public static class ElfoArqueiroFabrica implements FabricaEquipamentos {
        @Override public Arma criarArma()           { return new Arma("Arco Longo Élfico", 28, "Arco"); }
        @Override public Armadura criarArmadura()   { return new Armadura("Armadura de Couro Élfico", 14, "Média"); }
        @Override public String[] criarHabilidades(){ return new String[]{"Tiro Múltiplo", "Camuflagem"}; }
    }

    // ORC
    public static class OrcGuerreiroFabrica implements FabricaEquipamentos {
        @Override public Arma criarArma()           { return new Arma("Machado de Guerra", 30, "Machado"); }
        @Override public Armadura criarArmadura()   { return new Armadura("Armadura Brutal", 25, "Pesada"); }
        @Override public String[] criarHabilidades(){ return new String[]{"Fúria", "Pancada Devastadora"}; }
    }

    public static class OrcMagoFabrica implements FabricaEquipamentos {
        @Override public Arma criarArma()           { return new Arma("Cajado Tribal", 12, "Cajado"); }
        @Override public Armadura criarArmadura()   { return new Armadura("Vestes Xamânicas", 6, "Leve"); }
        @Override public String[] criarHabilidades(){ return new String[]{"Magia Sombria", "Invocação"}; }
    }

    public static class OrcArqueiroFabrica implements FabricaEquipamentos {
        @Override public Arma criarArma()           { return new Arma("Arco de Osso", 24, "Arco"); }
        @Override public Armadura criarArmadura()   { return new Armadura("Couro de Besta", 16, "Média"); }
        @Override public String[] criarHabilidades(){ return new String[]{"Tiro Brutal", "Intimidação"}; }
    }
}
