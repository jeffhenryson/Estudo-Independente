
// ## Exercicio 02. Tabuada de um Número

// **Enunciado:** Crie um programa que declare uma variável inteira `n` (por exemplo, `n = 5`). Utilize um loop `for` para imprimir a tabuada desse número de 1 a 10 no formato:
// `5 x 1 = 5`, `5 x 2 = 10`, etc.

public class Exercicio02 {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}
