// ## Exercício 4 — TreeSet e navegação

// Crie um `TreeSet<Integer>` com os orçamentos de campanhas em reais:

// ```java
// // valores para adicionar:
// // 5000, 1500, 8000, 3000, 12000, 750, 4500
// ```

// 1. Adicione todos e imprima o set ordenado
// 2. Imprima o menor e o maior orçamento com `first()` e `last()`
// 3. Use `floor()` para encontrar o maior orçamento **menor ou igual** a 4000
// 4. Use `ceiling()` para encontrar o menor orçamento **maior ou igual** a 4000
// 5. Use `headSet()` para listar campanhas com orçamento abaixo de 5000
// 6. Use `tailSet()` para listar campanhas com orçamento a partir de 5000
// 7. Use `subSet()` para listar campanhas entre 2000 e 8000

import java.util.Arrays;
import java.util.TreeSet;

public class Exercicio04 {
    public static void main(String[] args) {

        TreeSet<Integer> orcamentos = new TreeSet<>(Arrays.asList(
            5000, 1500, 8000, 3000, 12000, 750, 4500
        ));

        System.out.println("Orçamentos ordenados: " + orcamentos);
        System.out.println("Menor orçamento: " + orcamentos.first());
        System.out.println("Maior orçamento: " + orcamentos.last());
        System.out.println("Maior orçamento <= 4000: " + orcamentos.floor(4000));
        System.out.println("Menor orçamento >= 4000: " + orcamentos.ceiling(4000));
        System.out.println("Campanhas com orçamento < 5000: " + orcamentos.headSet(5000));
        System.out.println("Campanhas com orçamento >= 5000: " + orcamentos.tailSet(5000));
        System.out.println("Campanhas entre 2000 e 8000: " + orcamentos.subSet(2000, true, 8000, true));
    }
}
