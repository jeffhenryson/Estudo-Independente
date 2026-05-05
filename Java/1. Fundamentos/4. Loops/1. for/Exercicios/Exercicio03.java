// ## 3. Soma dos Números de 1 a 100
// **Enunciado:** Escreva um programa que utilize um loop `for` para somar todos os números inteiros de 1 a 100 e imprima o resultado final (a soma total deve ser 5050).

public class Exercicio03 {
    public static void main(String[] args) {
        int soma = 0;

        for (int i = 1; i <= 100; i++) {
            soma += i; 
        }

        System.out.println("A soma dos números de 1 a 100 é: " + soma);
    }    
}
