// ## Exercicio 02. Classificação de Produtos

// **Enunciado:** Crie um programa que declare uma variável do tipo `String` chamada `codigoProduto`. O programa deve utilizar a estrutura `switch` (clássica ou moderna) para verificar o código e imprimir a sua categoria:
// * `"A1"`: Eletrônico
// * `"B2"`: Vestuário
// * `"C3"`: Alimentação
// * Qualquer outro código: Produto desconhecido

import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código do produto (A1, B2, C3): ");
        String codigoProduto = scanner.nextLine();
        
        String categoria;
        switch (codigoProduto) {
            case "A1":
                categoria = "Eletrônico";
                break;
            case "B2":
                categoria = "Vestuário";
                break;
            case "C3":
                categoria = "Alimentação";
                break;
            default:
                categoria = "Produto desconhecido";
        }
        System.out.println("O produto com código " + codigoProduto + " é da categoria: " + categoria);
    }
}
