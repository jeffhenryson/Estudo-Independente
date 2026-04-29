// ## Exercício 6 — Desafio

// Monte o sistema de campanhas do **Cerne** completo:

// **Interfaces:**

// ```java
// interface Relatoravel {
//     String gerarRelatorio();
// }

// interface Otimizavel {
//     void otimizar();
//     double calcularRoi();
// }
// ```

// **Classe abstrata `Campanha`**

// - Atributos `protected`: `nome`, `orcamento`, `receita`
// - Construtor
// - Método abstrato: `String getTipo()`
// - Método concreto: `calcularRoi()` → `((receita - orcamento) / orcamento) * 100`
// - Método concreto: `exibir()` → imprime nome, tipo, orçamento, receita e ROI

// **`CampanhaMetaAds`** extends `Campanha` implements `Relatoravel`, `Otimizavel`

// - Atributo extra: `publicoAlvo`
// - `getTipo()` → `"Meta Ads"`
// - `gerarRelatorio()` → relatório formatado com todos os dados
// - `otimizar()` → imprime sugestões baseadas no ROI:
//     - ROI < 0 → `"Pausar campanha e revisar público"`
//     - ROI 0-50 → `"Ajustar criativos e segmentação"`
//     - ROI > 50 → `"Escalar orçamento"`

// **`CampanhaGoogleAds`** extends `Campanha` implements `Relatoravel`, `Otimizavel`

// - Atributo extra: `palavrasChave` (String[])
// - `getTipo()` → `"Google Ads"`
// - `gerarRelatorio()` → inclui as palavras-chave no relatório
// - `otimizar()` → mesma lógica de ROI mas com mensagens específicas para Google

// **`Main`**:

// 1. Crie 2 campanhas Meta e 2 Google com ROIs variados
// 2. Coloque em array `Campanha[]` e chame `exibir()` em todas
// 3. Coloque as que implementam `Relatoravel` em outro array e gere relatórios
// 4. Chame `otimizar()` nas que implementam `Otimizavel`
// 5. Imprima a campanha com maior ROI

public class Exercicio06 {
    public static void main(String[] args) {
        
        Campanha[] campanhas = new Campanha[4];
        campanhas[0] = new CampanhaMetaAds("Campanha Meta 1", 1000, 1500, "Jovens adultos");
        campanhas[1] = new CampanhaMetaAds("Campanha Meta 2", 2000, 1800, "Profissionais");
        campanhas[2] = new CampanhaGoogleAds("Campanha Google 1", 1500, 3000, new String[]{"marketing digital", "publicidade"});
        campanhas[3] = new CampanhaGoogleAds("Campanha Google 2", 2500, 2000, new String[]{"SEO", "anúncios online"});

        System.out.println("Exibindo campanhas:");
        for (Campanha c : campanhas) {
            c.exibir();
            System.out.println();
        }

        System.out.println("Gerando relatórios:");
        for (Campanha c : campanhas) {
            if (c instanceof Relatoravel) {
                System.out.println(((Relatoravel) c).gerarRelatorio());
                System.out.println();
            }
        }

        System.out.println("Otimizações:");
        for (Campanha c : campanhas) {
            if (c instanceof Otimizavel) {
                ((Otimizavel) c).otimizar();
                System.out.println();
            }
        }

        Campanha melhorCampanha = null;
        double maiorRoi = Double.NEGATIVE_INFINITY;
        for (Campanha c : campanhas) {
            double roi = c.calcularRoi();
            if (roi > maiorRoi) {
                maiorRoi = roi;
                melhorCampanha = c;
            }
        }

        System.out.println("Campanha com maior ROI:");
        if (melhorCampanha != null) {
            melhorCampanha.exibir();
        }
    }
}

interface Relatoravel {
    String gerarRelatorio();
}

interface Otimizavel {
    void otimizar();
    double calcularRoi();
}

abstract class Campanha {

    protected String nome;
    protected double orcamento;
    protected double receita;

    public Campanha(String nome, double orcamento, double receita) {
        this.nome = nome;
        this.orcamento = orcamento;
        this.receita = receita;
    }

    public abstract String getTipo();

    public double calcularRoi() {
        return ((receita - orcamento) / orcamento) * 100;
    }

    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + getTipo());
        System.out.println("Orçamento: " + orcamento);
        System.out.println("Receita: " + receita);
        System.out.printf("ROI: %.2f%%\n", calcularRoi());
    }
}

class CampanhaMetaAds extends Campanha implements Relatoravel, Otimizavel {

    private String publicoAlvo;

    public CampanhaMetaAds(String nome, double orcamento, double receita, String publicoAlvo) {
        super(nome, orcamento, receita);
        this.publicoAlvo = publicoAlvo;
    }

    @Override
    public String getTipo() {
        return "Meta Ads";
    }

    @Override
    public String gerarRelatorio() {
        return String.format("Relatório Meta Ads - Nome: %s, Público Alvo: %s, Orçamento: %.2f, Receita: %.2f, ROI: %.2f%%",
                nome, publicoAlvo, orcamento, receita, calcularRoi());
    }

    @Override
    public void otimizar() {
        double roi = calcularRoi();
        if (roi < 0) {
            System.out.println("Pausar campanha e revisar público");
        } else if (roi <= 50) {
            System.out.println("Ajustar criativos e segmentação");
        } else {
            System.out.println("Escalar orçamento");
        }
    }
}

class CampanhaGoogleAds extends Campanha implements Relatoravel, Otimizavel {

    private String[] palavrasChave;

    public CampanhaGoogleAds(String nome, double orcamento, double receita, String[] palavrasChave) {
        super(nome, orcamento, receita);
        this.palavrasChave = palavrasChave;
    }

    @Override
    public String getTipo() {
        return "Google Ads";
    }

    @Override
    public String gerarRelatorio() {
        return String.format("Relatório Google Ads - Nome: %s, Palavras-chave: %s, Orçamento: %.2f, Receita: %.2f, ROI: %.2f%%",
                nome, String.join(", ", palavrasChave), orcamento, receita, calcularRoi());
    }

    @Override
    public void otimizar() {
        double roi = calcularRoi();
        if (roi < 0) {
            System.out.println("Pausar campanha e revisar palavras-chave");
        } else if (roi <= 50) {
            System.out.println("Ajustar lances e segmentação");
        } else {
            System.out.println("Escalar orçamento");
        }
    }
}