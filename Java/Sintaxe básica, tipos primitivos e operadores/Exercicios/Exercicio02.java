// ## Exercício 2 — Operadores e casting

// Dados dois números inteiros `a = 17` e `b = 5`, calcule e imprima:

// 1. A soma: System.out.println(a + b); // 22
// 2. A subtração: System.out.println(a - b); // 12
// 3. A multiplicação: System.out.println(a * b); // 85
// 4. A divisão **decimal** (não inteira): System.out.println((double) a / b); // 3.4
// 5. O resto da divisão: System.out.println(a % b); // 2 
// 6. O resultado de `a` elevado ao quadrado (sem usar `Math.pow`, só operadores): System.out.println(a * a); // 289

public class Exercicio02 {
    public static void main(String[] args) {
        int a = 17, b = 5;

        System.out.println(a + b);              // 22
        System.out.println(a - b);             // 12
        System.out.println(a * b);             // 85
        System.out.println((double) a / b);    // 3.4 ← cast em um dos operandos
        System.out.println(a % b);             // 2
        System.out.println(a * a);  
    }
}