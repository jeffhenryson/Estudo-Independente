// ## Exercicio 01. Dias da Semana por Extenso

// **Enunciado:** Escreva um programa em Java que declare uma variável inteira chamada `diaSemana` (com valores de 1 a 7). Utilize a estrutura `switch` moderna (com setas `->`) para retornar o nome do dia da semana correspondente como uma `String` e imprima o resultado. Se o valor for menor que 1 ou maior que 7, retorne `"Dia inválido"`.

import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número de 1 a 7 para o dia da semana: ");
        int diaSemana = scanner.nextInt();

        // switch padrão: 
        String nomeDia;
        switch (diaSemana) {
            case 1:
                nomeDia = "Domingo";
                break;
            case 2:
                nomeDia = "Segunda-feira";
                break;
            case 3:
                nomeDia = "Terça-feira";
                break;
            case 4:
                nomeDia = "Quarta-feira";
                break;
            case 5:
                nomeDia = "Quinta-feira";
                break;
            case 6:
                nomeDia = "Sexta-feira";
                break;
            case 7:
                nomeDia = "Sábado";
                break;
            default:
                nomeDia = "Dia inválido";
        }
        System.out.println("O dia da semana é: " + nomeDia);
    }
}
