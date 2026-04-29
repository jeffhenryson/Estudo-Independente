// ## Exercício 2 — Busca e verificação
// 
// Dado o código abaixo, complete os métodos:
// 
// ```java
// List<String> planos = new ArrayList<>();
// planos.add("starter");
// planos.add("pro");
// planos.add("enterprise");
// planos.add("pro"); // duplicata intencional
// ```
// 
// 1. Verifique se `"pro"` existe na lista
// 2. Encontre o índice da **primeira** ocorrência de `"pro"`
// 3. Encontre o índice da **última** ocorrência de `"pro"`
// 4. Verifique se `"vip"` existe
// 5. Verifique se a lista está vazia
// 6. Imprima o resultado de cada verificação com uma mensagem clara

import java.util.ArrayList;
import java.util.List;

public class Exercicio02 {
    public static void main(String[] args) {
        
        List<String> planos = new ArrayList<>();
        planos.add("starter");
        planos.add("pro");
        planos.add("enterprise");
        planos.add("pro"); // duplicata intencional

        // 1. Verifique se "pro" existe na lista
        boolean existePro = planos.contains("pro");
        System.out.println("Existe 'pro' na lista? " + existePro);

        // 2. Encontre o índice da primeira ocorrência de "pro"
        int indicePrimeiraPro = planos.indexOf("pro");
        System.out.println("Índice da primeira ocorrência de 'pro': " + indicePrimeiraPro);

        // 3. Encontre o índice da última ocorrência de "pro"
        int indiceUltimaPro = planos.lastIndexOf("pro");
        System.out.println("Índice da última ocorrência de 'pro': " + indiceUltimaPro);

        // 4. Verifique se "vip" existe
        boolean existeVip = planos.contains("vip");
        System.out.println("Existe 'vip' na lista? " + existeVip);

        // 5. Verifique se a lista está vazia
        boolean estaVazia = planos.isEmpty();
        System.out.println("A lista está vazia? " + estaVazia);
    }
}
