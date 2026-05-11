// ## Exercício 2 — Lambdas com coleções

// Dada a lista:

// ```java
// List<String> campanhas = new ArrayList<>(Arrays.asList(
//     "  Meta Black Friday  ",
//     "Google Search Branded",
//     "meta verão",
//     "TikTok Lançamento",
//     "GOOGLE Display",
//     "Meta Remarketing",
//     "linkedin awareness"
// ));
// ```

// Use lambdas para:

// 1. Remover campanhas que contêm `"Google"` (qualquer case) com `removeIf()`
// 2. Normalizar todas as restantes: `trim()` + capitalizar primeira letra com `forEach()`
// 3. Ordenar alfabeticamente com `sort()`
// 4. Ordenar por tamanho do nome (menor para maior)
// 5. Imprima a lista após cada operação

// ## Exercício 2 — Lambdas com coleções

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio02 {
    public static void main(String[] args) {

        List<String> campanhas = new ArrayList<>(Arrays.asList(
            "  Meta Black Friday  ",
            "Google Search Branded",
            "meta verão",
            "TikTok Lançamento",
            "GOOGLE Display",
            "Meta Remarketing",
            "linkedin awareness"
        ));

        // 1. Remover campanhas que contêm "Google" (qualquer case) com removeIf()
        campanhas.removeIf(campanha -> campanha.toLowerCase().contains("google"));
        System.out.println("Após remover campanhas com 'Google': " + campanhas);

        // 2. Normalizar todas as restantes: trim() + capitalizar primeira letra com forEach()
        campanhas.replaceAll(campanha -> {
            String trimmed = campanha.trim();
            return trimmed.substring(0, 1).toUpperCase() + trimmed.substring(1).toLowerCase();
        });
        System.out.println("Após normalizar campanhas: " + campanhas);

        // 3. Ordenar alfabeticamente com sort()
        campanhas.sort((a, b) -> a.compareTo(b));  
        System.out.println("Após ordenar alfabeticamente: " + campanhas);

        // 4. Ordenar por tamanho do nome (menor para maior)
        campanhas.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("Após ordenar por tamanho: " + campanhas);
    }
}
