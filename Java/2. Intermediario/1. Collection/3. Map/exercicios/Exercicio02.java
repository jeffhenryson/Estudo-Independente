// ## Exercício 2 — LinkedHashMap e TreeMap

// Use os mesmos dados do exercício anterior nos dois tipos:

// ```java
// // dados:
// // "pro" → 149.90
// // "starter" → 49.90
// // "enterprise" → 499.90
// // "basic" → 29.90
// ```

// 1. Insira em `LinkedHashMap` e imprima — observe a ordem de inserção
// 2. Insira em `TreeMap` e imprima — observe a ordenação por chave
// 3. No `TreeMap`, use `firstKey()` e `lastKey()`
// 4. Use `headMap()` para listar planos que vêm antes de `"pro"` alfabeticamente
// 5. Use `tailMap()` para listar planos a partir de `"pro"`
// 6. Explique com comentários a diferença de cada um

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Exercicio02 {
    public static void main(String[] args) {

        LinkedHashMap<String, Double> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("pro", 149.90);
        linkedHashMap.put("starter", 49.90);
        linkedHashMap.put("enterprise", 499.90);
        linkedHashMap.put("basic", 29.90);
        System.out.println("LinkedHashMap: " + linkedHashMap);

        TreeMap<String, Double> treeMap = new TreeMap<>();
        treeMap.put("pro", 149.90);
        treeMap.put("starter", 49.90);
        treeMap.put("enterprise", 499.90);
        treeMap.put("basic", 29.90);
        System.out.println("TreeMap: " + treeMap);

        System.out.println("First Key in TreeMap: " + treeMap.firstKey());
        System.out.println("Last Key in TreeMap: " + treeMap.lastKey());

        System.out.println("Head Map (before 'pro'): " + treeMap.headMap("pro"));

        System.out.println("Tail Map (from 'pro'): " + treeMap.tailMap("pro"));

        // Diferença:
        // LinkedHashMap mantém a ordem que foi inserido os dados nos elementos.
        // TreeMap ordena os elementos com base nas chaves, seguindo a ordem natural (alfabética para Strings).
    }
}
