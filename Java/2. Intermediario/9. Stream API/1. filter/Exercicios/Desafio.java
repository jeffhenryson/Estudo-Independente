// ## Exercício 6 — Desafio

// Construa um sistema de análise de campanhas do **Cerne** usando filter:

// ```java
// record Campanha(
//     String nome,
//     String plataforma,
//     String status,      // "ativa", "pausada", "encerrada"
//     double orcamento,
//     double receita,
//     int diasAtivos
// ) {
//     double calcularRoi() { return ((receita - orcamento) / orcamento) * 100; }
//     double calcularCpd() { return orcamento / diasAtivos; } // custo por dia
// }
// ```

// Crie uma lista com pelo menos 8 campanhas variadas e implemente os seguintes relatórios **usando apenas filter + terminais**:

// 1. **Campanhas críticas** → status `"ativa"` E ROI < 0
// 2. **Campanhas para escalar** → status `"ativa"` E ROI > 50
// 3. **Campanhas pausadas com potencial** → status `"pausada"` E ROI > 30
// 4. **Análise por plataforma**:
//    - Existe campanha ativa em cada plataforma? (`anyMatch` por plataforma)
//    - Todas as campanhas Meta têm orçamento acima de 500? (`allMatch`)
// 5. **Alertas**:
//    - Campanhas ativas há mais de 30 dias com ROI negativo
//    - Campanhas com custo por dia acima de 100 (`calcularCpd()`)
// 6. **Contagens**:
//    - Total de campanhas ativas
//    - Total de campanhas lucrativas (ROI > 0)
//    - Total de campanhas críticas (ROI < -20)

import java.util.Arrays;
import java.util.List;

public class Desafio {
    public static void main(String[] args) {
        record Campanha(
            String nome,
            String plataforma,
            String status,
            double orcamento,
            double receita,
            int diasAtivos
        ) {
            double calcularRoi() {
                return ((receita - orcamento) / orcamento) * 100;
            }

            double calcularCpd() {
                return orcamento / diasAtivos;
            }
        }

        List<Campanha> campanhas = Arrays.asList(
            new Campanha("Black Friday", "Meta Ads", "ativa", 1000.0, 1800.0, 20),
            new Campanha("Search Branded", "Google Ads", "pausada", 500.0, 400.0, 10),
            new Campanha("Verão", "Meta Ads", "ativa", 800.0, 1500.0, 15),
            new Campanha("Display", "Google Ads", "encerrada", 600.0, 900.0, 12),
            new Campanha("Lançamento", "TikTok Ads", "ativa", 300.0, 200.0, 5),
            new Campanha("Remarketing", "Meta Ads", "pausada", 1200.0, 2400.0, 25),
            new Campanha("Shopping", "Google Ads", "ativa", 900.0, 1100.0, 30),
            new Campanha("Outono", "Meta Ads", "ativa", 700.0, 600.0, 35)
        );

        // 1. Campanhas críticas → status "ativa" E ROI < 0
        List<Campanha> campanhasCriticas = campanhas.stream()
            .filter(c -> c.status().equals("ativa") && c.calcularRoi() < 0)
            .toList();
        System.out.println("Campanhas críticas: " + campanhasCriticas);

        // 2. Campanhas para escalar → status "ativa" E ROI > 50
        List<Campanha> campanhasParaEscalar = campanhas.stream()
            .filter(c -> c.status().equals("ativa") && c.calcularRoi() > 50)
            .toList();
        System.out.println("Campanhas para escalar: " + campanhasParaEscalar);

        // 3. Campanhas pausadas com potencial → status "pausada" E ROI > 30
        List<Campanha> campanhasPausadasPotencial = campanhas.stream()
            .filter(c -> c.status().equals("pausada") && c.calcularRoi() > 30)
            .toList();
        System.out.println("Campanhas pausadas com potencial: " + campanhasPausadasPotencial);

        // 4. Análise por plataforma
        boolean existeAtivaMeta = campanhas.stream()
            .anyMatch(c -> c.plataforma().equals("Meta Ads") && c.status().equals("ativa"));
        boolean existeAtivaGoogle = campanhas.stream()
            .anyMatch(c -> c.plataforma().equals("Google Ads") && c.status().equals("ativa"));
        System.out.println("Existe campanha ativa na Meta Ads? " + existeAtivaMeta);
        System.out.println("Existe campanha ativa no Google Ads? " + existeAtivaGoogle);

        boolean todasMetaOrcamentoAcima500 = campanhas.stream()
            .filter(c -> c.plataforma().equals("Meta Ads"))
            .allMatch(c -> c.orcamento() > 500);
        System.out.println("Todas as campanhas Meta têm orçamento acima de 500? " + todasMetaOrcamentoAcima500);

        // 5. Alertas
        List<Campanha> alertasRoiNegativo = campanhas.stream()
            .filter(c -> c.status().equals("ativa") && c.diasAtivos() > 30 && c.calcularRoi() < 0)
            .toList();
        System.out.println("Campanhas ativas há mais de 30 dias com ROI negativo: " + alertasRoiNegativo);

        List<Campanha> alertasCustoPorDia = campanhas.stream()
            .filter(c -> c.calcularCpd() > 100)
            .toList();
        System.out.println("Campanhas com custo por dia acima de 100: " + alertasCustoPorDia);

        // 6. Contagens
        long totalAtivas = campanhas.stream()
            .filter(c -> c.status().equals("ativa"))
            .count();
        System.out.println("Total de campanhas ativas: " + totalAtivas);

        long totalLucrativas = campanhas.stream()
            .filter(c -> c.calcularRoi() > 0)
            .count();
        System.out.println("Total de campanhas lucrativas: " + totalLucrativas);

        long totalCriticas = campanhas.stream()
            .filter(c -> c.calcularRoi() < -20)
            .count();
        System.out.println("Total de campanhas críticas: " + totalCriticas);
    }
}
