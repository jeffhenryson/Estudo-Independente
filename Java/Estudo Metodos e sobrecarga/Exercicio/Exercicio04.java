// ## Exercício 4 — Varargs

// Crie os métodos:

// 1. `media(double... valores)` → calcula e retorna a média
// 2. `maior(int... valores)` → retorna o maior valor
// 3. `concatenar(String separador, String... partes)` → junta as strings com o separador

// ```java
// // exemplos de chamada
// media(7.0, 8.5, 9.0, 6.5)          // 7.75
// maior(3, 17, 5, 9, 2)              // 17
// concatenar(" | ", "Java", "Spring", "PostgreSQL") // "Java | Spring | PostgreSQL"
// ```

public class Exercicio04 {
    public static void main(String[] args) {
        System.out.println(media(7.0, 8.5, 9.0, 6.5)); // 7.75
        System.out.println(maior(3, 17, 5, 9, 2)); // 17
        System.out.println(concatenar(" | ", "Java", "Spring", "PostgreSQL")); // "Java | Spring | PostgreSQL"
    }

    // Método para calcular a média de um conjunto de valores
    public static double media(double... valores) {
        double soma = 0;
        for (double valor : valores) {
            soma += valor;
        }
        return soma / valores.length; 
    }

    // Método para encontrar o maior valor em um conjunto de inteiros
    public static int maior(int... valores) {
        int max = valores[0];
        for (int valor : valores) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }

    // Método para concatenar strings com um separador
    public static String concatenar(String separador, String... partes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < partes.length; i++) {
            sb.append(partes[i]);
            if (i < partes.length - 1) {
                sb.append(separador);
            }
        }
        return sb.toString();
    }
}
