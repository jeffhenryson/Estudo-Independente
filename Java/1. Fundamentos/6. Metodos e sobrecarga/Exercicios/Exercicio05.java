// ## Exercício 5 — Retorno antecipado

// Crie um método `validarSenha(String senha)` que retorna uma `String` com o resultado da validação. A senha deve:

// 1. Ter no mínimo 8 caracteres → `"Senha muito curta"`
// 2. Não pode ser `null` ou vazia → `"Senha inválida"`
// 3. Deve conter pelo menos um número — use `.matches(".*\\d.*")` → `"Senha deve conter número"`
// 4. Se passar em tudo → `"Senha válida"`
// new 5. Deve conter pelo menos um símbolo (ex: `!@#$%^&*()-+`) → `"Senha deve conter símbolo"`

// Use retornos antecipados, não `if/else` aninhado.

public class Exercicio05 {

    public String validarSenha(String senha) {
        if (senha == null || senha.isEmpty()) {
            return "Senha inválida";
        }
        if (senha.length() < 8) {
            return "Senha muito curta";
        }
        if (!senha.matches(".*\\d.*")) { // A expressão regular ".*\\d.*" é usada para verificar se a string contém pelo menos um dígito. O ".*" antes e depois do "\\d" permite que haja qualquer número de caracteres antes e depois do dígito, garantindo que a senha possa conter outros caracteres além dos números. Se a senha não corresponder a essa expressão, significa que ela não contém um número, e o método retorna "Senha deve conter número".
            return "Senha deve conter número";
        }
        if (!senha.matches(".*[!@#$%^&*()-+].*")) { // A expressão regular ".*[!@#$%^&*()-+].*" é usada para verificar se a string contém pelo menos um símbolo específico. O ".*" antes e depois do conjunto de símbolos permite que haja qualquer número de caracteres antes e depois do símbolo, garantindo que a senha possa conter outros caracteres além dos símbolos. Se a senha não corresponder a essa expressão, significa que ela não contém um símbolo, e o método retorna "Senha deve conter símbolo".
            return "Senha deve conter símbolo";
        }
        return "Senha válida";
    }

    public static void main(String[] args) {
        Exercicio05 exercicio = new Exercicio05();
        System.out.println(exercicio.validarSenha(null)); // Senha inválida
        System.out.println(exercicio.validarSenha("")); // Senha inválida
        System.out.println(exercicio.validarSenha("abc")); // Senha muito curta
        System.out.println(exercicio.validarSenha("abcdefgh")); // Senha deve conter número
        System.out.println(exercicio.validarSenha("abc12345")); // Senha deve conter símbolo
        System.out.println(exercicio.validarSenha("abc12345!")); // Senha válida
    }

}
