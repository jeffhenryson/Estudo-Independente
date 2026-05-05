// ## 4. Busca em Array com `break`

// **Enunciado:** Crie um array de Strings contendo nomes de frutas: `{"Maçã", "Banana", "Laranja", "Uva", "Manga"}`. Utilize um loop com `for-each` para percorrer o array. Se o nome da fruta for igual a `"Laranja"`, exiba a mensagem `"Fruta encontrada!"` e encerre o loop imediatamente usando o `break`.

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        String[] frutas = {"Maçã", "Banana", "Laranja", "Uva", "Manga"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome da fruta que deseja buscar: ");
        String frutaBuscada = scanner.nextLine();

        boolean frutaEncontrada = false;
        for (String fruta : frutas) {
            if (fruta.equalsIgnoreCase(frutaBuscada)) {
                System.out.println("Fruta encontrada!");
                frutaEncontrada = true;
                break;
            }
        }
        if (!frutaEncontrada) {
            System.out.println("Fruta não encontrada.");
        }
        scanner.close();
    }
}
