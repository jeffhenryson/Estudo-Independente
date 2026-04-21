// ## Exercício 3 — Ternário e lógica

// Dado um valor `temperatura = 38.5` (double), imprima:

// - `"Febre"` se temperatura for maior que 37.5
// - `"Normal"` caso contrário

// Use o operador ternário:

public class Exercicio03 {
    public static void main(String[] args) {
        double temperatura = 38.5;
        String paciente = (temperatura >= 37.5) ? "febre" : "normal";
        System.out.println("O paciente está com " + paciente);
    }
}