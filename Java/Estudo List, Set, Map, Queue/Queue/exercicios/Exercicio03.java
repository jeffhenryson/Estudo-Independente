// ## Exercício 3 — PriorityQueue com números

// 1. Crie uma `PriorityQueue<Integer>` padrão
// 2. Adicione os valores: `50, 10, 80, 30, 20, 70`
// 3. Imprima o menor sem remover com `peek()`
// 4. Remova e imprima todos com `poll()` — observe a ordem
// 5. Crie uma segunda `PriorityQueue` com `Comparator.reverseOrder()`
// 6. Adicione os mesmos valores e remova todos — observe a ordem reversa

import java.util.Comparator;
import java.util.PriorityQueue;

public class Exercicio03 {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(10);
        pq.add(80);
        pq.add(30);
        pq.add(20);
        pq.add(70);

        System.out.println("Menor valor (peek): " + pq.peek()); 

        System.out.println("Removendo valores (poll):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        PriorityQueue<Integer> reversePq = new PriorityQueue<>(Comparator.reverseOrder());
        reversePq.add(50);
        reversePq.add(10);
        reversePq.add(80);
        reversePq.add(30);
        reversePq.add(20);
        reversePq.add(70);

        System.out.println("Removendo valores em ordem reversa (poll):");
        while (!reversePq.isEmpty()) {
            System.out.println(reversePq.poll());
        }
    }
}
