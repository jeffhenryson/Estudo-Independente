
// ## Exercício 1 — Operações básicas

// Crie um `List<String>` de nomes de campanhas e:

// 1. Adicione 5 campanhas
// 2. Imprima todas com índice usando for tradicional
// 3. Substitua a campanha do índice 2 com `set()`
// 4. Adicione uma nova campanha no índice 1 com `add(índice, valor)`
// 5. Imprima o tamanho antes e depois de cada operação
// 6. Imprima o primeiro e o último elemento
// ---

import java.util.ArrayList;
import java.util.List;

public class Exercicio01 {
    public static void main(String[] args) {
        List<String> campanhas = new ArrayList<>();

        // 1. Adicione 5 campanhas
        campanhas.add("Campanha A");
        campanhas.add("Campanha B");
        campanhas.add("Campanha C");
        campanhas.add("Campanha D");
        campanhas.add("Campanha E");

        // 2. Imprima todas com índice usando for tradicional
        System.out.println("Campanhas:");
        for (int i = 0; i < campanhas.size(); i++) {
            System.out.println(i + ": " + campanhas.get(i));
        }

        // 3. Substitua a campanha do índice 2 com set()
        System.out.println("\nTamanho antes da substituição: " + campanhas.size());
        campanhas.set(2, "Campanha C Atualizada");
        System.out.println("Tamanho depois da substituição: " + campanhas.size());

        // 4. Adicione uma nova campanha no índice 1 com add(índice, valor)
        System.out.println("\nTamanho antes da adição: " + campanhas.size());
        campanhas.add(1, "Campanha F");
        System.out.println("Tamanho depois da adição: " + campanhas.size());

        // 5. Imprima o primeiro e o último elemento
        System.out.println("\nPrimeira campanha: " + campanhas.get(0));
        System.out.println("Última campanha: " + campanhas.get(campanhas.size() - 1));
    }
}
