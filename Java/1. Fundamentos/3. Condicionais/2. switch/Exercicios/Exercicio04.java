// ## 4. Estações do Ano

// **Enunciado:** Crie um programa em Java que declare um número inteiro representando o mês do ano (de 1 a 12). Utilize o `switch` moderno para agrupar os meses e imprimir a estação do ano correspondente:
// * **Primavera:** Meses 9, 10, 11
// * **Verão:** Meses 12, 1, 2
// * **Outono:** Meses 3, 4, 5
// * **Inverno:** Meses 6, 7, 8
// * Qualquer outro número: "Mês inválido"

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número do mês (1-12): ");
        int mes = scanner.nextInt();

        // Switch moderno para determinar a estação do ano
        String estacao = switch (mes) {
            case 9, 10, 11 -> "Primavera";
            case 12, 1, 2 -> "Verão";
            case 3, 4, 5 -> "Outono";
            case 6, 7, 8 -> "Inverno";
            default -> "Mês inválido";
        };

        System.out.println("A estação do ano é: " + estacao);

        scanner.close();
    }
}
