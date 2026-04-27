// ## Exercício 2 — Fila (FIFO)
// 
// Simule uma fila de atendimento de suporte do **Cerne**:
// 
// 1. Crie uma `Queue<String>` usando `LinkedList`
// 2. Adicione 5 tickets com `offer()`
// 3. Imprima o próximo ticket sem remover com `peek()`
// 4. Processe todos os tickets com `poll()` dentro de um `while`
// 5. Após esvaziar, tente chamar `peek()` e `poll()` e imprima o resultado
// 6. Mostre por que `poll()` é mais seguro que `remove()` quando a fila está vazia

import java.util.LinkedList;
import java.util.Queue;

public class Exercicio02 {
    public static void main(String[] args) {

        Queue<String> filaSuporte = new LinkedList<>();

        filaSuporte.offer("Ticket 1: Problema de login");
        filaSuporte.offer("Ticket 2: Erro no sistema");
        filaSuporte.offer("Ticket 3: Dúvida sobre funcionalidade");
        filaSuporte.offer("Ticket 4: Solicitação de atualização");
        filaSuporte.offer("Ticket 5: Problema de desempenho");

         System.out.println("Próximo ticket a ser atendido: " + filaSuporte.peek());

        System.out.println("\nProcessando tickets:");
        while (!filaSuporte.isEmpty()) {
            String ticket = filaSuporte.poll();
            System.out.println("Atendendo: " + ticket);
        }

        System.out.println("\nFila vazia:");
        System.out.println("Peek: " + filaSuporte.peek()); // Deve retornar null
        System.out.println("Poll: " + filaSuporte.poll()); // Deve retornar null

        try {
            filaSuporte.remove(); // Isso lançará NoSuchElementException
        } catch (Exception e) {
            System.out.println("\nUsar remove() em uma fila vazia lança uma exceção: " + e);
        }
    }
}
