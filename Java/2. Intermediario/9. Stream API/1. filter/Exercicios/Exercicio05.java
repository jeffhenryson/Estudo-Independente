// ## Exercício 5 — filter com terminais variados

// Usando as campanhas do exercício 3:

// 1. `count()` → quantas campanhas têm orçamento acima de 700
// 2. `findFirst()` → primeira campanha com ROI negativo — trate o `Optional`
// 3. `anyMatch()` → existe alguma campanha do `"TikTok Ads"`?
// 4. `allMatch()` → todas as campanhas têm receita positiva?
// 5. `noneMatch()` → nenhuma campanha tem orçamento zerado?
// 6. Combine: existe alguma campanha Meta com ROI acima de 100%?

import java.util.Arrays;
import java.util.List;

public class Exercicio05 {
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

        // 1. count() → quantas campanhas têm orçamento acima de 700
        long countOrcamentoAcima700 = campanhas.stream()
            .filter(c -> c.orcamento() > 700)
            .count();
        System.out.println("Campanhas com orçamento acima de 700: " + countOrcamentoAcima700);

        // 2. findFirst() → primeira campanha com ROI negativo — trate o Optional
        campanhas.stream()
            .filter(c -> c.calcularRoi() < 0)
            .findFirst()
            .ifPresentOrElse(
                c -> System.out.println("Primeira campanha com ROI negativo: " + c),
                () -> System.out.println("Nenhuma campanha com ROI negativo encontrada")
            );

        // 3. anyMatch() → existe alguma campanha do "TikTok Ads"?
        boolean existeTikTokAds = campanhas.stream()
            .anyMatch(c -> c.plataforma().equals("TikTok Ads"));
        System.out.println("Existe campanha do TikTok Ads? " + existeTikTokAds);

        // 4. allMatch() → todas as campanhas têm receita positiva?
        boolean todasReceitaPositiva = campanhas.stream()
            .allMatch(c -> c.receita() > 0);
        System.out.println("Todas as campanhas têm receita positiva? " + todasReceitaPositiva);

        // 5. noneMatch() → nenhuma campanha tem orçamento zerado?
        boolean nenhumaOrcamentoZerado = campanhas.stream()
            .noneMatch(c -> c.orcamento() == 0);
        System.out.println("Nenhuma campanha tem orçamento zerado? " + nenhumaOrcamentoZerado);

        // 6. Combine: existe alguma campanha Meta com ROI acima de 100%?
        boolean metaComRoiAcima100 = campanhas.stream()
            .anyMatch(c -> c.plataforma().equals("Meta Ads") && c.calcularRoi() > 100);
        System.out.println("Existe campanha Meta com ROI acima de 100%? " + metaComRoiAcima100);
    }
}