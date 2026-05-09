// ## Exercício 3 — Sealed com modificadores

// Crie a hierarquia de campanhas:

// ```java
// sealed class Campanha permits CampanhaDigital, CampanhaTradicional { }

// // sealed — controla quem estende
// sealed class CampanhaDigital extends Campanha
//     permits CampanhaMetaAds, CampanhaGoogleAds { }

// // non-sealed — abre a hierarquia
// non-sealed class CampanhaTradicional extends Campanha { }

// final class CampanhaMetaAds extends CampanhaDigital { }
// final class CampanhaGoogleAds extends CampanhaDigital { }
// ```

// 1. Adicione atributos relevantes em cada classe
// 2. Crie uma subclasse de `CampanhaTradicional` — mostre que funciona pois é `non-sealed`
// 3. Tente criar subclasse de `CampanhaMetaAds` — mostre o erro com comentário
// 4. Use switch com pattern matching para calcular ROI mínimo esperado por tipo

public class Exercicio03 {
    public static void main(String[] args) {
        Campanha c1 = new CampanhaMetaAds("Meta Ads", 1000, 200);
        Campanha c2 = new CampanhaGoogleAds("Google Ads", 1500, 300);
        Campanha c3 = new CampanhaTV("TV Comercial", 5000, 1000);

        System.out.println(calcularRoi(c1));
        System.out.println(calcularRoi(c2));
        System.out.println(calcularRoi(c3));
    }

    public static String calcularRoi(Campanha campanha) {
        return switch (campanha) {
            case CampanhaMetaAds meta -> "ROI Meta Ads: " + (meta.getInvestimento() / meta.getConversoes());
            case CampanhaGoogleAds google -> "ROI Google Ads: " + (google.getInvestimento() / google.getConversoes());
            case CampanhaTV tv -> "ROI TV Comercial: " + (tv.getInvestimento() / tv.getConversoes());
            default -> throw new IllegalStateException("Tipo de campanha desconhecido: " + campanha.getClass().getName());
        };
    }
}

sealed class Campanha permits CampanhaDigital, CampanhaTradicional { 
    private final String nome;
    private final double investimento;

    public Campanha(String nome, double investimento) {
        this.nome = nome;
        this.investimento = investimento;
    }

    public String getNome() { return nome; }
    public double getInvestimento() { return investimento; }
}

sealed class CampanhaDigital extends Campanha permits CampanhaMetaAds, CampanhaGoogleAds {
    private final int conversoes;

    public CampanhaDigital(String nome, double investimento, int conversoes) {
        super(nome, investimento);
        this.conversoes = conversoes;
    }

    public int getConversoes() { return conversoes; }
}

non-sealed class CampanhaTradicional extends Campanha {
    public CampanhaTradicional(String nome, double investimento) {
        super(nome, investimento);
    }
}

final class CampanhaMetaAds extends CampanhaDigital {
    public CampanhaMetaAds(String nome, double investimento, int conversoes) {
        super(nome, investimento, conversoes);
    }
}

final class CampanhaGoogleAds extends CampanhaDigital {
    public CampanhaGoogleAds(String nome, double investimento, int conversoes) {
        super(nome, investimento, conversoes);
    }
}

class CampanhaTV extends CampanhaTradicional {
    private final int conversoes;

    public CampanhaTV(String nome, double investimento, int conversoes) {
        super(nome, investimento);
        this.conversoes = conversoes;
    }

    public int getConversoes() { return conversoes; }
}

// Tentativa de criar subclasse de CampanhaMetaAds:
/*
class NovaCampanhaMeta extends CampanhaMetaAds {
    // ERRO: 'CampanhaMetaAds' is final and cannot be extended.
}
*/