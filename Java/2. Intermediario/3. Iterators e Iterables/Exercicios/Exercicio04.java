// ## Exercício 4 — Iterator com filtro

// Crie uma classe `IteratorPorPlataforma` que implementa `Iterator<String>` e filtra campanhas por plataforma:

// ```java
// List<String> campanhas = Arrays.asList(
//     "Meta | Black Friday",
//     "Google | Search Branded",
//     "Meta | Verão",
//     "TikTok | Lançamento",
//     "Meta | Natal",
//     "Google | Display",
//     "Meta | Remarketing"
// );
// ```

// 1. O construtor recebe a lista e a plataforma a filtrar (`"Meta"`, `"Google"`, etc.)
// 2. `hasNext()` avança internamente até achar o próximo que contém a plataforma
// 3. `next()` retorna o elemento e avança o cursor

// No `main`:

// ```java
// Iterator<String> metaIt = new IteratorPorPlataforma(campanhas, "Meta");
// while (metaIt.hasNext()) {
//     System.out.println(metaIt.next());
// }

// Iterator<String> googleIt = new IteratorPorPlataforma(campanhas, "Google");
// while (googleIt.hasNext()) {
//     System.out.println(googleIt.next());
// }
// ```

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Exercicio04 {
    public static void main(String[] args) {
        List<String> campanhas = Arrays.asList(
            "Meta | Black Friday",
            "Google | Search Branded",
            "Meta | Verão",
            "TikTok | Lançamento",
            "Meta | Natal",
            "Google | Display",
            "Meta | Remarketing"
        );

        Iterator<String> metaIt = new IteratorPorPlataforma(campanhas, "Meta");
        while (metaIt.hasNext()) {
            System.out.println(metaIt.next());
        }

        System.out.println(" ");

        Iterator<String> googleIt = new IteratorPorPlataforma(campanhas, "Google");
        while (googleIt.hasNext()) {
            System.out.println(googleIt.next());
        }
    }
}

class IteratorPorPlataforma implements Iterator<String> {
    
    private List<String> campanhas;
    private String plataforma;
    private int cursor;

    public IteratorPorPlataforma(List<String> campanhas, String plataforma) {
        this.campanhas = campanhas;
        this.plataforma = plataforma;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        while (cursor < campanhas.size()) {
            if (campanhas.get(cursor).contains(plataforma)) {
                return true;
            }
            cursor++;
        }
        return false;
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new IllegalStateException("Não há mais elementos para iterar.");
        }
        return campanhas.get(cursor++);
    }
}