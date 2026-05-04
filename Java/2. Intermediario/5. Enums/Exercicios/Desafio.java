// ## Exercício 6 — Desafio

// Construa um sistema de gestão de campanhas do **Cerne** usando enums em todo o domínio:

// **Enums necessários:**

// ```java
// enum Plano { STARTER, PRO, ENTERPRISE }
// // com: mensalidade, limiteUsuarios, limiteCampanhas, calcularAnual()

// enum Plataforma { META_ADS, GOOGLE_ADS, TIKTOK_ADS }
// // com: nome, taxaMinima (double), otimizar(double roi)

// enum StatusCampanha { RASCUNHO, AGUARDANDO_APROVACAO, ATIVA, PAUSADA, ENCERRADA }
// // com: descricao, podePausar(), podeAtivar()
// ```

// **Classes:**

// ```java
// class Campanha {
//     String nome;
//     Plataforma plataforma;
//     StatusCampanha status;
//     double orcamento;
//     double receita;

//     double calcularRoi()
//     void avancarStatus()  // RASCUNHO → AGUARDANDO → ATIVA → ENCERRADA
//     void pausar()         // só se status for ATIVA
//     String resumo()
// }

// class Empresa {
//     String nome;
//     Plano plano;
//     List<Campanha> campanhas;

//     void adicionarCampanha(Campanha c)  // respeita limiteCampanhas do plano
//     void listarCampanhas()
//     void resumoFinanceiro()             // total investido, total receita, ROI médio
// }
// ```

// **No `main`:**

