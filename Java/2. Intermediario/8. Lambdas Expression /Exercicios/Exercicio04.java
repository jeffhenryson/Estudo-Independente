// ## Exercício 4 — Retornando lambdas

// Crie uma fábrica de validadores:

// ```java
// @FunctionalInterface
// interface Validador {
//     boolean validar(String valor);
// }

// class ValidadorFactory {
//     static Validador tamanhoMinimo(int min) { ... }
//     static Validador tamanhoMaximo(int max) { ... }
//     static Validador contem(String trecho) { ... }
//     static Validador naoContem(String trecho) { ... }
//     static Validador regex(String padrao) { ... }
// }
// ```

// No `main`:
// 1. Crie um validador de email: tamanho mínimo 6 + contém `"@"` + contém `"."`
// 2. Crie um validador de senha: mínimo 8 + não contém `"123"` + regex `".*\\d.*"`
// 3. Crie um validador de nome de campanha: mínimo 3 + máximo 50 + não contém caracteres especiais
// 4. Teste cada validador com valores válidos e inválidos

import java.util.regex.Pattern;

@FunctionalInterface
interface Validador {
    boolean validar(String valor);
}

class ValidadorFactory {
    static Validador tamanhoMinimo(int min) {
        return valor -> valor != null && valor.length() >= min;
    }

    static Validador tamanhoMaximo(int max) {
        return valor -> valor != null && valor.length() <= max;
    }

    static Validador contem(String trecho) {
        return valor -> valor != null && valor.contains(trecho);
    }

    static Validador naoContem(String trecho) {
        return valor -> valor != null && !valor.contains(trecho);
    }

    static Validador regex(String padrao) {
        return valor -> valor != null && Pattern.matches(padrao, valor);
    }
}

public class Exercicio04 {
    public static void main(String[] args) {
        // 1. Validador de email
        Validador validadorEmail = valor ->
            ValidadorFactory.tamanhoMinimo(6).validar(valor) &&
            ValidadorFactory.contem("@").validar(valor) &&
            ValidadorFactory.contem(".").validar(valor);

        System.out.println("Email válido: " + validadorEmail.validar("teste@email.com")); // true
        System.out.println("Email inválido: " + validadorEmail.validar("email")); // false

        // 2. Validador de senha
        Validador validadorSenha = valor ->
            ValidadorFactory.tamanhoMinimo(8).validar(valor) &&
            ValidadorFactory.naoContem("123").validar(valor) &&
            ValidadorFactory.regex(".*\\d.*").validar(valor);

        System.out.println("Senha válida: " + validadorSenha.validar("senha1234")); // true
        System.out.println("Senha inválida: " + validadorSenha.validar("123")); // false

        // 3. Validador de nome de campanha
        Validador validadorNomeCampanha = valor ->
            ValidadorFactory.tamanhoMinimo(3).validar(valor) &&
            ValidadorFactory.tamanhoMaximo(50).validar(valor) &&
            ValidadorFactory.regex("^[a-zA-Z0-9 ]*$").validar(valor);

        System.out.println("Nome de campanha válido: " + validadorNomeCampanha.validar("Campanha 2026")); // true
        System.out.println("Nome de campanha inválido: " + validadorNomeCampanha.validar("Campanha@2026")); // false
    }
}