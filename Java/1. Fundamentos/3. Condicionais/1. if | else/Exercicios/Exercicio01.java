// ## 1. Verificação de Par ou Ímpar

// **Enunciado:** Escreva um programa em Java que declare uma variável inteira `numero`. O programa deve verificar se o número é par ou ímpar e imprimir o resultado no console.

// * **Dica:** Utilize o operador de módulo/resto da divisão ` % ` para verificar se o resto da divisão por 2 é igual a 0.

public class Exercicio01 {
    public static void main(String[] args) {
        int numero = 10; // Você pode alterar esse valor para testar com outros números

        if (numero % 2 == 0) {
            System.out.println(numero + " é um número par.");
        } else {
            System.out.println(numero + " é um número ímpar.");
        }
    }
}
