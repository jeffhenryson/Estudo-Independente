// ## Exercício 4 — filter encadeado e Predicate reutilizável

// Usando as campanhas do exercício anterior:

// 1. Defina os seguintes `Predicate<Campanha>`:
//    - `ehMeta` → plataforma é `"Meta Ads"`
//    - `ehGoogle` → plataforma é `"Google Ads"`
//    - `ehLucrativa` → ROI > 0
//    - `orcamentoAlto` → orçamento > 900
//    - `roiExcelente` → ROI > 50

// 2. Use composição para filtrar:
//    - Meta lucrativas → `ehMeta.and(ehLucrativa)`
//    - Google com orçamento alto → `ehGoogle.and(orcamentoAlto)`
//    - Lucrativas com ROI excelente → `ehLucrativa.and(roiExcelente)`
//    - Não são Meta → `ehMeta.negate()`
//    - Meta OU Google → `ehMeta.or(ehGoogle)`

// 3. Para cada resultado imprima o nome das campanhas filtradas

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercicio04 {
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

        Predicate<Campanha> ehMeta = c -> c.plataforma().equals("Meta Ads");
        Predicate<Campanha> ehGoogle = c -> c.plataforma().equals("Google Ads");
        Predicate<Campanha> ehLucrativa = c -> c.calcularRoi() > 0;
        Predicate<Campanha> orcamentoAlto = c -> c.orcamento() > 900;
        Predicate<Campanha> roiExcelente = c -> c.calcularRoi() > 50;

        // Meta lucrativas
        List<Campanha> metaLucrativas = campanhas.stream()
            .filter(ehMeta.and(ehLucrativa))
            .collect(Collectors.toList());
        System.out.println("Meta lucrativas: " + metaLucrativas.stream().map(c -> c.nome()).collect(Collectors.toList()));

        // Google com orçamento alto
        List<Campanha> googleOrcamentoAlto = campanhas.stream()
            .filter(ehGoogle.and(orcamentoAlto))
            .collect(Collectors.toList());
        System.out.println("Google com orçamento alto: " + googleOrcamentoAlto.stream().map(c -> c.nome()).collect(Collectors.toList()));

        // Lucrativas com ROI excelente
        List<Campanha> lucrativasRoiExcelente = campanhas.stream()
            .filter(ehLucrativa.and(roiExcelente))
            .collect(Collectors.toList());
        System.out.println("Lucrativas com ROI excelente: " + lucrativasRoiExcelente.stream().map(c -> c.nome()).collect(Collectors.toList()));

        // Não são Meta
        List<Campanha> naoMeta = campanhas.stream()
            .filter(ehMeta.negate())
            .collect(Collectors.toList());
        System.out.println("Não são Meta: " + naoMeta.stream().map(c -> c.nome()).collect(Collectors.toList()));

        // Meta OU Google
        List<Campanha> metaOuGoogle = campanhas.stream()
            .filter(ehMeta.or(ehGoogle))
            .collect(Collectors.toList());
        System.out.println("Meta ou Google: " + metaOuGoogle.stream().map(c -> c.nome()).collect(Collectors.toList()));
    }
}
