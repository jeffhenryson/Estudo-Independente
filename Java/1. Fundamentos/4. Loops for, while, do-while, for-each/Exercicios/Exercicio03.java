// ## Exercício 3 — for

// Imprima a tabuada de um número informado pelo usuário, de 1 a 10, usando `for`.

// Tabuada do 7:
// 7 x 1 = 7
// 7 x 2 = 14
// ...
// 7 x 10 = 70

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número para ver a tabuada: ");
        int numero = scanner.nextInt();
        System.out.println("Tabuada do " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n", numero, i, numero * i);
        }
        scanner.close();
    }
}
