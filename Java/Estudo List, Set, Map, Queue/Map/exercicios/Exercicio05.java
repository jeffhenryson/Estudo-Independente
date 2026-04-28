// ## Exercício 5 — Map com List como valor

// Construa um agrupador de campanhas por plataforma:

// 1. Use `Map<String, List<String>>` para agrupar campanhas
// 2. Adicione pelo menos 3 campanhas para cada plataforma:
//    - `"Meta Ads"`, `"Google Ads"`, `"TikTok Ads"`
// 3. Use `computeIfAbsent()` para criar a lista automaticamente se não existir
// 4. Imprima no formato:
// ```
// Meta Ads (3 campanhas):
//   - Black Friday
//   - Verão
//   - Remarketing
// ```
// 5. Imprima o total geral de campanhas somando o tamanho de todas as listas
// 6. Encontre a plataforma com mais campanhas

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercicio05 {
    public static void main(String[] args) {

        Map<String, List<String>> campanhasPorPlataforma = new HashMap<>();

        campanhasPorPlataforma.computeIfAbsent("Meta Ads", k -> new ArrayList<>()).add("Black Friday");
        campanhasPorPlataforma.computeIfAbsent("Meta Ads", k -> new ArrayList<>()).add("Verão");
        campanhasPorPlataforma.computeIfAbsent("Meta Ads", k -> new ArrayList<>()).add("Remarketing");

        campanhasPorPlataforma.computeIfAbsent("Google Ads", k -> new ArrayList<>()).add("Lançamento de Produto");
        campanhasPorPlataforma.computeIfAbsent("Google Ads", k -> new ArrayList<>()).add("Campanha de Natal");

        campanhasPorPlataforma.computeIfAbsent("TikTok Ads", k -> new ArrayList<>()).add("Desafio de Verão");

        int totalCampanhas = 0;
        String plataformaComMaisCampanhas = null;
        int maxCampanhas = 0;

        for (Map.Entry<String, List<String>> entry : campanhasPorPlataforma.entrySet()) {
            String plataforma = entry.getKey();
            List<String> campanhas = entry.getValue();
            System.out.println(plataforma + " (" + campanhas.size() + " campanhas):");
            for (String campanha : campanhas) {
                System.out.println("  - " + campanha);
            }
            totalCampanhas += campanhas.size();

            // Verificando qual plataforma tem mais campanhas
            if (campanhas.size() > maxCampanhas) {
                maxCampanhas = campanhas.size();
                plataformaComMaisCampanhas = plataforma;
            }
        }

        // Imprimindo o total geral de campanhas
        System.out.println("\nTotal geral de campanhas: " + totalCampanhas);

        // Imprimindo a plataforma com mais campanhas
        System.out.println("Plataforma com mais campanhas: " + plataformaComMaisCampanhas);
    }
}
