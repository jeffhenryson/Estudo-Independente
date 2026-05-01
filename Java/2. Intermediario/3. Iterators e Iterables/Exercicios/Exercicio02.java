// ## Exercício 2 — ListIterator
// 
// Dada a lista de preços:
// 
// ```java
// List<Double> precos = new ArrayList<>(Arrays.asList(
    // 49.90, 149.90, 299.90, 499.90, 99.90
// ));
// ```
// 
// 1. Use `ListIterator` para imprimir todos os preços com seu índice indo para frente
// 2. Sem criar novo iterator, volte para trás com `hasPrevious()` e imprima novamente
// 3. Use `set()` para aplicar 15% de desconto em todos os preços durante a iteração
// 4. Use `add()` para inserir o preço `199.90` após o elemento `149.90`
// 5. Imprima a lista final
// 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio02 {
    public static void main(String[] args) {
        
        List<Double> precos = new ArrayList<>(Arrays.asList(
            49.90, 149.90, 299.90, 499.90, 99.90
        ));

        // 1. Use ListIterator para imprimir todos os preços com seu índice indo para frente
        var iterator = precos.listIterator();
        while (iterator.hasNext()) {
            int index = iterator.nextIndex();
            Double preco = iterator.next();
            System.out.println("Índice: " + index + ", Preço: " + preco);
        }
        System.out.println(" ");

        // 2. Sem criar novo iterator, volte para trás com hasPrevious() e imprima novamente
        while (iterator.hasPrevious()) {
            int index = iterator.previousIndex();
            Double preco = iterator.previous();
            System.out.println("Índice: " + index + ", Preço: " + preco);
        }
        System.out.println(" ");

        // 3. Use set() para aplicar 15% de desconto em todos os preços durante a iteração
        while (iterator.hasNext()) {
            Double preco = iterator.next();
            Double precoComDesconto = preco * 0.85; // Aplicando 15% de desconto
            iterator.set(precoComDesconto);
        }
        
        // 4. Use add() para inserir o preço 199.90 após o elemento 149.90
        iterator = precos.listIterator();
        while (iterator.hasNext()) {
            Double preco = iterator.next();
            if (preco.equals(149.90 * 0.85)) { // Verificando o preço com desconto
                iterator.add(199.90);
                break;
            }
        }

        // 5. Imprima a lista final
        System.out.println("Lista final de preços:");
        for (Double preco : precos) {
            System.out.println(preco);
        }
    }
}
