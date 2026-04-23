// ## Exercício 6 — Desafio

// Crie um sistema de cadastro simples usando arrays:

// 1. Crie arrays para armazenar até 5 usuários: `nomes`, `emails`, `planos`
// 2. Use um menu `do-while` com as opções:
//     - `1 - Cadastrar usuário`
//     - `2 - Listar usuários`
//     - `0 - Sair`
// 3. No cadastro, leia nome, email e plano via `Scanner` e armazene nos arrays
// 4. Na listagem, imprima todos os usuários cadastrados formatado com `printf`
// 5. Bloqueie o cadastro quando os 5 slots estiverem ocupados
// 6. Use `.trim()` e `.toLowerCase()` ao salvar o plano para normalizar a entrada

import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nomes = new String[5];
        String[] emails = new String[5];
        String[] planos = new String[5];

        int count = 0;
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (count < 5) {
                        System.out.print("Nome: ");
                        nomes[count] = scanner.nextLine();
                        System.out.print("Email: ");
                        emails[count] = scanner.nextLine();
                        System.out.print("Plano: ");
                        planos[count] = scanner.nextLine().trim().toLowerCase();
                        count++;
                    } else {
                        System.out.println("Limite de usuários atingido!");
                    }
                    break;
                case 2:
                    System.out.println("Usuários cadastrados:");
                    for (int i = 0; i < count; i++) {
                        System.out.printf("%d. %s - %s - Plano: %s%n", i + 1, nomes[i], emails[i], planos[i]);
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
