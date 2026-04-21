// ## Exercício 5 — Desafio

// Faça um programa que receba dois números inteiros do usuário e imprima:

// - A divisão inteira entre eles
// - A divisão decimal entre eles
// - O resto da divisão
// - Se o primeiro número é par ou ímpar (use `%` e ternário)
// - Se o segundo número é múltiplo do primeiro (dica: resto == 0)

import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int n1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int n2 = scanner.nextInt();

        divisaoInteira(n1, n2);
        divisaoDecimal(n1, n2);
        restoDivisao(n1, n2);
        parOuImpar(n1);
        ehMultiplo(n1, n2);
    }

    public static void divisaoInteira(int n1, int n2) {
        int resultado = n1 / n2;
        System.out.printf("Divisão inteira: %d%n", resultado);
    }

    public static void divisaoDecimal(int n1, int n2) {
        double resultado = (double) n1 / n2; 
        System.out.printf("Divisão decimal: %.2f%n", resultado);
    }

    public static void restoDivisao(int n1, int n2) {
        int resultado = n1 % n2; 
        System.out.printf("Resto da divisão: %d%n", resultado);
    }

    public static void parOuImpar(int n1) {
        String resultado = (n1 % 2 == 0) ? "par" : "ímpar";
        System.out.printf("%d é %s%n", n1, resultado);
    }

    public static void ehMultiplo(int n1, int n2) {
        boolean multiplo = (n2 % n1 == 0);
        System.out.printf("%d é múltiplo de %d? %b%n", n2, n1, multiplo);
    }

}
