// ## Exercício 2 — filter com números

// ```java
// List<Double> orcamentos = Arrays.asList(
//     250.0, 1500.0, 800.0, 3000.0, 150.0,
//     2500.0, 600.0, 4000.0, 900.0, 75.0
// );
// ```

// 1. Filtre orçamentos acima de 1000 → colete e imprima
// 2. Filtre orçamentos entre 500 e 2000 (inclusive) → colete e imprima
// 3. Filtre orçamentos abaixo de 300 → some com `count()`
// 4. Verifique se algum orçamento é acima de 5000 com `anyMatch()`
// 5. Verifique se todos são positivos com `allMatch()`
// 6. Verifique se nenhum é zero com `noneMatch()`

import java.util.Arrays;
import java.util.List;

public class Exercicio02 {
    public static void main(String[] args) {
        
        List<Double> orcamentos = Arrays.asList(
            250.0, 1500.0, 800.0, 3000.0, 150.0,
            2500.0, 600.0, 4000.0, 900.0, 75.0
        );

        List<Double> acimaDeMil = orcamentos.stream()
                .filter(o -> o > 1000)
                .toList();
        System.out.println("Orçamentos acima de 1000: " + acimaDeMil);

        List<Double> entre500e2000 = orcamentos.stream()
                .filter(o -> o >= 500 && o <= 2000)
                .toList();
        System.out.println("Orçamentos entre 500 e 2000: " + entre500e2000);

        long abaixoDe300 = orcamentos.stream()
                .filter(o -> o < 300)
                .count();
        System.out.println("Quantidade de orçamentos abaixo de 300: " + abaixoDe300);

        boolean algumAcimaDe5000 = orcamentos.stream()
                .anyMatch(o -> o > 5000);
        System.out.println("Algum orçamento acima de 5000? " + algumAcimaDe5000);

        boolean todosPositivos = orcamentos.stream()
                .allMatch(o -> o > 0);
        System.out.println("Todos os orçamentos são positivos? " + todosPositivos);

        boolean nenhumZero = orcamentos.stream()
                .noneMatch(o -> o == 0);
        System.out.println("Nenhum orçamento é zero? " + nenhumZero);
    }
}