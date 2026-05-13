// ## Exercício 1 — filter básico com Strings

// Dada a lista:

// ```java
// List<String> campanhas = Arrays.asList(
//     "Meta Black Friday",
//     "Google Search Branded",
//     "Meta Verão 2024",
//     "TikTok Lançamento",
//     "Google Display",
//     "Meta Remarketing",
//     "LinkedIn Awareness",
//     "Google Shopping"
// );
// ```

// 1. Filtre só as que começam com `"Meta"` → colete em lista e imprima
// 2. Filtre só as que contêm `"Search"` → imprima com `forEach`
// 3. Filtre as que têm mais de 15 caracteres → conte com `count()`
// 4. Filtre as que NÃO começam com `"Google"` → colete e imprima
// 5. Filtre as que começam com `"Google"` OU `"LinkedIn"` → colete e imprima

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio01 {
    public static void main(String[] args) {

        List<String> campanhas = Arrays.asList(
                "Meta Black Friday",
                "Google Search Branded",
                "Meta Verão 2024",
                "TikTok Lançamento",
                "Google Display",
                "Meta Remarketing",
                "LinkedIn Awareness",
                "Google Shopping");

        List<String> metaCampanhas = campanhas.stream()
                .filter(c -> c.startsWith("Meta"))
                .collect(Collectors.toList());
        System.out.println("Campanhas que começam com 'Meta': " + metaCampanhas);

        System.out.println("Campanhas que contêm 'Search':");
        campanhas.stream()
                .filter(c -> c.contains("Search"))
                .forEach(c -> System.out.println(c));

        long countMaisDe15 = campanhas.stream()
                .filter(c -> c.length() > 15)
                .count();
        System.out.println("Quantidade de campanhas com mais de 15 caracteres: " + countMaisDe15);

        List<String> naoGoogleCampanhas = campanhas.stream()
                .filter(c -> !c.startsWith("Google"))
                .collect(Collectors.toList());
        System.out.println("Campanhas que NÃO começam com 'Google': " + naoGoogleCampanhas);

        List<String> googleOuLinkedInCampanhas = campanhas.stream()
                .filter(c -> c.startsWith("Google") || c.startsWith("LinkedIn"))
                .collect(Collectors.toList());
        System.out.println("Campanhas que começam com 'Google' ou 'LinkedIn': " + googleOuLinkedInCampanhas);
    }
}