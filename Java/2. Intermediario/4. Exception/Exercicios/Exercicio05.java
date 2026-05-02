// ## Exercício 5 — multi-catch e relançamento

// ```java
// public static void processarEntrada(String valor, String[] array, int indice) {
//     // pode lançar: NumberFormatException, ArrayIndexOutOfBoundsException, NullPointerException
// }
// ```

// 1. Implemente o método que:
//     - Converte `valor` para `int` com `Integer.parseInt()`
//     - Acessa `array[indice]`
//     - Chama `valor.toUpperCase()`
// 2. No `main`, chame com cenários que disparem cada exceção
// 3. Crie uma versão 2 do método que:
//     - Usa multi-catch para `NumberFormatException | ArrayIndexOutOfBoundsException`
//     - Relança como `IllegalArgumentException` preservando a causa original
//     - Trata `NullPointerException` separadamente

public class Exercicio05 {

    public static void main(String[] args){
        
        String[] array = {"A", "B", "C"};

        // Cenário 1: NumberFormatException
        try {
            processarEntrada("abc", array, 0);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e);
        }

        // Cenário 2: ArrayIndexOutOfBoundsException
        try {
            processarEntrada("123", array, 5);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e);
        }

        // Cenário 3: NullPointerException
        try {
            processarEntrada(null, array, 0);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e);
        }
    }

    public static void processarEntrada(String valor, String[] array, int indice) {
        // Pode lançar: NumberFormatException, ArrayIndexOutOfBoundsException, NullPointerException
        int numero = Integer.parseInt(valor);
        String elemento = array[indice];
        String valorMaiusculo = valor.toUpperCase();
        System.out.println("Número: " + numero);
        System.out.println("Elemento: " + elemento);
        System.out.println("Valor em maiúsculo: " + valorMaiusculo);
    }

}
