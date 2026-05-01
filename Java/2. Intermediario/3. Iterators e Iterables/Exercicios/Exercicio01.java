// ## Exercício 1 — Iterator básico

// Dada a lista abaixo, use `Iterator` explicitamente (sem `for-each`):

// ```java
// List<String> campanhas = new ArrayList<>(Arrays.asList(
//     "Meta Black Friday",
//     "Google Remarketing",
//     "Meta Verão",
//     "TikTok Lançamento",
//     "Meta Natal",
//     "Google Search"
// ));
// ```

// 1. Itere com `Iterator` e imprima todas as campanhas
// 2. Use um segundo `Iterator` para remover todas que começam com `"Google"`
// 3. Imprima a lista final
// 4. Mostre com comentário por que `it.remove()` é seguro e `lista.remove()` dentro do loop não é

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Exercicio01 {
    public static void main(String[] args) {

        List<String> campanhas = new ArrayList<>(Arrays.asList(
            "Meta Black Friday",
            "Google Remarketing",
            "Meta Verão",
            "TikTok Lançamento",
            "Meta Natal",
            "Google Search"
        ));

        // 1. Iterar com Iterator e imprimir todas as campanhas
        Iterator<String> it = campanhas.iterator();
        System.out.println("Campanhas:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 2. Usar um segundo Iterator para remover todas que começam com "Google"
        Iterator<String> it2 = campanhas.iterator();
        while (it2.hasNext()) {
            String campanha = it2.next();
            if (campanha.startsWith("Google")) {
                it2.remove(); 
            }
        }

        // 3. Imprimir a lista final
        System.out.println("\nCampanhas após remoção:");
        for (String campanha : campanhas) {
            System.out.println(campanha);
        }

        // 4. Comentário sobre segurança de remoção
        /*
         * O método `it.remove()` é seguro porque ele remove o elemento atual do Iterator,
         * garantindo que a estrutura da coleção seja mantida corretamente durante a iteração.
         * Por outro lado, usar `lista.remove()` dentro do loop pode causar uma ConcurrentModificationException,
         * pois modifica a coleção diretamente enquanto ela está sendo iterada, o que quebra a consistência do Iterator.
         */
    }
}