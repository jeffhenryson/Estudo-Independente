// ## Exercício 6 — Desafio

// Crie um simulador de login simples:

// 1. Defina constantes `USUARIO_CORRETO` e `SENHA_CORRETA`
// 2. Leia usuário e senha via `Scanner`
// 3. Use condicionais para cobrir os casos:
//     - Usuário correto + senha correta → `"Login efetuado com sucesso"`
//     - Usuário correto + senha errada → `"Senha incorreta"`
//     - Usuário errado → `"Usuário não encontrado"`
// 4. Use `.equals()` para comparar as Strings
// 5. **Bônus:** use uma variável `tentativas` e bloqueie após 3 tentativas erradas com um loop `while` (pode deixar para depois de estudar loops se preferir)

import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {

        final String USUARIO_CORRETO = "admin";
        final String SENHA_CORRETA = "1234";

        Scanner scanner = new Scanner(System.in);
        
        int tentativas = 0;
        boolean bloqueado = false;

        while (tentativas < 3 && !bloqueado) {
            System.out.print("Digite o usuário: ");
            String usuario = scanner.nextLine();

            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();

            if (usuario.equals(USUARIO_CORRETO)) {
                if (senha.equals(SENHA_CORRETA)) {
                    System.out.println("Login efetuado com sucesso");
                    break;
                } else {
                    System.out.println("Senha incorreta");
                    tentativas++;
                }
            } else {
                System.out.println("Usuário não encontrado");
                tentativas++;
            }

            if (tentativas >= 3) {
                bloqueado = true;
                System.out.println("Usuário bloqueado após 3 tentativas erradas.");
            }
        }

        scanner.close();
    }
}
