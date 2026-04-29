// ## Exercício 1 — Operações nas pontas

// Crie uma `LinkedList<String>` de tarefas e:

// 1. Adicione 3 tarefas normalmente com `add()`
// 2. Adicione uma tarefa urgente no início com `addFirst()`
// 3. Adicione uma tarefa de baixa prioridade no final com `addLast()`
// 4. Imprima o primeiro e o último com `peekFirst()` e `peekLast()`
// 5. Remova o primeiro com `pollFirst()` e o último com `pollLast()`
// 6. Imprima a lista após as remoções

import java.util.LinkedList;

public class Exercicio01 {

    public static void main(String[] args) {

        LinkedList<String> tarefas = new LinkedList<>();

        tarefas.add("Tarefa 1");
        tarefas.add("Tarefa 2");
        tarefas.add("Tarefa 3");

        tarefas.addFirst("Tarefa Urgente");

        tarefas.addLast("Tarefa Baixa Prioridade");

        System.out.println("Primeira tarefa: " + tarefas.peekFirst());
        System.out.println("Última tarefa: " + tarefas.peekLast());

        String primeiraRemovida = tarefas.pollFirst();
        String ultimaRemovida = tarefas.pollLast();

        System.out.println("Tarefa removida do início: " + primeiraRemovida);
        System.out.println("Tarefa removida do final: " + ultimaRemovida);

        System.out.println("Lista de tarefas após remoções: " + tarefas);
    }
}