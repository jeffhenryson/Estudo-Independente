// ## Exercício 5 — Conversão List ↔ Set

// ```java
// List<String> emails = new ArrayList<>(Arrays.asList(
//     "jeff@cerne.com",
//     "ana@cerne.com",
//     "jeff@cerne.com",
//     "bob@cerne.com",
//     "ana@cerne.com",
//     "carlos@cerne.com"
// ));
// ```

// 1. Imprima o tamanho original da List com duplicatas
// 2. Converta para `HashSet` para remover duplicatas
// 3. Converta para `LinkedHashSet` e compare — a ordem de inserção é mantida?
// 4. Converta o Set de volta para List
// 5. Ordene a List final com `Collections.sort()`
// 6. Imprima a List final e o tamanho

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Exercicio05 {
    public static void main(String[] args) {

        List<String> emails = new ArrayList<>(Arrays.asList(
        "jeff@cerne.com",
        "ana@cerne.com",
        "jeff@cerne.com",
        "bob@cerne.com",
        "ana@cerne.com",
        "carlos@cerne.com"
        )); 

        System.out.println("Tamanho original da List: " + emails.size()); // 6

        Set<String> emailSet = new HashSet<>(emails);
        System.out.println("Tamanho do HashSet (sem duplicatas): " + emailSet.size());

        Set<String> emailLinkedHashSet = new LinkedHashSet<>(emails);
        System.out.println("Tamanho do LinkedHashSet (sem duplicatas): " + emailLinkedHashSet.size()); 
        System.out.println("Ordem de inserção mantida no LinkedHashSet? " + emailLinkedHashSet); 

        List<String> emailListFinal = new ArrayList<>(emailLinkedHashSet);

        Collections.sort(emailListFinal);
        System.out.println("List final ordenada: " + emailListFinal);
        System.out.println("Tamanho da List final: " + emailListFinal.size());

    }
}
