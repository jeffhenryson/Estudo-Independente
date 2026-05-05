// ## 2. Validação de Entrada com `do-while`

// **Enunciado:** Crie um programa que peça ao usuário para digitar um número positivo. Enquanto o usuário digitar um número menor ou igual a 0, o programa deve exibir uma mensagem de erro e pedir o número novamente. Quando o número digitado for positivo, exiba uma mensagem de sucesso, por exemplo: `"Número válido: X"`.
    
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Digite um número positivo: ");
            numero = scanner.nextInt();

            if (numero <= 0) {
                System.out.println("Número inválido! Por favor, digite um número positivo.");
            }
        } while (numero <= 0);

        System.out.println("Número válido: " + numero);
        scanner.close();
    }
}
