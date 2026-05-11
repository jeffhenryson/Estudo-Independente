## 1. O que é e por que existe

Lambda é uma **função anônima** — um bloco de código que pode ser passado como argumento, armazenado em variável e executado depois. Antes de lambdas (Java 7), para passar comportamento você precisava de classes anônimas verbosas:

```java
// antes — classe anônima verbosa
List<String> nomes = Arrays.asList("Carlos", "Ana", "Bruno");

Collections.sort(nomes, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
});

// com lambda — conciso e legível
Collections.sort(nomes, (a, b) -> a.compareTo(b));

// ainda mais curto com method reference
Collections.sort(nomes, String::compareTo);
```

---

## 2. Sintaxe

```java
// estrutura
(parâmetros) -> expressão
(parâmetros) -> { bloco de código }

// sem parâmetros
() -> System.out.println("Hello")
() -> 42

// um parâmetro — parênteses opcionais
x -> x * 2
x -> x.toUpperCase()

// múltiplos parâmetros
(a, b) -> a + b
(a, b) -> a.compareTo(b)

// bloco — quando precisa de mais de uma linha
(a, b) -> {
    int soma = a + b;
    return soma * 2;
}
```

---

## 3. Functional Interface — base dos lambdas

Lambda só funciona onde existe uma **functional interface** — interface com exatamente um método abstrato:

```java
@FunctionalInterface
public interface Operacao {
    double calcular(double a, double b);
}
```

```java
// lambda implementa o único método abstrato
Operacao soma = (a, b) -> a + b;
Operacao subtracao = (a, b) -> a - b;
Operacao multiplicacao = (a, b) -> a * b;
Operacao divisao = (a, b) -> {
    if (b == 0) throw new ArithmeticException("Divisão por zero");
    return a / b;
};

System.out.println(soma.calcular(10, 5));         // 15.0
System.out.println(subtracao.calcular(10, 5));    // 5.0
System.out.println(multiplicacao.calcular(10, 5)); // 50.0
System.out.println(divisao.calcular(10, 5));      // 2.0
```

---

## 4. Lambdas com coleções

Onde você mais vai usar lambdas no dia a dia:

```java
List<String> campanhas = new ArrayList<>(Arrays.asList(
    "Meta Black Friday", "Google Search", "Meta Verão", "TikTok Lançamento"
));

// forEach
campanhas.forEach(c -> System.out.println(c));

// removeIf
campanhas.removeIf(c -> c.startsWith("Google"));

// sort
campanhas.sort((a, b) -> a.compareTo(b));          // alfabético
campanhas.sort((a, b) -> b.compareTo(a));          // reverso
campanhas.sort(Comparator.naturalOrder());          // equivalente
campanhas.sort(Comparator.reverseOrder());          // equivalente

System.out.println(campanhas);
```

---

## 5. Variáveis capturadas

Lambda pode capturar variáveis do escopo externo — mas devem ser **efetivamente finais**:

```java
String plataforma = "Meta";           // efetivamente final — não é reatribuída

List<String> campanhas = Arrays.asList("Meta Ads BF", "Google Search", "Meta Verão");
campanhas.forEach(c -> {
    if (c.contains(plataforma)) {     // ✅ captura variável externa
        System.out.println(c);
    }
});

plataforma = "Google"; // ❌ erro — se reatribuir, não pode usar no lambda
```

---

## 6. Lambda como parâmetro de método

```java
public static void processarCampanhas(List<String> campanhas, Operacao op, double valor) {
    campanhas.forEach(c ->
        System.out.printf("%s → R$ %.2f%n", c, op.calcular(100.0, valor))
    );
}

@FunctionalInterface
interface Operacao {
    double calcular(double base, double modificador);
}
```

```java
List<String> planos = Arrays.asList("starter", "pro", "enterprise");

// passa lambda como argumento
processarCampanhas(planos, (base, mod) -> base * (1 - mod), 0.15); // desconto 15%
processarCampanhas(planos, (base, mod) -> base + mod, 50.0);        // acréscimo
```

---

## 7. Returning lambdas

Métodos podem retornar lambdas:

```java
@FunctionalInterface
interface Validador {
    boolean validar(String valor);
}

public static Validador criarValidador(int tamanhoMinimo, String proibido) {
    return valor -> valor.length() >= tamanhoMinimo && !valor.contains(proibido);
}
```

```java
Validador validadorSenha = criarValidador(8, "123");
System.out.println(validadorSenha.validar("abcdefg"));   // false — muito curta
System.out.println(validadorSenha.validar("abc123def")); // false — contém "123"
System.out.println(validadorSenha.validar("abcdefgh"));  // true
```

---

## 8. Composição de lambdas

Functional interfaces têm métodos `default` para compor comportamentos:

```java
import java.util.function.Predicate;

Predicate<String> temArroba = email -> email.contains("@");
Predicate<String> temPonto = email -> email.contains(".");
Predicate<String> naoEVazio = email -> !email.isBlank();

// and — todas devem ser true
Predicate<String> emailValido = temArroba.and(temPonto).and(naoEVazio);

System.out.println(emailValido.test("jeff@cerne.com")); // true
System.out.println(emailValido.test("jeffcerne.com"));  // false — sem @
System.out.println(emailValido.test(""));               // false — vazio

// or — pelo menos uma deve ser true
Predicate<String> starterOuPro =
    ((Predicate<String>) p -> p.equals("starter")).or(p -> p.equals("pro"));

// negate — inverte
Predicate<String> naoEhStarter = ((Predicate<String>) p -> p.equals("starter")).negate();
```

---