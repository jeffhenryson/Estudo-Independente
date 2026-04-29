// ## Exercício 3 — Remoção

// ```java
// List<String> emails = new ArrayList<>();
// emails.add("jeff@cerne.com");
// emails.add("ana@cerne.com");
// emails.add("trial@temp.com");
// emails.add("bob@cerne.com");
// emails.add("spam@temp.com");
// emails.add("carlos@cerne.com");
// ```

// 1. Remova o email do índice 0
// 2. Remova `"trial@temp.com"` por valor
// 3. Use `removeIf()` para remover todos que terminam com `"@temp.com"`
// 4. Imprima a lista após cada remoção
// 5. Limpe a lista com `clear()` e confirme que está vazia
// ---

import java.util.ArrayList;
import java.util.List;

public class Exercicio03 {
    public static void main(String[] args) {
        
        List<String> emails = new ArrayList<>();
        emails.add("jeff@cerne.com");
        emails.add("ana@cerne.com");
        emails.add("trial@temp.com");
        emails.add("bob@cerne.com");
        emails.add("spam@temp.com");
        emails.add("carlos@cerne.com");

        // 1. Remova o email do índice 0
        System.out.println("Antes da remoção do índice 0: " + emails);
        emails.remove(0);
        System.out.println("Depois da remoção do índice 0: " + emails);

        // 2. Remova "trial@temp.com" por valor
        System.out.println("Antes da remoção de 'trial@temp.com': " + emails);
        emails.remove("trial@temp.com");
        System.out.println("Depois da remoção de 'trial@temp.com': " + emails);

        // 3. Use removeIf() para remover todos que terminam com "@temp.com"
        System.out.println("Antes da remoção de emails que terminam com '@temp.com': " + emails);
        emails.removeIf(email -> email.endsWith("@temp.com"));
        System.out.println("Depois da remoção de emails que terminam com '@temp.com': " + emails);

        // 4. Limpe a lista com clear() e confirme que está vazia
        System.out.println("Antes de limpar a lista: " + emails);
        emails.clear();
        System.out.println("Depois de limpar a lista: " + emails);
        System.out.println("A lista está vazia? " + emails.isEmpty());
    }
}
