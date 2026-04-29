// ## Exercício 2 — Arrays utilitários

// Dado o array:

// ```java
// int[] valores = {15, 3, 42, 8, 23, 4, 16};
// ```

// 1. Ordene o array com `Arrays.sort()`
// 2. Imprima o array ordenado com `Arrays.toString()`
// 3. Faça uma cópia dos 3 primeiros elementos com `Arrays.copyOfRange()`
// 4. Preencha o array original com `0` usando `Arrays.fill()`
// 5. Imprima o array após o fill

import java.util.Arrays;

public class Exercicio02 {
    public static void main(String[] args) {
        int[] valores = {15, 3, 42, 8, 23, 4, 16};

        // 1. Ordenar o array
        Arrays.sort(valores);

        // 2. Imprimir o array ordenado
        System.out.println("Array ordenado: " + Arrays.toString(valores));

        // 3. Cópia dos 3 primeiros elementos
        int[] copia = Arrays.copyOfRange(valores, 0, 3);
        System.out.println("Cópia dos 3 primeiros elementos: " + Arrays.toString(copia));

        // 4. Preencher o array original com 0
        Arrays.fill(valores, 0);

        // 5. Imprimir o array após o fill
        System.out.println("Array após fill: " + Arrays.toString(valores));
    }
}
