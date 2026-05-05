## 1. switch — forma clássica

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

## 2. switch — forma moderna (Java 14+)

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

## 3. switch com String

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