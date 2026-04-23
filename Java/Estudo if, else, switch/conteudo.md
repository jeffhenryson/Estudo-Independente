## 1. if / else if / else

Estrutura básica idêntica ao que você já conhece, mas com parênteses obrigatórios na condição e sem `:` no final:

```java
// Python
if idade >= 18:
    print("maior")
elif idade >= 16:
    print("menor mas pode votar")
else:
    print("menor")

// Java
if (idade >= 18) {
    System.out.println("maior");
} else if (idade >= 16) {
    System.out.println("menor mas pode votar");
} else {
    System.out.println("menor");
}
```

> As chaves `{}` são **opcionais** quando há só uma instrução, mas por boa prática **sempre use chaves**.
> 

```java
// funciona, mas evite
if (ativo)
    System.out.println("ativo");

// prefira sempre
if (ativo) {
    System.out.println("ativo");
}
```

---

## 2. Operadores úteis em condicionais

```java
// Comparação de primitivos — use ==
int a = 5;
if (a == 5) { ... }

// Comparação de Strings — NUNCA use ==, use .equals()
String status = "ativo";
if (status.equals("ativo")) { ... }

// Ignorando maiúsculas/minúsculas
if (status.equalsIgnoreCase("ATIVO")) { ... }
```

> ⚠️ Esse é um dos erros mais comuns em Java: usar `==` para comparar Strings. `==` compara a **referência de memória**, não o conteúdo.
> 

```java
String a = new String("ativo");
String b = new String("ativo");

System.out.println(a == b);       // false ← mesma memória? Não
System.out.println(a.equals(b));  // true  ← mesmo conteúdo? Sim
```

---

## 3. if ternário (revisão + aprofundamento)

```java
// simples
String resultado = (nota >= 7) ? "aprovado" : "reprovado";

// aninhado — use com moderação, prejudica legibilidade
String faixa = (nota >= 9) ? "ótimo" : (nota >= 7) ? "bom" : "ruim";
```

---

## 4. switch — forma clássica

Usado quando você tem **um valor** e quer testar vários casos:

```java
int dia = 3;

switch (dia) {
    case 1:
        System.out.println("Segunda");
        break;
    case 2:
        System.out.println("Terça");
        break;
    case 3:
        System.out.println("Quarta");
        break;
    default:
        System.out.println("Outro dia");
}
```

> ⚠️ O `break` é **obrigatório** para parar a execução. Sem ele ocorre **fall-through** — a execução continua para o próximo case.
> 

```java
// fall-through proposital — útil às vezes
switch (dia) {
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
        System.out.println("Dia útil");
        break;
    case 6:
    case 7:
        System.out.println("Fim de semana");
        break;
}
```

---

## 5. switch — forma moderna (Java 14+)

Java moderno trouxe uma sintaxe muito mais limpa com **switch expressions**:

```java
// switch expression com ->
int dia = 3;

String nomeDia = switch (dia) {
    case 1 -> "Segunda";
    case 2 -> "Terça";
    case 3 -> "Quarta";
    case 4 -> "Quinta";
    case 5 -> "Sexta";
    case 6 -> "Sábado";
    case 7 -> "Domingo";
    default -> "Inválido";
};

System.out.println(nomeDia); // Quarta
```

Vantagens da forma moderna:

- Não precisa de `break`
- Pode retornar um valor diretamente
- Muito mais legível

Múltiplos valores no mesmo case:

```java
String tipo = switch (dia) {
    case 1, 2, 3, 4, 5 -> "Dia útil";
    case 6, 7 -> "Fim de semana";
    default -> "Inválido";
};
```

---

## 6. switch com String

Java suporta `switch` com `String` desde a versão 7:

```java
String plano = "pro";

switch (plano) {
    case "free":
        System.out.println("Limite: 5 usuários");
        break;
    case "pro":
        System.out.println("Limite: 50 usuários");
        break;
    case "enterprise":
        System.out.println("Limite: ilimitado");
        break;
    default:
        System.out.println("Plano desconhecido");
}
```

Ou com sintaxe moderna:

```java
String limite = switch (plano) {
    case "free" -> "5 usuários";
    case "pro" -> "50 usuários";
    case "enterprise" -> "ilimitado";
    default -> "desconhecido";
};
```

---

## 7. Pattern matching no if (Java 16+)

Uma feature moderna que vai ser útil quando você chegar em OOP:

```java
Object valor = "Cerne";

// antes
if (valor instanceof String) {
    String s = (String) valor;
    System.out.println(s.toUpperCase());
}

// Java 16+ — cast automático
if (valor instanceof String s) {
    System.out.println(s.toUpperCase()); // s já é String aqui
}
```

---