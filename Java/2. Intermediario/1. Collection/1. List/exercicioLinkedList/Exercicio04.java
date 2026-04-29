// ## Exercício 4 — Iterator

// Dada a lista abaixo, use `Iterator` para:

// ```java
// LinkedList<String> emails = new LinkedList<>();
// emails.add("jeff@cerne.com");
// emails.add("spam@temp.com");
// emails.add("ana@cerne.com");
// emails.add("lixo@temp.com");
// emails.add("bob@cerne.com");
// ```

// 1. Itere com `Iterator` e imprima todos os emails
// 2. Use `it.remove()` para remover os que terminam com `"@temp.com"` durante a iteração
// 3. Imprima a lista final
// 4. Use `descendingIterator()` para imprimir os emails de trás para frente

import java.util.Iterator;
import java.util.LinkedList;

public class Exercicio04 {
    public static void main(String[] args) {
        
        LinkedList<String> emails = new LinkedList<>();
        emails.add("jeff@cerne.com");
        emails.add("spam@temp.com");
        emails.add("ana@cerne.com");
        emails.add("lixo@temp.com");
        emails.add("bob@cerne.com");

        System.out.println("Todos os emails:");
        Iterator<String> it = emails.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nRemovendo emails de @temp.com:");
        it = emails.iterator();
        while (it.hasNext()) {
            String email = it.next();
            if (email.endsWith("@temp.com")) {
                it.remove();
            }
        }

        System.out.println("Lista final:");
        for (String email : emails) {
            System.out.println(email);
        }

        System.out.println("\nEmails de trás para frente:");
        Iterator<String> descendingIt = emails.descendingIterator();
        while (descendingIt.hasNext()) {
            System.out.println(descendingIt.next());
        }
    }
}
