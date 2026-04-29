// ## Exercício 4 — PriorityQueue com objetos

// Crie um sistema de atendimento de suporte do **Cerne** com prioridade:

// ```java
// class Ticket {
//     String id;
//     String cliente;
//     int prioridade; // 1 = crítico, 2 = alto, 3 = normal
// }
// ```

// 1. Crie uma `PriorityQueue<Ticket>` ordenada por `prioridade`
// 2. Adicione 5 tickets com prioridades variadas fora de ordem
// 3. Processe todos com `poll()` e imprima na ordem de atendimento:
// ```
// Atendendo: ticket-002 | Cliente: Cerne | Prioridade: 1 (crítico)
// Atendendo: ticket-005 | Cliente: Ana   | Prioridade: 1 (crítico)
// Atendendo: ticket-001 | Cliente: Jeff  | Prioridade: 2 (alto)
// ...
// ```
// 4. Use um método `classificar(int prioridade)` que retorna `"crítico"`, `"alto"` ou `"normal"`

import java.util.PriorityQueue;

public class Exercicio04 {
    public static void main(String[] args) {

        class Ticket {
            String id;
            String cliente;
            int prioridade;

            public Ticket(String id, String cliente, int prioridade) {
                this.id = id;
                this.cliente = cliente;
                this.prioridade = prioridade;
            }

            public String classificar(int prioridade) {
                switch (prioridade) {
                    case 1: return "crítico";
                    case 2: return "alto";
                    case 3: return "normal";
                    default: return "desconecido";
                }
            }
        }

        PriorityQueue<Ticket> filaAtendimento = new PriorityQueue<>(
            (t1, t2) -> Integer.compare(t1.prioridade, t2.prioridade)
        );

        filaAtendimento.add(new Ticket("ticket-001", "Jeff", 2));
        filaAtendimento.add(new Ticket("ticket-002", "Cerne", 1));
        filaAtendimento.add(new Ticket("ticket-003", "Maria", 3));
        filaAtendimento.add(new Ticket("ticket-004", "Carlos", 2));
        filaAtendimento.add(new Ticket("ticket-005", "Ana", 1));

        while (!filaAtendimento.isEmpty()) {
            Ticket ticket = filaAtendimento.poll();
            System.out.printf("Atendendo: %s | Cliente: %s | Prioridade: %d (%s)%n",
                ticket.id, ticket.cliente, ticket.prioridade, ticket.classificar(ticket.prioridade));
        }
    }
}
