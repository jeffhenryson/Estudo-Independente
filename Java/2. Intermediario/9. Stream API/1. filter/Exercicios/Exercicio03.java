// ## Exercício 3 — filter com objetos

// ```java
// record Campanha(String nome, String plataforma, double orcamento, double receita) {
//     double calcularRoi() {
//         return ((receita - orcamento) / orcamento) * 100;
//     }
// }

// List<Campanha> campanhas = Arrays.asList(
//     new Campanha("Black Friday", "Meta Ads", 1000.0, 1800.0),
//     new Campanha("Search Branded", "Google Ads", 500.0, 400.0),
//     new Campanha("Verão", "Meta Ads", 800.0, 1500.0),
//     new Campanha("Display", "Google Ads", 600.0, 900.0),
//     new Campanha("Lançamento", "TikTok Ads", 300.0, 200.0),
//     new Campanha("Remarketing", "Meta Ads", 1200.0, 2400.0),
//     new Campanha("Shopping", "Google Ads", 900.0, 1100.0)
// );
// ```

// 1. Filtre só campanhas da `"Meta Ads"` → colete e imprima nomes
// 2. Filtre campanhas com ROI positivo → conte
// 3. Filtre campanhas com orçamento acima de 800 E ROI positivo → colete
// 4. Filtre campanhas com ROI acima de 50% → imprima nome e ROI formatado
// 5. Encontre a primeira campanha do `"Google Ads"` com `findFirst()` → imprima

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio03 {
    public static void main(String[] args) { 

        record Campanha(String nome, String plataforma, double orcamento, double receita) {
            double calcularRoi() {
                return ((receita - orcamento) / orcamento) * 100;
            }
        }

        List<Campanha> campanhas = Arrays.asList(
            new Campanha("Black Friday", "Meta Ads", 1000.0, 1800.0),
            new Campanha("Search Branded", "Google Ads", 500.0, 400.0),
            new Campanha("Verão", "Meta Ads", 800.0, 1500.0),
            new Campanha("Display", "Google Ads", 600.0, 900.0),
            new Campanha("Lançamento", "TikTok Ads", 300.0, 200.0),
            new Campanha("Remarketing", "Meta Ads", 1200.0, 2400.0),
            new Campanha("Shopping", "Google Ads", 900.0, 1100.0)
        );

        List<String> metaAdsNomes = campanhas.stream()
            .filter(c -> c.plataforma().equals("Meta Ads"))
            .map(c -> c.nome())
            .collect(Collectors.toList());
        System.out.println("Campanhas Meta Ads: " + metaAdsNomes);

        // 2. Filtre campanhas com ROI positivo → conte
        long campanhasRoiPositivo = campanhas.stream()
            .filter(c -> c.calcularRoi() > 0)
            .count();
        System.out.println("Número de campanhas com ROI positivo: " + campanhasRoiPositivo);

        // 3. Filtre campanhas com orçamento acima de 800 E ROI positivo → colete
        List<Campanha> campanhasOrcamentoRoi = campanhas.stream()
            .filter(c -> c.orcamento() > 800 && c.calcularRoi() > 0)
            .collect(Collectors.toList());
        System.out.println("Campanhas com orçamento > 800 e ROI positivo: " + campanhasOrcamentoRoi);

        // 4. Filtre campanhas com ROI acima de 50% → imprima nome e ROI formatado
        campanhas.stream()
            .filter(c -> c.calcularRoi() > 50)
            .forEach(c -> System.out.printf("Campanha: %s, ROI: %.2f%%%n", c.nome(), c.calcularRoi()));

        // 5. Encontre a primeira campanha do "Google Ads" com findFirst() → imprima
        campanhas.stream()
            .filter(c -> c.plataforma().equals("Google Ads"))
            .findFirst()
            .ifPresent(c -> System.out.println("Primeira campanha Google Ads: " + c));
    }
}