// 1. Crie 2 empresas com planos diferentes
// 2. Adicione campanhas em plataformas variadas
// 3. Avance os status das campanhas
// 4. Tente ultrapassar o limite de campanhas do plano
// 5. Chame `otimizar()` em cada campanha ativa
// 6. Imprima o resumo financeiro de cada empresa
// 7. Use `EnumMap<Plataforma, Long>` para contar campanhas por plataforma

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Desafio {
    public static void main(String[] args) {

        // 1. Crie 2 empresas com planos diferentes
        Empresa empresa1 = new Empresa("Empresa 1", Plano.STARTER);
        Empresa empresa2 = new Empresa("Empresa 2", Plano.PRO);

        // 2. Adicione campanhas em plataformas variadas + Tente ultrapassar o limite de campanhas do plano
        Campanha campanha1 = new Campanha("Campanha 1", Plataforma.META_ADS, 1000);
        Campanha campanha2 = new Campanha("Campanha 2", Plataforma.GOOGLE_ADS, 2000);
        Campanha campanha3 = new Campanha("Campanha 3", Plataforma.TIKTOK_ADS, 3000);
        Campanha campanha4 = new Campanha("Campanha 4", Plataforma.META_ADS, 4000);
        Campanha campanha5 = new Campanha("Campanha 5", Plataforma.GOOGLE_ADS, 5000);
        Campanha campanha6 = new Campanha("Campanha 6", Plataforma.TIKTOK_ADS, 6000); // Excesso para STARTER

        // 3. Avance os status das campanhas
        campanha1.avancarStatus(); // RASCUNHO → AGUARDANDO 
        campanha1.avancarStatus(); // AGUARDANDO → ATIVA
        campanha2.avancarStatus(); // RASCUNHO → AGUARDANDO 
        campanha2.avancarStatus(); // AGUARDANDO → ATIVA
        campanha3.avancarStatus(); // RASCUNHO → AGUARDANDO
        campanha3.avancarStatus(); // AGUARDANDO → ATIVA   
        campanha4.avancarStatus(); // RASCUNHO → AGUARDANDO
        campanha4.avancarStatus(); // AGUARDANDO → ATIVA 
        campanha5.avancarStatus(); // RASCUNHO → AGUARDANDO
        campanha6.avancarStatus(); // RASCUNHO → AGUARDANDO
        campanha6.avancarStatus(); // AGUARDANDO → ATIVA

        empresa1.adicionarCampanha(campanha1);
        empresa1.adicionarCampanha(campanha2);
        empresa2.adicionarCampanha(campanha3);
        empresa2.adicionarCampanha(campanha4);
        empresa2.adicionarCampanha(campanha5);
        empresa2.adicionarCampanha(campanha6); // Excesso para PRO

        empresa1.listarCampanhas();
        empresa2.listarCampanhas();

        // 5. Chame `otimizar()` em cada campanha ativa
        campanha1.receita = campanha1.plataforma.otimizar(campanha1.calcularRoi());
        campanha2.receita = campanha2.plataforma.otimizar(campanha2.calcularRoi());
        campanha3.receita = campanha3.plataforma.otimizar(campanha3.calcularRoi());
        campanha4.receita = campanha4.plataforma.otimizar(campanha4.calcularRoi());
        campanha5.receita = campanha5.plataforma.otimizar(campanha5.calcularRoi());
        campanha6.receita = campanha6.plataforma.otimizar(campanha6.calcularRoi());


        // 6. Imprima o resumo financeiro de cada empresa
        empresa1.resumoFinanceiro();
        empresa2.resumoFinanceiro();

        // 7. Use `EnumMap<Plataforma, Long>` para contar campanhas por plataforma
        EnumMap<Plataforma, Long> contagemPlataformas = new EnumMap<>(Plataforma.class);
        for (Campanha c : empresa1.campanhas) {
            contagemPlataformas.put(c.plataforma, contagemPlataformas.getOrDefault(c.plataforma, 0L) + 1);
        }
        for (Campanha c : empresa2.campanhas) {
            contagemPlataformas.put(c.plataforma, contagemPlataformas.getOrDefault(c.plataforma, 0L) + 1);
        }
        System.out.println("Contagem de campanhas por plataforma:");
        for (var entry : contagemPlataformas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

enum Plano {
    STARTER(29.99, 5, 10),
    PRO(59.99, 20, 50),
    ENTERPRISE(199.99, 100, 200);

    private double mensalidade;
    private int limiteUsuarios;
    private int limiteCampanhas;

    Plano(double mensalidade, int limiteUsuarios, int limiteCampanhas) {
        this.mensalidade = mensalidade;
        this.limiteUsuarios = limiteUsuarios;
        this.limiteCampanhas = limiteCampanhas;
    }

    public double calcularAnual() {
        return mensalidade * 12;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public int getLimiteUsuarios() {
        return limiteUsuarios;
    }

    public int getLimiteCampanhas() {
        return limiteCampanhas;
    }
}

enum Plataforma {
    META_ADS("Meta Ads", 0.05),
    GOOGLE_ADS("Google Ads", 0.04),
    TIKTOK_ADS("TikTok Ads", 0.06);

    private String nome;
    private double taxaMinima;

    Plataforma(String nome, double taxaMinima) {
        this.nome = nome;
        this.taxaMinima = taxaMinima;
    }

    public String getNome() {
        return nome;
    }

    public double getTaxaMinima() {
        return taxaMinima;
    }

    public double otimizar(double roi) {
        return roi * (1 + taxaMinima);
    }
}

enum StatusCampanha {
    RASCUNHO("Rascunho"),
    AGUARDANDO_APROVACAO("Aguardando Aprovação"),
    ATIVA("Ativa"),
    PAUSADA("Pausada"),
    ENCERRADA("Encerrada");

    private String descricao;

    StatusCampanha(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean podePausar() {
        return this == ATIVA;
    }

    public boolean podeAtivar() {
        return this == RASCUNHO || this == AGUARDANDO_APROVACAO || this == PAUSADA;
    }
}

class Campanha {

    String nome;
    Plataforma plataforma;
    StatusCampanha status;
    double orcamento;
    double receita;

    public Campanha(String nome, Plataforma plataforma, double orcamento) {
        this.nome = nome;
        this.plataforma = plataforma;
        this.status = StatusCampanha.RASCUNHO;
        this.orcamento = orcamento;
        this.receita = 0.0;
    }

    public double calcularRoi() {
        return (receita - orcamento) / orcamento;
    }

    public void avancarStatus() {
        switch (status) {
            case RASCUNHO:
                status = StatusCampanha.AGUARDANDO_APROVACAO;
                break;
            case AGUARDANDO_APROVACAO:
                status = StatusCampanha.ATIVA;
                break;
            case ATIVA:
                status = StatusCampanha.ENCERRADA;
                break;
            default:
                System.out.println("Não é possível avançar o status.");
        }
    }

    public void pausar() {
        if (status.podePausar()) {
            status = StatusCampanha.PAUSADA;
        } else {
            System.out.println("Só é possível pausar uma campanha ativa.");
        }
    }

    public String resumo() {
        return String.format("Campanha: %s | Plataforma: %s | Status: %s | Orçamento: %.2f | Receita: %.2f | ROI: %.2f%%",
                nome, plataforma.getNome(), status.getDescricao(), orcamento, receita, calcularRoi() * 100);
    }
}

class Empresa {
    String nome;
    Plano plano;
    List<Campanha> campanhas;

    public Empresa(String nome, Plano plano) {
        this.nome = nome;
        this.plano = plano;
        this.campanhas = new ArrayList<>();
    }

    public void adicionarCampanha(Campanha c) {
        if (campanhas.size() < plano.getLimiteCampanhas()) {
            campanhas.add(c);
        } else {
            System.out.println("Limite de campanhas atingido para o plano " + plano.name());
        }
    }

    public void listarCampanhas() {
        System.out.println("Campanhas da empresa " + nome + ":");
        for (Campanha c : campanhas) {
            System.out.println(c.resumo());
        }
    }

    public void resumoFinanceiro() {
        double totalInvestido = 0;
        double totalReceita = 0;
        for (Campanha c : campanhas) {
            totalInvestido += c.orcamento;
            totalReceita += c.receita;
        }
        double roiMedio = (totalReceita - totalInvestido) / totalInvestido;
        System.out.printf("Resumo Financeiro da empresa %s: Total Investido: %.2f | Total Receita: %.2f | ROI Médio: %.2f%%\n",
                nome, totalInvestido, totalReceita, roiMedio * 100);
    }
}