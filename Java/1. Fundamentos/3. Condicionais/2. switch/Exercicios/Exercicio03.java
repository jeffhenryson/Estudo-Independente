// ## 3. Avaliação de Desempenho

// **Enunciado:** Escreva um programa que declare um caractere `notaConceito` (do tipo `char`, aceitando `'A'`, `'B'`, `'C'`, `'D'` ou `'F'`). Utilize o `switch` para imprimir uma mensagem correspondente ao conceito:
// * `'A'`: "Excelente"
// * `'B'`: "Bom"
// * `'C'`: "Regular"
// * `'D'`: "Ruim"
// * `'F'`: "Reprovado"
// * Outro caractere: "Conceito inválido"

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a nota conceito (A, B, C, D ou F): ");
        char notaConceito = scanner.next().charAt(0);

        String mensagem;
        switch (notaConceito) {
            case 'A':
                mensagem = "Excelente";
                break;
            case 'B':
                mensagem = "Bom";
                break;
            case 'C':
                mensagem = "Regular";
                break;
            case 'D':
                mensagem = "Ruim";
                break;
            case 'F':
                mensagem = "Reprovado";
                break;
            default:
                mensagem = "Conceito inválido";
        }
        System.out.println("A avaliação é: " + mensagem);
        
    }
}
