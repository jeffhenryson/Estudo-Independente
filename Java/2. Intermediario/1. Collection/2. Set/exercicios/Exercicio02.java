// ## Exercício 2 — Comparando as três implementações

// Use o mesmo conjunto de dados nos três tipos de Set e observe as diferenças:

// ```java
// String[] plataformas = {"Meta Ads", "Google Ads", "TikTok Ads", "Meta Ads", "Google Ads", "LinkedIn Ads"};
// ```

// 1. Insira em `HashSet`, `LinkedHashSet` e `TreeSet`
// 2. Imprima os três e observe a diferença de ordem
// 3. Confirme que todos têm o mesmo `size()`
// 4. Explique com comentários no código por que cada um imprime diferente

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Exercicio02 {
    public static void main(String[] args) {

        String[] plataformas = {"Meta Ads", "Google Ads", "TikTok Ads", "Meta Ads", "Google Ads", "LinkedIn Ads"};

        // HashSet: 
        HashSet<String> hashSet = new HashSet<>();
        for (String plataforma : plataformas) {
            hashSet.add(plataforma);
        }
        System.out.println("HashSet: " + hashSet);

        // LinkedHashSet:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (String plataforma : plataformas) {
            linkedHashSet.add(plataforma);
        }
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // TreeSet: 
        TreeSet<String> treeSet = new TreeSet<>();
        for (String plataforma : plataformas) {
            treeSet.add(plataforma);
        }
        System.out.println("TreeSet: " + treeSet);

        // Todos os sets têm o mesmo tamanho, pois os duplicados são ignorados
        System.out.println("Tamanho do HashSet: " + hashSet.size());
        System.out.println("Tamanho do LinkedHashSet: " + linkedHashSet.size());
        System.out.println("Tamanho do TreeSet: " + treeSet.size());
    }
}