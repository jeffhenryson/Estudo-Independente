// ## Exercício 6 — Desafio

// Construa um sistema de gerenciamento de campanhas do **Cerne** com duas filas:

// **Estrutura:**
// - `Queue<String>` → fila de campanhas aguardando aprovação
// - `LinkedList<String>` → campanhas aprovadas (funciona como histórico/pilha)

// **Menu `do-while`:**
// 1. Submeter campanha para aprovação → adiciona na fila com `offer()`
// 2. Aprovar próxima campanha → remove da fila com `poll()` e empilha no histórico com `push()`
// 3. Ver próxima campanha para aprovação → `peek()` na fila
// 4. Desfazer última aprovação → `pop()` do histórico e devolve para o início da fila com `addFirst()`
// 5. Listar fila de aprovação → itera e imprime todas sem remover
// 6. Listar histórico de aprovadas → itera e imprime todas
// 0. Sair

// **Regras:**
// - Opção 2 bloqueia se a fila estiver vazia
// - Opção 4 bloqueia se o histórico estiver vazio
// - Opção 3 informa se não há campanhas aguardando

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Queue<String> filaAprovacao = new LinkedList<>();
        LinkedList<String> historicoAprovadas = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n=== Sistema de Gerenciamento de Campanhas ===");
            System.out.println("1. Submeter campanha para aprovação");
            System.out.println("2. Aprovar próxima campanha");
            System.out.println("3. Ver próxima campanha para aprovação");
            System.out.println("4. Desfazer última aprovação");
            System.out.println("5. Listar fila de aprovação");
            System.out.println("6. Listar histórico de aprovadas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da campanha: ");
                    String campanha = scanner.nextLine();
                    filaAprovacao.offer(campanha);
                    System.out.println("Campanha submetida para aprovação.");
                    break;
                case 2:
                    if (!filaAprovacao.isEmpty()) {
                        String aprovada = filaAprovacao.poll();
                        historicoAprovadas.push(aprovada);
                        System.out.println("Campanha aprovada: " + aprovada);
                    } else {
                        System.out.println("Nenhuma campanha aguardando aprovação.");
                    }
                    break;
                case 3:
                    if (!filaAprovacao.isEmpty()) {
                        System.out.println("Próxima campanha para aprovação: " + filaAprovacao.peek());
                    } else {
                        System.out.println("Nenhuma campanha aguardando aprovação.");
                    }
                    break;
                case 4:
                    if (!historicoAprovadas.isEmpty()) {
                        String desfeita = historicoAprovadas.pop();
                        filaAprovacao.add(desfeita);
                        System.out.println("Última aprovação desfeita: " + desfeita);
                    } else {
                        System.out.println("Nenhuma campanha aprovada para desfazer.");
                    }
                    break;
                case 5:
                    if (!filaAprovacao.isEmpty()) {
                        System.out.println("Fila de aprovação:");
                        for (String s : filaAprovacao) {
                            System.out.println("- " + s);
                        }
                    } else {
                        System.out.println("Fila de aprovação vazia.");
                    }
                    break;
                case 6:
                    if (!historicoAprovadas.isEmpty()) {
                        System.out.println("Histórico de aprovadas:");
                        for (String s : historicoAprovadas) {
                            System.out.println("- " + s);
                        }
                    } else {
                        System.out.println("Histórico de aprovadas vazio.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
