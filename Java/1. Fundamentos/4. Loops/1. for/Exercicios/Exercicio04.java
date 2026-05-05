// ## 4. Impressão de Números Pares

// **Enunciado:** Crie um programa que use um loop `for` para imprimir apenas os números pares existentes no intervalo de 1 a 50.

public class Exercicio04 {
    public static void main(String[] args) {

        // para imprimir apenas os números pares, podemos iniciar o loop a partir do número 2 
        // (o primeiro número par) e incrementar o contador em 2 a cada iteração. 
        // Dessa forma, o loop irá percorrer apenas os números pares (2, 4, 6, ..., 50).
        for (int i = 2; i <= 50; i += 2) {
            System.out.println(i);
        }
    }
}
