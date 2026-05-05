// ## 3. Validação de Senha

// **Enunciado:** Crie um programa que declare uma variável do tipo `String` chamada `senhaCorreta` com o valor `"123456"` e outra `String` chamada `senhaInserida`. 
// * Utilize o método `.equals()` para comparar as duas variáveis. 
// * Se as senhas forem iguais, imprima: `"Acesso concedido!"`.
// * Caso contrário, imprima: `"Acesso negado!"`.

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        String senhaCorreta = "123456";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String senhaInserida = scanner.nextLine();

        if (senhaCorreta.equals(senhaInserida)) {
            System.out.println("Acesso concedido!");
        } else {
            System.out.println("Acesso negado!");
        }
    }
}
