## 1. O que é um método

Método é um bloco de código nomeado que executa uma tarefa. Você já usou vários (`main`, `println`, `equals`) — agora vamos criar os nossos.

```java
// estrutura completa
modificador tipoRetorno nomeMetodo(parâmetros) {
    // corpo
    return valor; // se tipoRetorno não for void
}
```

```java
// exemplo concreto
public static int somar(int a, int b) {
    return a + b;
}
```

---

## 2. Tipos de retorno

```java
// void — não retorna nada
public static void saudar(String nome) {
    System.out.println("Olá, " + nome);
}

// retorna int
public static int dobrar(int n) {
    return n * 2;
}

// retorna String
public static String formatarNome(String nome) {
    return nome.trim().toLowerCase();
}

// retorna boolean
public static boolean ehPar(int n) {
    return n % 2 == 0;
}
```

---

## 3. Chamando métodos

```java
public class Main {

    public static void saudar(String nome) {
        System.out.println("Olá, " + nome);
    }

    public static int somar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        saudar("Jeff");                        // chama direto — mesmo classe, static

        int resultado = somar(3, 7);
        System.out.println(resultado);         // 10

        System.out.println(somar(10, 20));     // pode usar direto no println
    }
}
```

---

## 4. Parâmetros e argumentos

```java
// parâmetros — definição do método (o que ele espera)
public static double calcularDesconto(double preco, double percentual) {
    return preco - (preco * percentual);
}

// argumentos — o que você passa na chamada
double precoFinal = calcularDesconto(100.0, 0.15);
```

### Passagem por valor vs referência

Em Java, **primitivos são passados por valor** — o método recebe uma cópia:

```java
public static void tentarModificar(int x) {
    x = 999; // modifica só a cópia local
}

public static void main(String[] args) {
    int valor = 10;
    tentarModificar(valor);
    System.out.println(valor); // ainda 10
}
```

**Objetos são passados por referência** — o método acessa o mesmo objeto:

```java
public static void modificarArray(int[] arr) {
    arr[0] = 999; // modifica o array original
}

public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    modificarArray(nums);
    System.out.println(nums[0]); // 999
}
```

---

## 5. Sobrecarga (Overloading)

Sobrecarga é ter **vários métodos com o mesmo nome** mas com **parâmetros diferentes** — tipo, quantidade ou ordem:

```java
public static int somar(int a, int b) {
    return a + b;
}

public static double somar(double a, double b) {
    return a + b;
}

public static int somar(int a, int b, int c) {
    return a + b + c;
}

public static String somar(String a, String b) {
    return a + b; // concatenação
}
```

Java decide qual chamar pelo tipo/quantidade dos argumentos:

```java
somar(2, 3)          // chama somar(int, int) → 5
somar(2.0, 3.0)      // chama somar(double, double) → 5.0
somar(1, 2, 3)       // chama somar(int, int, int) → 6
somar("Cerne", "!")  // chama somar(String, String) → "Cerne!"
```

> Sobrecarga é resolvida em **tempo de compilação** — o compilador já sabe qual método chamar.

---

## 6. Varargs — número variável de argumentos

Quando você não sabe quantos argumentos receberá:

```java
public static int somarTodos(int... numeros) {
    int total = 0;
    for (int n : numeros) {
        total += n;
    }
    return total;
}

somarTodos(1, 2)          // 3
somarTodos(1, 2, 3, 4, 5) // 15
somarTodos()              // 0
```

> `int... numeros` é tratado internamente como `int[]`. Deve ser sempre o **último parâmetro**.

---

## 7. Retorno antecipado

```java
public static String classificarNota(double nota) {
    if (nota < 0 || nota > 10) {
        return "Nota inválida"; // sai do método aqui
    }
    if (nota >= 7) {
        return "Aprovado";
    }
    if (nota >= 5) {
        return "Recuperação";
    }
    return "Reprovado";
}
```

---

## 8. Boas práticas

```java
// ✅ nome do método: verbo + substantivo, camelCase
calcularTotal()
buscarUsuario()
validarEmail()
formatarCpf()

// ✅ método faz UMA coisa só
// ❌ evite métodos que fazem tudo ao mesmo tempo

// ✅ menos de 20 linhas é um bom sinal
// ✅ parâmetros: no máximo 3-4, se precisar de mais, considere agrupar em objeto
```

---