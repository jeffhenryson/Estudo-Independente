// ## 5. Cálculo do IMC (Índice de Massa Corporal)

// **Enunciado:** O IMC é calculado dividindo o peso (em kg) pela altura (em metros) ao quadrado. Crie um programa que calcule o IMC e imprima a classificação correspondente:
// * **Abaixo do peso:** IMC abaixo de 18.5
// * **Peso normal:** IMC entre 18.5 e 24.9
// * **Sobrepeso:** IMC entre 25.0 e 29.9
// * **Obesidade:** IMC igual ou maior a 30.0

import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o peso em kg: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite a altura em metros: ");
        double altura = scanner.nextDouble();

        double imc = peso / (altura * altura);

        System.out.printf("Seu IMC é: %.2f%n", imc);

        if (imc < 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc >= 18.5 && imc <= 24.9) {
            System.out.println("Peso normal");
        } else if (imc >= 25.0 && imc <= 29.9) {
            System.out.println("Sobrepeso");
        } else if (imc >= 30.0) {
            System.out.println("Obesidade");
        } else {
            System.out.println("IMC inválido.");
        }
    }
}
