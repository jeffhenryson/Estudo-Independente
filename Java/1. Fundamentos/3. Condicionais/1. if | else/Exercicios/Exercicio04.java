// ## 4. Classificação de Idade

// **Enunciado:** Escreva um programa que classifique uma pessoa por faixa etária com base em sua `idade` (número inteiro):
// * **Criança:** de 0 a 12 anos.
// * **Adolescente:** de 13 a 17 anos.
// * **Adulto:** de 18 a 59 anos.
// * **Idoso:** 60 anos ou mais.

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();

        if (idade >= 0 && idade <= 12) {
            System.out.println("Criança");
        } else if (idade >= 13 && idade <= 17) {
            System.out.println("Adolescente");
        } else if (idade >= 18 && idade <= 59) {
            System.out.println("Adulto");
        } else if (idade >= 60) {
            System.out.println("Idoso");
        } else {
            System.out.println("Idade inválida.");
        }
    }
}
