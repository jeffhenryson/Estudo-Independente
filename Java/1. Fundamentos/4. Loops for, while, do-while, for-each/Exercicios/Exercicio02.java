// ## Exercício 2 — do-while

// Crie um menu interativo com `do-while` que ofereça as opções:

// ```
// 1 - Converter Real para Dólar
// 2 - Converter Real para Euro
// 0 - Sair
// ```

// - Leia a opção do usuário
// - Se for 1 ou 2, peça o valor em reais e imprima o resultado convertido
// - Use taxas fixas: Dólar = R$ 5,70 / Euro = R$ 6,10
// - Continue mostrando o menu até o usuário digitar 0

import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Menu:");
            System.out.println("1 - Converter Real para Dólar");
            System.out.println("2 - Converter Real para Euro");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor em reais: R$ ");
                    double reaisParaDolar = scanner.nextDouble();
                    double dolar = reaisParaDolar / 5.70;
                    System.out.printf("Valor em dólares: $ %.2f%n", dolar);
                    break;
                case 2:
                    System.out.print("Digite o valor em reais: R$ ");
                    double reaisParaEuro = scanner.nextDouble();
                    double euro = reaisParaEuro / 6.10;
                    System.out.printf("Valor em euros: € %.2f%n", euro);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
