// ## Exercício 3 — Métodos modernos
// 
// Dado o mapa de contagem de campanhas por plataforma:
// 
// ```java
// Map<String, Integer> contagem = new HashMap<>();
// ```
// 
// 1. Use `putIfAbsent()` para inicializar `"Meta Ads"`, `"Google Ads"` e `"TikTok Ads"` com 0
// 2. Tente usar `putIfAbsent()` novamente com `"Meta Ads"` → 99 e confirme que não mudou
// 3. Use `merge()` para incrementar a contagem — simule que chegaram:
//    - 3 campanhas de `"Meta Ads"`
//    - 2 de `"Google Ads"`
//    - 1 de `"TikTok Ads"`
// 4. Use `replace()` para zerar `"TikTok Ads"`
// 5. Imprima o mapa final com `forEach` e lambda

import java.util.HashMap;
import java.util.Map;

public class Exercicio03 {
    public static void main(String[] args) {

        Map<String, Integer> contagem = new HashMap<>();
        contagem.putIfAbsent("Meta Ads", 0);
        contagem.putIfAbsent("Google Ads", 0);
        contagem.putIfAbsent("TikTok Ads", 0);
        contagem.putIfAbsent("Meta Ads", 99); // Não vai alterar o valor de "Meta Ads"

        contagem.merge("Meta Ads", 3, Integer::sum); // Incrementa 3 para "Meta Ads"
        contagem.merge("Google Ads", 2, Integer::sum); // Incrementa 2 para "Google Ads"
        contagem.merge("TikTok Ads", 1, Integer::sum); // Incrementa 1 para "TikTok Ads"

        contagem.replace("TikTok Ads", 0); // Zera a contagem de "TikTok Ads"

        //Ajuda da IA, não aprendi lambda ainda, mas é uma forma moderna de iterar sobre o mapa e imprimir os resultados.
        contagem.forEach((plataforma, quantidade) -> 
            System.out.println(plataforma + ": " + quantidade)
        );
    }
}
