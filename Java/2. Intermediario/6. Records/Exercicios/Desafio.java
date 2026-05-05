// ## Exercício 6 — Desafio

// Construa um sistema de relatórios do **Cerne** usando records como DTOs:

// **Records:**

// ```java
// record Campanha(String nome, String plataforma, double orcamento, double receita) {
//     // construtor compacto com validações
//     // calcularRoi(), classificar(), resumo()
// }

// record RelatorioEmpresa(
//     String nomeEmpresa,
//     String plano,
//     List<Campanha> campanhas
// ) {
//     // construtor compacto com List.copyOf
//     // totalInvestido() → soma dos orçamentos
//     // totalReceita() → soma das receitas
//     // roiMedio() → média dos ROIs
//     // melhorCampanha() → retorna Campanha com maior ROI
//     // piorCampanha() → retorna Campanha com menor ROI
//     // campanhasPorClassificacao() → Map<String, List<Campanha>>
// }

// record ResumoPlatforma(String plataforma, long totalCampanhas, double roiMedio) {
//     // resumo() formatado
// }
// ```

// **No `main`:**

// 1. Crie 3 campanhas para `"Meta Ads"` e 2 para `"Google Ads"`
// 2. Monte um `RelatorioEmpresa` com todas elas
// 3. Imprima:
//     - Total investido e receita total
//     - ROI médio
//     - Melhor e pior campanha
//     - Campanhas agrupadas por classificação
// 4. Monte um `List<ResumoPlatforma>` agrupando campanhas por plataforma e imprima cada resumo

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Desafio {
    public static void main(String[] args) {
        Campanha c1 = new Campanha("Campanha A", "Meta Ads", 1000, 3000);
        Campanha c2 = new Campanha("Campanha B", "Meta Ads", 1500, 2000);
        Campanha c3 = new Campanha("Campanha C", "Meta Ads", 2000, 2500);
        Campanha c4 = new Campanha("Campanha D", "Google Ads", 1200, 1800);
        Campanha c5 = new Campanha("Campanha E", "Google Ads", 800, 1600);

        RelatorioEmpresa relatorio = new RelatorioEmpresa("Minha Empresa", "Premium",
                List.of(c1, c2, c3, c4, c5));

        System.out.println("Total Investido: " + relatorio.totalInvestido());
        System.out.println("Total Receita: " + relatorio.totalReceita());
        System.out.println("ROI Médio: " + relatorio.roiMedio() * 100 + "%");
        System.out.println("Melhor Campanha: " + relatorio.melhorCampanha().resumo());
        System.out.println("Pior Campanha: " + relatorio.piorCampanha().resumo());

        Map<String, List<Campanha>> agrupadas = relatorio.campanhasPorClassificacao();
        for (String classificacao : agrupadas.keySet()) {
            System.out.println("\nClassificação: " + classificacao);
            for (Campanha c : agrupadas.get(classificacao)) {
                System.out.println(c.resumo());
            }
        }

        Map<String, List<Campanha>> porPlataforma = new HashMap<>();
        for (Campanha c : List.of(c1, c2, c3, c4, c5)) {
            porPlataforma.computeIfAbsent(c.plataforma(), k -> new ArrayList<>()).add(c);
        }

        List<ResumoPlatforma> resumos = new ArrayList<>();
        for (String plataforma : porPlataforma.keySet()) {
            List<Campanha> campanhas = porPlataforma.get(plataforma);
            double roiMedio = campanhas.stream().mapToDouble(Campanha::calcularRoi).average().orElse(0);
            resumos.add(new ResumoPlatforma(plataforma, campanhas.size(), roiMedio));
        }
        for (ResumoPlatforma r : resumos) {
            System.out.println(r.resumo());
        }
    }
}

record Campanha(String nome, String plataforma, double orcamento, double receita) {

    public Campanha {
        if (orcamento < 0 || receita < 0) {
            throw new IllegalArgumentException("Orçamento e receita devem ser não negativos.");
        }
    }

    public double calcularRoi() {
        return (receita - orcamento) / orcamento;
    }

    public String classificar() {
        double roi = calcularRoi();
        if (roi > 1) return "Excelente";
        else if (roi > 0.5) return "Bom";
        else if (roi > 0) return "Regular";
        else return "Ruim";
    }

    public String resumo() {
        return String.format("%s (%s): Orçamento: %.2f, Receita: %.2f, ROI: %.2f%%, Classificação: %s",
                nome, plataforma, orcamento, receita, calcularRoi() * 100, classificar());
    }
}

record RelatorioEmpresa(String nomeEmpresa, String plano, List<Campanha> campanhas) {

    public RelatorioEmpresa {
        campanhas = List.copyOf(campanhas);
    }

    public double totalInvestido() {
        double total = 0;
        for (Campanha c : campanhas) {
            total += c.orcamento();
        }
        return total;
    }

    public double totalReceita() {
        double total = 0;
        for (Campanha c : campanhas) {
            total += c.receita();
        }
        return total;
    }

    public double roiMedio() {
        double totalRoi = 0;
        for (Campanha c : campanhas) {
            totalRoi += c.calcularRoi();
        }
        return totalRoi / campanhas.size();
    }

    public Campanha melhorCampanha() {
        Campanha melhor = null;
        double melhorRoi = Double.NEGATIVE_INFINITY;
        for (Campanha c : campanhas) {
            double roi = c.calcularRoi();
            if (roi > melhorRoi) {
                melhorRoi = roi;
                melhor = c;
            }
        }
        return melhor;
    }

    public Campanha piorCampanha() {
        Campanha pior = null;
        double piorRoi = Double.POSITIVE_INFINITY;
        for (Campanha c : campanhas) {
            double roi = c.calcularRoi();
            if (roi < piorRoi) {
                piorRoi = roi;
                pior = c;
            }
        }
        return pior;
    }

    public Map<String, List<Campanha>> campanhasPorClassificacao() {
        Map<String, List<Campanha>> agrupadas = new HashMap<>();
        for (Campanha c : campanhas) {
            String classificacao = c.classificar();
            agrupadas.computeIfAbsent(classificacao, k -> new ArrayList<>()).add(c);
        }
        return agrupadas;
    }
}

record ResumoPlatforma(String plataforma, long totalCampanhas, double roiMedio) {
    public String resumo() {
        return String.format("Plataforma: %s, Total Campanhas: %d, ROI Médio: %.2f%%",
                plataforma, totalCampanhas, roiMedio * 100);
    }
}