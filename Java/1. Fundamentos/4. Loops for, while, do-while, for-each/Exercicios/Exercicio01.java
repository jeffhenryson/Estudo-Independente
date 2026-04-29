// ## Exercício 1 — while

// Escreva um programa que some todos os números de 1 até 100 usando `while` e imprima o resultado.

// > Resultado esperado: 5050

public class Exercicio01 {
    public static void main(String[] args) {
        int soma = 0;
        int numero = 1;
        while (numero <= 100) {
            soma += numero; // soma = soma + numero
            numero++; // numero = numero + 1
        }
        System.out.println("A soma de 1 a 100 é: " + soma);
    }
}