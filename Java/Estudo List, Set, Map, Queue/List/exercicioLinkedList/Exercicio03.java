// ## Exercício 3 — Pilha (LIFO)
// 
// Implemente um histórico de ações de uma campanha usando pilha:
// 
// 1. Crie uma `LinkedList<String>` funcionando como pilha
// 2. Registre 5 ações com `push()`:
//    - `"Criou campanha"`
//    - `"Definiu orçamento R$ 1000"`
//    - `"Adicionou público-alvo"`
//    - `"Ativou campanha"`
//    - `"Alterou orçamento R$ 1500"`
// 3. Imprima a ação no topo com `peek()`
// 4. Implemente um loop que desfaz ações com `pop()` até a pilha esvaziar
// 5. Imprima cada ação desfeita no formato: `"Desfazendo: [ação]"`

import java.util.LinkedList;

public class Exercicio03 {
    public static void main(String[] args) {
        
        LinkedList<String> historicoAcoes = new LinkedList<>();

        historicoAcoes.push("Criou campanha");
        historicoAcoes.push("Definiu orçamento R$ 1000");
        historicoAcoes.push("Adicionou público-alvo");
        historicoAcoes.push("Ativou campanha");
        historicoAcoes.push("Alterou orçamento R$ 1500");

        System.out.println("Ação no topo da pilha: " + historicoAcoes.peek());

        System.out.println("\nDesfazendo ações:");
        while (!historicoAcoes.isEmpty()) {
            String acaoDesfeita = historicoAcoes.pop();
            System.out.println("Desfazendo: " + acaoDesfeita);
        }

    }    
}
