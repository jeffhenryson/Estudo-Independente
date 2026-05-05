// ## 3. Soma de Elementos de um Array com `for-each`

// **Enunciado:** Declare um array de números inteiros com os seguintes valores: `{10, 20, 30, 40, 50}`. Utilize um loop `for-each` para percorrer o array, somar todos os valores e imprimir o resultado final da soma.

public class Exercicio03 {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        int soma = 0;

        for (int numero : numeros) {
            soma += numero;
        }

        System.out.println("A soma dos elementos do array é: " + soma);
    }
}
