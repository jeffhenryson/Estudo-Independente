// ## Desafio

// Construa um sistema de controle de acesso do **Cerne** usando Sets:

// **Estrutura:**
// - `Set<String>` de emails cadastrados — evita duplicatas
// - `Set<String>` de admins — subconjunto dos cadastrados
// - `Set<String>` de usuários bloqueados

// **Menu `do-while`:**
// 1. Cadastrar usuário → adiciona email no set de cadastrados
//    - Bloqueia se email já existir
//    - Informa se foi adicionado com o retorno do `add()`
// 2. Promover a admin → move email para o set de admins
//    - Só promove se o email estiver cadastrado
// 3. Bloquear usuário → adiciona no set de bloqueados
//    - Só bloqueia se estiver cadastrado e não for admin
// 4. Verificar acesso → dado um email informa:
//    - Se está bloqueado → `"Acesso negado"`
//    - Se é admin → `"Acesso admin"`
//    - Se é cadastrado → `"Acesso padrão"`
//    - Se não existe → `"Usuário não encontrado"`
// 5. Exibir estatísticas:
//    - Total de usuários cadastrados
//    - Lista de admins (use `LinkedHashSet` para manter ordem)
//    - Lista de bloqueados
//    - Usuários ativos (cadastrados - bloqueados) usando operação de conjunto
// 0. Sair

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Desafio {
    public static void main(String[] args) {
        
        Set<String> cadastrados = new HashSet<>();
        Set<String> admins = new LinkedHashSet<>();
        Set<String> bloqueados = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Promover a admin");
            System.out.println("3. Bloquear usuário");
            System.out.println("4. Verificar acesso");
            System.out.println("5. Exibir estatísticas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o email para cadastro: ");
                    String emailCadastro = scanner.nextLine();
                    if (cadastrados.add(emailCadastro)) {
                        System.out.println("Usuário cadastrado com sucesso.");
                    } else {
                        System.out.println("Email já cadastrado.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o email para promover a admin: ");
                    String emailAdmin = scanner.nextLine();
                    if (cadastrados.contains(emailAdmin)) {
                        admins.add(emailAdmin);
                        System.out.println("Usuário promovido a admin.");
                    } else {
                        System.out.println("Email não encontrado para promoção.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o email para bloquear: ");
                    String emailBloqueio = scanner.nextLine();
                    if (cadastrados.contains(emailBloqueio) && !admins.contains(emailBloqueio)) {
                        bloqueados.add(emailBloqueio);
                        System.out.println("Usuário bloqueado.");
                    } else {
                        System.out.println("Email não encontrado ou é um admin, não pode ser bloqueado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o email para verificar acesso: ");
                    String emailVerificacao = scanner.nextLine();
                    if (bloqueados.contains(emailVerificacao)) {
                        System.out.println("Acesso negado.");
                    } else if (admins.contains(emailVerificacao)) {
                        System.out.println("Acesso admin.");
                    } else if (cadastrados.contains(emailVerificacao)) {
                        System.out.println("Acesso padrão.");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Estatísticas:");
                    System.out.println("Total de usuários cadastrados: " + cadastrados.size());
                    System.out.println("Lista de admins: " + admins);
                    System.out.println("Lista de bloqueados: " + bloqueados);
                    Set<String> ativos = new HashSet<>(cadastrados);
                    ativos.removeAll(bloqueados);
                    System.out.println("Usuários ativos: " + ativos);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
