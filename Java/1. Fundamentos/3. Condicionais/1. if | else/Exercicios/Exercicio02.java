// ## 2. Cálculo de Média Escolar

// **Enunciado:** Crie um programa que receba três notas (valores decimais `double`) de um aluno, calcule a média aritmética e exiba uma das seguintes mensagens, dependendo do resultado:
// * **Aprovado:** Média maior ou igual a 7.0
// * **Recuperação:** Média maior ou igual a 5.0 e menor que 7.0
// * **Reprovado:** Média menor que 5.0

public class Exercicio02 {
    public static void main(String[] args) {
        
        double nota1 = 8.5; 
        double nota2 = 6.0;
        double nota3 = 4.5;

        double media = (nota1 + nota2 + nota3) / 3;

        if (media >= 7.0) {
            System.out.println("Média: " + media + " - Aprovado");
        } else if (media >= 5.0) {
            System.out.println("Média: " + media + " - Recuperação");
        } else {
            System.out.println("Média: " + media + " - Reprovado");
        }
    }
}
