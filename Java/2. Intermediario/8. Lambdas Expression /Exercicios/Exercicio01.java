// ## Exercício 1 — Sintaxe básica

// Crie a functional interface `Transformador<T>`:

// ```java
// @FunctionalInterface
// interface Transformador<T> {
//     T transformar(T valor);
// }
// ```

// No `main`, crie as seguintes instâncias usando lambda:

// 1. `Transformador<String>` que converte para maiúsculas
// 2. `Transformador<String>` que remove espaços das pontas
// 3. `Transformador<String>` que inverte a string
// 4. `Transformador<Integer>` que dobra o número
// 5. `Transformador<Double>` que arredonda para 2 casas decimais

// Aplique cada transformador a um valor e imprima o resultado.

@FunctionalInterface
interface Transformador<T> {
    T transformar(T valor);
}

public class Exercicio01 {
    public static void main(String[] args) {
        
        // 1. Transformador<String> que converte para maiúsculas
        Transformador<String> paraMaiusculas = valor -> valor.toUpperCase();

        // 2. Transformador<String> que remove espaços das pontas
        Transformador<String> removerEspacos = valor -> valor.trim();

        // 3. Transformador<String> que inverte a string
        Transformador<String> inverterString = valor -> new StringBuilder(valor).reverse().toString();

        // 4. Transformador<Integer> que dobra o número
        Transformador<Integer> dobrarNumero = valor -> valor * 2;

        // 5. Transformador<Double> que arredonda para 2 casas decimais
        Transformador<Double> arredondar = valor -> Math.round(valor * 100.0) / 100.0;

        // Aplicando os transformadores e imprimindo os resultados
        System.out.println("Maiúsculas: " + paraMaiusculas.transformar("exemplo"));
        System.out.println("Sem espaços: " + removerEspacos.transformar("   exemplo   "));
        System.out.println("Invertido: " + inverterString.transformar("exemplo"));
        System.out.println("Dobrado: " + dobrarNumero.transformar(5));
        System.out.println("Arredondado: " + arredondar.transformar(123.45678));
    }
}
