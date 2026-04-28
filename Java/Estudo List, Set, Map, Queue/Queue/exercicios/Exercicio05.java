// ## Exercício 5 — ArrayDeque como Deque

// Implemente um histórico de navegação de páginas do sistema **Cerne**:

// 1. Crie um `Deque<String>` usando `ArrayDeque`
// 2. Simule a navegação adicionando páginas com `offerLast()`:
//    - `"Dashboard"` → `"Campanhas"` → `"Nova Campanha"` → `"Revisão"` → `"Publicar"`
// 3. Imprima a página atual com `peekLast()`
// 4. Implemente voltar — remove a página atual com `pollLast()` e imprime onde está agora
// 5. Volte 2 vezes e imprima a página atual após cada volta
// 6. Adicione uma nova página e imprima o histórico completo iterando do início ao fim

import java.util.ArrayDeque;
import java.util.Deque;

public class Exercicio05 {
    public static void main(String[] args) {
        Deque<String> historico = new ArrayDeque<>();

        historico.offerLast("Dashboard");
        historico.offerLast("Campanhas");
        historico.offerLast("Nova Campanha");
        historico.offerLast("Revisão");
        historico.offerLast("Publicar");

        System.out.println("Página atual: " + historico.peekLast());

        historico.pollLast();
        System.out.println("Página após voltar: " + historico.peekLast());

        historico.pollLast();
        System.out.println("Página após voltar novamente: " + historico.peekLast());

        historico.offerLast("Configurações");
        System.out.println("Histórico completo:");
        for (String pagina : historico) {
            System.out.println(" - " + pagina);
        }
    }
}
