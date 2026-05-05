// ## Exercicio 05. Calculadora Simples com `switch`
// **Enunciado:** Crie um programa com duas variáveis numéricas (`double a`, `double b`) e uma `String` chamada `operador` (que pode ser `"+"`, `"-"`, `"*"`, ou `"/"`). Utilize um `switch` para realizar a operação matemática correspondente e imprimir o resultado. Implemente também um caso `default` que informe caso o operador seja inválido.

public class Exercicio05 {
    public static void main(String[] args) {
        double a = 10.0;
        double b = 5.0;
        String operador = "+";

        double resultado = switch (operador) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b != 0) {
                    yield a / b; // Usando yield para retornar o resultado
                } else {
                    System.out.println("Erro: Divisão por zero!");
                    yield Double.NaN; // Retorna NaN para indicar erro
                }
            }
            default -> {
                System.out.println("Operador inválido!");
                yield Double.NaN; // Retorna NaN para indicar erro
            }
        };

        if (!Double.isNaN(resultado)) {
            System.out.println("O resultado de " + a + " " + operador + " " + b + " é: " + resultado);
        }
    }
}
