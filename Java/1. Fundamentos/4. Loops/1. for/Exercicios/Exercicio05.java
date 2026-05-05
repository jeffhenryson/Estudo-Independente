// ## 5. Fatorial de um Número

// **Enunciado:** O fatorial de um número inteiro positivo $n$ é o produto de todos os inteiros positivos menores ou iguais a $n$ (representado por $n!$). Escreva um programa que calcule o fatorial de 5 ($5! = 5 \times 4 \times 3 \times 2 \times 1$) utilizando um loop `for` e exiba o resultado.

import java.util.Scanner;
import java.math.BigInteger;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int n = scanner.nextInt();

        // big integer é utilizado para lidar com números muito grandes, 
        // como o fatorial de números maiores que 20, que podem exceder a capacidade
        //  de armazenamento de tipos primitivos como int ou long.
        BigInteger fatorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fatorial = fatorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println("O fatorial de " + n + " é: " + fatorial);
    }
}
