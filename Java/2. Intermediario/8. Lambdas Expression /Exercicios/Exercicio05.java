// ## Exercício 5 — Composição com Predicate

// Use `Predicate` da `java.util.function` para construir filtros compostos:

// ```java
// List<String> emails = Arrays.asList(
//     "jeff@cerne.com",
//     "ana@cerne.com.br",
//     "spam@temp.com",
//     "invalido",
//     "bob@empresa.org",
//     "",
//     "admin@cerne.com"
// );
// ```

// 1. Crie predicados individuais:
//    - `temArroba` → contém `"@"`
//    - `temPonto` → contém `"."`
//    - `naoEhVazio` → não é blank
//    - `ehCerne` → termina com `"@cerne.com"` ou `"@cerne.com.br"`
//    - `tamanhoValido` → entre 6 e 100 caracteres

// 2. Componha com `and()`, `or()`, `negate()`:
//    - `emailValido` → temArroba AND temPonto AND naoEhVazio AND tamanhoValido
//    - `emailCerneValido` → emailValido AND ehCerne
//    - `emailExterno` → emailValido AND ehCerne.negate()

// 3. Filtre a lista com cada predicado composto e imprima os resultados

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Exercicio05 {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
            "jeff@cerne.com",
            "ana@cerne.com.br",
            "spam@temp.com",
            "invalido",
            "bob@empresa.org",
            "",
            "admin@cerne.com"
        );

        // Predicados individuais
        Predicate<String> temArroba = email -> email.contains("@");
        Predicate<String> temPonto = email -> email.contains(".");
        Predicate<String> naoEhVazio = email -> email != null && !email.isBlank();
        Predicate<String> ehCerne = email -> email.endsWith("@cerne.com") || email.endsWith("@cerne.com.br");
        Predicate<String> tamanhoValido = email -> email.length() >= 6 && email.length() <= 100;

        // Predicados compostos
        Predicate<String> emailValido = temArroba.and(temPonto).and(naoEhVazio).and(tamanhoValido);
        Predicate<String> emailCerneValido = emailValido.and(ehCerne);
        Predicate<String> emailExterno = emailValido.and(ehCerne.negate());

        // Filtrando e imprimindo os resultados
        System.out.println("Emails válidos:");
        emails.stream().filter(emailValido).forEach(System.out::println);

        System.out.println("\nEmails válidos da Cerne:");
        emails.stream().filter(emailCerneValido).forEach(System.out::println);

        System.out.println("\nEmails externos válidos:");
        emails.stream().filter(emailExterno).forEach(System.out::println);
    }
}