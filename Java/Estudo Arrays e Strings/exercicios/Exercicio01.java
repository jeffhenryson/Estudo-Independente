// ## Exercício 1 — Arrays básico

// Dado o array abaixo, sem usar `Arrays.sort()`:

// ```java
// int[] notas = {7, 3, 9, 5, 8, 2, 6};
// ```

// 1. Imprima todos os elementos com seus índices
// 2. Encontre e imprima a maior nota
// 3. Encontre e imprima a menor nota
// 4. Calcule e imprima a média

public class Exercicio01 {

    public static void main(String[] args) {
    
        int[] notas = {7, 3, 9, 5, 8, 2, 6};

        // 1. Imprimindo elementos com seus índices
        System.out.println("Notas com índices:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Índice " + i + ": " + notas[i]);
        }

        // 2. Encontrar e imprimir a maior nota
        int maiorNota = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
            }
        }
        System.out.println("Maior nota: " + maiorNota);

        // 3. Encontrar e imprimir a menor nota
        int menorNota = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < menorNota) {
                menorNota = notas[i];
            }
        }
        System.out.println("Menor nota: " + menorNota);

        // 4. Calcular e imprimir a média
        int soma = 0;
        for (int nota : notas) {
            soma += nota;
        }
        double media = (double) soma / notas.length;
        System.out.println("Média: " + media);
    }
}