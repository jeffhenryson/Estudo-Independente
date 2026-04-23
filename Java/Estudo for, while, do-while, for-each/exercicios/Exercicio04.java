// ## Exercício 4 — for-each

// Dado o array abaixo, use `for-each` para:

// 1. Imprimir todos os nomes
// 2. Contar quantos nomes têm mais de 4 letras
// 3. Imprimir apenas os nomes que começam com a letra `"A"` (dica: `.startsWith("A")`)

// String[] nomes = {"Ana", "Bruno", "Alice", "Jo", "Amanda", "Bia", "Alexandre"};

public class Exercicio04 {
    public static void main(String[] args) {
        
        String[] nomes = {"Ana", "Bruno", "Alice", "Jo", "Amanda", "Bia", "Alexandre"};

        System.out.println("Nomes:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
        
        int count = 0;
        
        for (String nome : nomes) {
            if (nome.length() > 4) {
                count++;
            }
        
        }
        System.out.println("\nQuantidade de nomes com mais de 4 letras: " + count);
        System.out.println("\nNomes que começam com 'A':");
        
        for (String nome : nomes) {
            if (nome.startsWith("A")) {
                System.out.println(nome);
            }
        }
    }
}