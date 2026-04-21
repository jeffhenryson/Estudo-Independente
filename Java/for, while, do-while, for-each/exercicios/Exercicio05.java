// ## Exercício 5 — break e continue

// Escreva um programa que:

// 1. Percorra os números de 1 a 20
// 2. Pule os múltiplos de 3 com `continue`
// 3. Pare completamente ao encontrar um múltiplo de 7 com `break`
// 4. Imprima cada número que passou pelas duas condições

public class Exercicio05 {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            if (i % 3 == 0) {
                continue; // Pula os múltiplos de 3
            }
            if (i % 7 == 0) {
                break; // Para ao encontrar um múltiplo de 7
            }
            System.out.println(i); // Imprime os números que passaram pelas condições
        }
    }
}
