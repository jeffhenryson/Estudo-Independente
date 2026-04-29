// ## Exercício 4 — Contando ocorrências

// Dado o array de plataformas usadas em campanhas:

// ```java
// String[] registros = {
//     "Meta Ads", "Google Ads", "Meta Ads", "TikTok Ads",
//     "Google Ads", "Meta Ads", "LinkedIn Ads", "Google Ads",
//     "Meta Ads", "TikTok Ads"
// };
// ```

// 1. Use `merge()` para contar quantas vezes cada plataforma aparece
// 2. Imprima o resultado ordenado por plataforma — dica: use `TreeMap`
// 3. Encontre a plataforma com maior número de campanhas
// 4. Calcule o total de registros somando todos os valores

import java.util.Map;
import java.util.TreeMap;

public class Exercicio04 {
    public static void main(String[] args) {

        String[] registros = {
            "Meta Ads", "Google Ads", "Meta Ads", "TikTok Ads",
            "Google Ads", "Meta Ads", "LinkedIn Ads", "Google Ads",
            "Meta Ads", "TikTok Ads"
        };

        Map<String, Integer> contagem = new TreeMap<>();

        for (String plataforma : registros) {
            contagem.merge(plataforma, 1, Integer::sum); // Incrementa a contagem para cada plataforma
        }

        System.out.println("Contagem por plataforma: " + contagem);

        // Encontrar a plataforma com maior número de campanhas
        String plataformaMaisUsada = null;
        int maxContagem = 0;
        for (Map.Entry<String, Integer> entry : contagem.entrySet()) { 
            if (entry.getValue() > maxContagem) { 
                maxContagem = entry.getValue(); 
                plataformaMaisUsada = entry.getKey();
            }
        }
        System.out.println("Plataforma mais usada: " + plataformaMaisUsada);
        System.out.println("Número de campanhas: " + maxContagem);
    }
}
