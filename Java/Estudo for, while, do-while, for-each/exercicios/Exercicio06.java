// ## Exercício 6 — Desafio

// Recrie o simulador de login do exercício anterior, mas agora usando o que você aprendeu sobre loops formalmente. Adicione:

// 1. Um menu do-while com as opções:
//     - 1 - Login
//     - 2 - Recuperar senha (só imprime "Funcionalidade em breve")
//     - 0 - Sair
// 2. A opção de login deve usar o mesmo sistema de 3 tentativas com while
// 3. Após login bem-sucedido, volte ao menu principal
// 4. O programa só encerra quando o usuário digitar 0

import java.util.Scanner;
public class Exercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctUsername = "admin";
        String correctPassword = "password";
        int option;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Login");
            System.out.println("2 - Recuperar senha");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    int attempts = 3;
                    boolean loggedIn = false;
                    while (attempts > 0 && !loggedIn) {
                        System.out.print("Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();

                        if (username.equals(correctUsername) && password.equals(correctPassword)) {
                            System.out.println("Login bem-sucedido!");
                            loggedIn = true;
                        } else {
                            attempts--;
                            System.out.println("Credenciais incorretas. Tentativas restantes: " + attempts);
                        }
                    }
                    if (!loggedIn) {
                        System.out.println("Número de tentativas excedido. Voltando ao menu.");
                    }
                    break;
                case 2:
                    System.out.println("Funcionalidade em breve");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
}
}