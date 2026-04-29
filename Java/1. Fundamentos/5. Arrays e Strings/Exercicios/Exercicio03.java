// ## Exercício 3 — Strings básico

// Dado o texto:

// ```java
// String texto = "  Java é uma linguagem orientada a objetos  ";
// ```

// 1. Imprima o texto sem espaços nas pontas
// 2. Imprima em maiúsculas
// 3. Imprima o tamanho **sem** os espaços das pontas
// 4. Verifique se contém a palavra `"orientada"`
// 5. Substitua `"Java"` por `"Python"` e imprima
// 6. Imprima a substring `"linguagem"`

public class Exercicio03 {
    public static void main(String[] args) {
        
        String texto = "  Java é uma linguagem orientada a objetos  ";

        // 1. Imprimir o texto sem espaços nas pontas
        System.out.println(texto.trim());

        // 2. Imprimir em maiúsculas
        System.out.println(texto.toUpperCase());

        // 3. Imprimir o tamanho **sem** os espaços das pontas
        System.out.println(texto.trim().length());

        // 4. Verificar se contém a palavra `"orientada"`
        System.out.println(texto.contains("orientada"));

        // 5. Substituir `"Java"` por `"Python"` e imprimir
        System.out.println(texto.replace("Java", "Python"));

        // 6. Imprimir a substring `"linguagem"`
        int startIndex = texto.indexOf("linguagem");
        int endIndex = startIndex + "linguagem".length();
        System.out.println(texto.substring(startIndex, endIndex));
    }
}
