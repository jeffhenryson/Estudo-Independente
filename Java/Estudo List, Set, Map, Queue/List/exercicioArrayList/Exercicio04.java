// ## Exercício 4 — Ordenação
// 
// ```java
// List<String> nomes = new ArrayList<>();
// nsomes.add("Carlos");
// nomes.add("Ana");
// nomes.add("Bruno");
// nomes.add("Amanda");
// nomes.add("Diego");
// 
// List<Double> precos = new ArrayList<>();
// precos.add(299.90);
// precos.add(49.90);
// precos.add(149.90);
// precos.add(499.90);
// precos.add(99.90);
// ```
// 
// 1. Ordene `nomes` em ordem alfabética e imprima
// 2. Ordene `nomes` em ordem reversa e imprima
// 3. Ordene `precos` em ordem crescente e imprima
// 4. Ordene `precos` em ordem decrescente e imprima

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercicio04 {
        public static void main(String[] args) {
            
            List<String> nomes = new ArrayList<>();
            nomes.add("Carlos");
            nomes.add("Ana");
            nomes.add("Bruno");
            nomes.add("Amanda");
            nomes.add("Diego");
    
            List<Double> precos = new ArrayList<>();
            precos.add(299.90);
            precos.add(49.90);
            precos.add(149.90);
            precos.add(499.90);
            precos.add(99.90);
    
            // Ordenar nomes em ordem alfabética
            Collections.sort(nomes);
            System.out.println("Nomes em ordem alfabética: " + nomes);
    
            // Ordenar nomes em ordem reversa
            Collections.sort(nomes, Collections.reverseOrder());
            System.out.println("Nomes em ordem reversa: " + nomes);
    
            // Ordenar preços em ordem crescente
            Collections.sort(precos);
            System.out.println("Preços em ordem crescente: " + precos);
    
            // Ordenar preços em ordem decrescente
            Collections.sort(precos, Collections.reverseOrder());
            System.out.println("Preços em ordem decrescente: " + precos);
        }
}
