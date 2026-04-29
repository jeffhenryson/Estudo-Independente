// ## Exercício 3 — Método genérico

// Crie uma classe `Utilitarios` com os métodos estáticos genéricos:

// 1. `<T> void imprimir(List<T> lista)` → imprime cada elemento com índice
// 2. `<T extends Comparable<T>> T maior(T a, T b)` → retorna o maior
// 3. `<T extends Comparable<T>> T maiorDaLista(List<T> lista)` → retorna o maior da lista
// 4. `<T> List<T> filtrar(List<T> lista, T valor)` → retorna nova lista sem o valor
// 5. `<T> void trocar(T[] array, int i, int j)` → troca dois elementos

// Teste todos no `main` com tipos diferentes — `String`, `Integer`, `Double`.

import java.util.ArrayList;
import java.util.List;

public class Exercicio03 {

    public static void main(String[] args) {

        List<String> strings = List.of("banana", "maçã", "laranja");
        List<Integer> integers = List.of(3, 1, 4, 1, 5);
        List<Double> doubles = List.of(2.71, 3.14, 1.41);

        // Imprimir as listas
        utilitarios.imprimir(strings);
        utilitarios.imprimir(integers);
        utilitarios.imprimir(doubles);

        // Testar o método maior
        System.out.println("Maior String: " + utilitarios.maior("banana", "maçã"));
        System.out.println("Maior Integer: " + utilitarios.maior(3, 4));
        System.out.println("Maior Double: " + utilitarios.maior(2.71, 3.14));

        // Testar o método maiorDaLista
        System.out.println("Maior da Lista de Strings: " + utilitarios.maiorDaLista(strings));
        System.out.println("Maior da Lista de Integers: " + utilitarios.maiorDaLista(integers));
        System.out.println("Maior da Lista de Doubles: " + utilitarios.maiorDaLista(doubles));

        // Testar o método filtrar
        System.out.println("Filtrar 'maçã' da Lista de Strings: " + utilitarios.filtrar(strings, "maçã"));
        System.out.println("Filtrar '1' da Lista de Integers: " + utilitarios.filtrar(integers, 1));
        System.out.println("Filtrar '3.14' da Lista de Doubles: " + utilitarios.filtrar(doubles, 3.14));

        // Testar o método trocar
        String[] arrayStrings = {"banana", "maçã", "laranja"};
        Integer[] arrayIntegers = {3, 1, 4};
        Double[] arrayDoubles = {2.71, 3.14, 1.41};

        // Trocar o primeiro e o último elemento de cada array
        utilitarios.trocar(arrayStrings, 0, 2);
        utilitarios.trocar(arrayIntegers, 0, 2);
        utilitarios.trocar(arrayDoubles, 0, 2);

        // Imprimir os arrays após a troca
        System.out.println("Array de Strings após troca: ");
        for (String s : arrayStrings) {
            System.out.print(s + " ");
        }
        System.out.println();

        // Imprimir os arrays após a troca
        System.out.println("Array de Integers após troca: ");
        for (Integer i : arrayIntegers) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Imprimir os arrays após a troca
        System.out.println("Array de Doubles após troca: ");
        for (Double d : arrayDoubles) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

}

class utilitarios<T> {

    public static <T> void imprimir(List<T> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ": " + lista.get(i));
        }
    }

    public static <T extends Comparable<T>> T maior(T a, T b) {
        return (a.compareTo(b) > 0) ? a : b;
    }

    public static <T extends Comparable<T>> T maiorDaLista(List<T> lista) {
        if (lista.isEmpty()) {
            return null;
        }
        T maior = lista.get(0);
        for (T item : lista) {
            if (item.compareTo(maior) > 0) {
                maior = item;
            }
        }
        return maior;
    }

    public static <T> List<T> filtrar(List<T> lista, T valor) {
        List<T> filtrada = new ArrayList<>();
        for (T item : lista) {
            if (!item.equals(valor)) {
                filtrada.add(item);
            }
        }
        return filtrada;
    }

    public static <T> void trocar(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}