// ## Exercício 1 — try/catch básico

// Dado o código abaixo, adicione tratamento de exceção para cada operação:

// ```java
// public class Main {
//     public static void main(String[] args) {
//         // operação 1
//         int[] numeros = {1, 2, 3};
//         System.out.println(numeros[5]);

//         // operação 2
//         String texto = null;
//         System.out.println(texto.length());

//         // operação 3
//         int resultado = 10 / 0;

//         // operação 4
//         String numero = "abc";
//         int parsed = Integer.parseInt(numero);
//     }
// }
// ```

// Para cada operação:

// 1. Envolva em try/catch com a exceção correta e específica
// 2. Imprima uma mensagem clara de erro com `e.getMessage()`
// 3. Adicione um bloco `finally` na operação 1 que imprima `"Operação 1 finalizada"`


public class Exercicio01 {
    public static void main(String[] args) {
        
        // operação 1
        try {
            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro na operação 1: " + e.getMessage());
        } finally {
            System.out.println("Operação 1 finalizada");
        }

        // operação 2
        try {
            String texto = null;
            System.out.println(texto.length());
        } catch (NullPointerException e) {
            System.out.println("Erro na operação 2: " + e.getMessage());
        }

        // operação 3
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Erro na operação 3: " + e.getMessage());
        }

        // operação 4
        try {
            String numero = "abc";
            int parsed = Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            System.out.println("Erro na operação 4: " + e.getMessage());
        }
    }
}