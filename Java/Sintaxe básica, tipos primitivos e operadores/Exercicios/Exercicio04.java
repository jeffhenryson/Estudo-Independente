// ## Exercício 4 — Entrada do usuário

// Faça um programa que:

// 1. Peça o nome do usuário
// 2. Peça a idade
// 3. Peça o salário
// 4. Imprima uma frase formatada com `printf`, por exemplo:
//     Olá, Jeff! Você tem 28 anos e ganha R$ 4500,75.

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String userName = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.print("Digite seu salário: ");
        double salario = scanner.nextDouble();

        System.out.printf("Olá, %s! Você tem %d anos e ganha R$ %.2f.%n", userName, idade, salario);
    }
}