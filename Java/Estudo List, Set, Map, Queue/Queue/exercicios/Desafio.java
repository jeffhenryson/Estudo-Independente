// ## Exercício 6 — Desafio

// Construa um sistema de processamento de campanhas do **Cerne** com múltiplas filas:

// **Estrutura:**
// ```java
// class Campanha {
//     String nome;
//     String plataforma;
//     int prioridade;      // 1 = urgente, 2 = normal, 3 = baixa
//     String status;       // "aguardando", "processando", "concluída", "erro"
// }
// ```

// **Filas:**
// - `PriorityQueue<Campanha>` → fila de entrada ordenada por prioridade
// - `Queue<Campanha>` → fila de processamento (ArrayDeque)
// - `Deque<Campanha>` → histórico de concluídas (últimas 5)

// **Menu `do-while`:**
// 1. Submeter campanha → lê dados, adiciona na `PriorityQueue`
// 2. Iniciar processamento → move a próxima da `PriorityQueue` para a fila de processamento
// 3. Concluir campanha → remove da fila de processamento, adiciona no histórico
//    - Histórico mantém só as últimas 5 — se passar de 5, remove a mais antiga com `pollFirst()`
// 4. Ver próxima da fila de entrada → `peek()` na `PriorityQueue`
// 5. Ver histórico de concluídas → itera o `Deque` do mais recente ao mais antigo com `descendingIterator()`
// 6. Estatísticas:
//    - Total na fila de entrada
//    - Total em processamento
//    - Total no histórico
// 0. Sair

import java.util.Queue;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayDeque;

public class Desafio {
    public static void main(String[] args) {

        class Campanha {
            String nome;
            String plataforma;
            int prioridade;      // 1 = urgente, 2 = normal, 3 = baixa
            String status;       // "aguardando", "processando", "concluída", "erro"

            public Campanha(String nome, String plataforma, int prioridade) {
                this.nome = nome;
                this.plataforma = plataforma;
                this.prioridade = prioridade;
                this.status = "aguardando";
            }

            @Override
            public String toString() {
                return String.format("Campanha: %s | Plataforma: %s | Prioridade: %d | Status: %s", nome, plataforma, prioridade, status);
            }
        }

        PriorityQueue<Campanha> filaEntrada = new PriorityQueue<>((c1, c2) -> Integer.compare(c1.prioridade, c2.prioridade));
        Queue<Campanha> filaProcessamento = new ArrayDeque<>();
        Deque<Campanha> historicoConcluidas = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("=== Menu ===");
            System.out.println("1. Submeter campanha");
            System.out.println("2. Iniciar processamento");
            System.out.println("3. Concluir campanha");
            System.out.println("4. Ver próxima da fila de entrada");
            System.out.println("5. Ver histórico de concluídas");
            System.out.println("6. Estatísticas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Submeter campanha
                    System.out.print("Nome da campanha: ");
                    String nome = scanner.nextLine();
                    System.out.print("Plataforma: ");
                    String plataforma = scanner.nextLine();
                    System.out.print("Prioridade (1-3): ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Campanha campanha = new Campanha(nome, plataforma, prioridade);
                    filaEntrada.add(campanha);
                    System.out.println("Campanha submetida com sucesso!");
                    break;
                case 2:
                    // Iniciar processamento
                    Campanha processarCampanha = filaEntrada.poll();
                    if (processarCampanha != null) {
                        processarCampanha.status = "processando";
                        filaProcessamento.add(processarCampanha);
                    } else {
                        System.out.println("Fila de entrada vazia!");
                    }
                    break;
                case 3:
                    // Concluir campanha
                    Campanha concluirCampanha = filaProcessamento.poll();
                    if (concluirCampanha != null) {
                        concluirCampanha.status = "concluída";
                        historicoConcluidas.addFirst(concluirCampanha);
                        if (historicoConcluidas.size() > 5) {
                            historicoConcluidas.pollLast();
                        }
                    } else {
                        System.out.println("Nenhuma campanha em processamento!");
                    }
                    break;
                case 4:
                    // Ver próxima da fila de entrada
                    Campanha proximaCampanha = filaEntrada.peek();
                    if (proximaCampanha != null) {
                        System.out.println(proximaCampanha);
                    } else {
                        System.out.println("Fila de entrada vazia!");
                    }
                    break;
                case 5:
                    // Ver histórico de concluídas
                    if (historicoConcluidas.isEmpty()) {
                        System.out.println("Nenhuma campanha concluída!");
                    } else {
                        Iterator<Campanha> iterator = historicoConcluidas.descendingIterator();
                        while (iterator.hasNext()) {
                            System.out.println(iterator.next());
                        }
                    }
                    break;
                case 6:
                    // Estatísticas
                    System.out.println("Total na fila de entrada: " + filaEntrada.size());
                    System.out.println("Total em processamento: " + filaProcessamento.size());
                    System.out.println("Total no histórico: " + historicoConcluidas.size());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
