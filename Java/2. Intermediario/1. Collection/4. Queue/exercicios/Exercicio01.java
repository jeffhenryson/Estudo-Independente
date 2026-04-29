// ## Exercício 1 — Queue básica com ArrayDeque

// Simule uma fila de envio de emails do **Cerne**:

// 1. Crie uma `Queue<String>` usando `ArrayDeque`
// 2. Adicione 5 emails com `offer()`
// 3. Imprima o próximo sem remover com `peek()`
// 4. Processe todos com `poll()` dentro de um `while`
// 5. Após esvaziar, chame `peek()` e `poll()` e imprima os resultados
// 6. Mostre com comentários por que `poll()` é mais seguro que `remove()`

import java.util.Queue;
import java.util.ArrayDeque;

public class Exercicio01 {
    public static void main(String[] args) {

        Queue<String> emailQueue = new ArrayDeque<>();

        emailQueue.offer("email1@cerne.com");
        emailQueue.offer("email2@cerne.com");
        emailQueue.offer("email3@cerne.com");
        emailQueue.offer("email4@cerne.com");
        emailQueue.offer("email5@cerne.com");

        System.out.println("Próximo email: " + emailQueue.peek());

        while (!emailQueue.isEmpty()) {
            System.out.println("Processando email: " + emailQueue.poll());
        }

        System.out.println("Resultado de peek() após esvaziar: " + emailQueue.peek());
        System.out.println("Resultado de poll() após esvaziar: " + emailQueue.poll());

        // 6. Mostre com comentários por que poll() é mais seguro que remove()
        // poll() retorna null se a fila estiver vazia, enquanto remove() lança uma exceção
    }
}