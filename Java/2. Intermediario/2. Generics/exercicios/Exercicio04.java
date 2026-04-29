// ## Exercício 4 — Bounded type parameters

// Crie uma classe `Calculadora` com métodos que aceitam apenas `Number`:

// 1. `<T extends Number> double somar(List<T> lista)` → soma todos os elementos
// 2. `<T extends Number> double media(List<T> lista)` → calcula a média
// 3. `<T extends Number> T maiorNumero(List<T> lista)` → retorna o maior
// 4. `<T extends Number> T menorNumero(List<T> lista)` → retorna o menor

// No `main`:
// ```java
// List<Integer> inteiros = Arrays.asList(10, 30, 20, 50, 40);
// List<Double> decimais = Arrays.asList(1.5, 3.5, 2.5, 5.5, 4.5);

// // teste todos os métodos com as duas listas
// ```

import java.util.List;

public class Exercicio04 {
    public static void main(String[] args) {

        List<Integer> inteiros = List.of(10, 30, 20, 50, 40);
        List<Double> decimais = List.of(1.5, 3.5, 2.5, 5.5, 4.5);
    
        // Testar com a lista de inteiros
        System.out.println("Soma dos Inteiros: " + Calculadora.somar(inteiros));
        System.out.println("Média dos Inteiros: " + Calculadora.media(inteiros));
        System.out.println("Maior Número Inteiro: " + Calculadora.maiorNumero(inteiros));
        System.out.println("Menor Número Inteiro: " + Calculadora.menorNumero(inteiros));

        // Testar com a lista de decimais
        System.out.println("Soma dos Decimais: " + Calculadora.somar(decimais));
        System.out.println("Média dos Decimais: " + Calculadora.media(decimais));
        System.out.println("Maior Número Decimal: " + Calculadora.maiorNumero(decimais));
        System.out.println("Menor Número Decimal: " + Calculadora.menorNumero(decimais));
    }
}

class Calculadora {

    public static <T extends Number> double somar(List<T> lista) {
        double soma = 0.0;
        for (T numero : lista) {
            soma += numero.doubleValue();
        }
        return soma;
    }

    public static <T extends Number> double media(List<T> lista) {
        if (lista.isEmpty()) {
            return 0.0;
        }
        return somar(lista) / lista.size();
    }

    public static <T extends Number> T maiorNumero(List<T> lista) {
        if (lista.isEmpty()) {
            return null;
        }
        T maior = lista.get(0);
        for (T numero : lista) {
            if (numero.doubleValue() > maior.doubleValue()) {
                maior = numero;
            }
        }
        return maior;
    }

    public static <T extends Number> T menorNumero(List<T> lista) {
        if (lista.isEmpty()) {
            return null;
        }
        T menor = lista.get(0);
        for (T numero : lista) {
            if (numero.doubleValue() < menor.doubleValue()) {
                menor = numero;
            }
        }
        return menor;
    }
}