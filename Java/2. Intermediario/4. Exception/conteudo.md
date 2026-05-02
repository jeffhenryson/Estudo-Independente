## 1. O que é uma exceção

Exceção é um evento que interrompe o fluxo normal do programa. Em Java, exceções são **objetos** que carregam informações sobre o erro:

```java
int[] numeros = {1, 2, 3};
System.out.println(numeros[5]); // ArrayIndexOutOfBoundsException

String texto = null;
texto.length();                  // NullPointerException

int resultado = 10 / 0;          // ArithmeticException
```

Sem tratamento, a exceção **sobe a pilha de chamadas** até encerrar o programa com stack trace:

```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
    at Main.main(Main.java:3)
```

---

## 2. Hierarquia de exceções

```
Throwable
├── Erro   ← problemas graves da JVM — não trate
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── VirtualMachineError
└── Exception
    ├── RuntimeException ← unchecked — não obriga tratamento
    │   ├── NullPointerException
    │   ├── IllegalArgumentException
    │   ├── IndexOutOfBoundsException
    │   ├── ArithmeticException
    │   ├── ClassCastException
    │   └── UnsupportedOperationException
    └── (outras Exception) ← checked — obriga tratamento
        ├── IOException
        ├── SQLException
        ├── FileNotFoundException
        └── ParseException
```

---

## 3. Checked vs Unchecked

|  | Checked | Unchecked |
| --- | --- | --- |
| Herda de | `Exception` (direto) | `RuntimeException` |
| Compilador exige tratamento | ✅ sim | ❌ não |
| Quando ocorre | Situações previsíveis externas | Bugs de programação |
| Exemplos | `IOException`, `SQLException` | `NullPointerException`, `IllegalArgumentException` |

```java
// checked — compilador não deixa compilar sem tratar
FileReader reader = new FileReader("arquivo.txt"); // ❌ erro de compilação

// unchecked — compila, mas pode falhar em runtime
String s = null;
s.length(); // compila, mas NullPointerException em runtime
```

---

## 4. try / catch / finally

```java
try {
    // código que pode lançar exceção
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    // trata a exceção específica
    System.out.println("Erro: " + e.getMessage());
} finally {
    // sempre executa — com ou sem exceção
    System.out.println("Bloco finally sempre roda");
}
```

Múltiplos catch:

```java
try {
    String texto = null;
    int[] array = new int[3];

    texto.length();    // pode lançar NullPointerException
    int x = array[5]; // pode lançar ArrayIndexOutOfBoundsException

} catch (NullPointerException e) {
    System.out.println("Referência nula: " + e.getMessage());
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Índice inválido: " + e.getMessage());
} catch (Exception e) {
    // captura qualquer outra exceção — sempre por último
    System.out.println("Erro genérico: " + e.getMessage());
}
```

Multi-catch — mesmo tratamento para tipos diferentes (Java 7+):

```java
try {
    // código
} catch (NullPointerException | IllegalArgumentException e) {
    System.out.println("Erro de argumento ou referência: " + e.getMessage());
}
```

---

## 5. throws — declarando exceções checked

Quando um método não trata a exceção, ele declara que pode lançá-la:

```java
// avisa quem chamar que pode lançar IOException
public static String lerArquivo(String caminho) throws IOException {
    FileReader reader = new FileReader(caminho); // checked
    // ...
    return "";
}

// quem chama precisa tratar
public static void main(String[] args) {
    try {
        String conteudo = lerArquivo("dados.txt");
    } catch (IOException e) {
        System.out.println("Arquivo não encontrado: " + e.getMessage());
    }
}
```

---

## 6. throw — lançando exceções

```java
public static double calcularDesconto(double preco, double percentual) {
    if (preco < 0) {
        throw new IllegalArgumentException("Preço não pode ser negativo: " + preco);
    }
    if (percentual < 0 || percentual > 1) {
        throw new IllegalArgumentException("Percentual deve ser entre 0 e 1: " + percentual);
    }
    return preco * (1 - percentual);
}
```

```java
calcularDesconto(-100, 0.15); // IllegalArgumentException: Preço não pode ser negativo: -100.0
calcularDesconto(100, 1.5);   // IllegalArgumentException: Percentual deve ser entre 0 e 1: 1.5
```

---

## 7. Exceções customizadas

Você cria suas próprias exceções para representar erros do domínio da aplicação:

### Unchecked customizada

```java
// extends RuntimeException — não obriga tratamento
public class PlanoInvalidoException extends RuntimeException {

    public PlanoInvalidoException(String plano) {
        super("Plano inválido: '" + plano + "'. Use: starter, pro ou enterprise.");
    }

    public PlanoInvalidoException(String plano, Throwable causa) {
        super("Plano inválido: '" + plano + "'", causa);
    }
}
```

### Checked customizada

```java
// extends Exception — obriga tratamento
public class LimiteUsuariosException extends Exception {

    private final int limite;
    private final int atual;

    public LimiteUsuariosException(int limite, int atual) {
        super(String.format("Limite de usuários atingido: %d/%d", atual, limite));
        this.limite = limite;
        this.atual = atual;
    }

    public int getLimite() { return limite; }
    public int getAtual() { return atual; }
}
```

### Usando as exceções customizadas

```java
public class PlanoService {

    private static final List<String> PLANOS_VALIDOS =
        Arrays.asList("starter", "pro", "enterprise");

    public static double getMensalidade(String plano) {
        if (!PLANOS_VALIDOS.contains(plano.toLowerCase())) {
            throw new PlanoInvalidoException(plano); // unchecked — não precisa declarar
        }
        return switch (plano.toLowerCase()) {
            case "starter" -> 49.90;
            case "pro" -> 149.90;
            case "enterprise" -> 499.90;
            default -> 0;
        };
    }
}

public class EmpresaService {

    public static void adicionarUsuario(Empresa empresa) throws LimiteUsuariosException {
        if (empresa.getTotalUsuarios() >= empresa.getPlano().getLimiteUsuarios()) {
            throw new LimiteUsuariosException(
                empresa.getPlano().getLimiteUsuarios(),
                empresa.getTotalUsuarios()
            );
        }
        empresa.incrementarUsuarios();
    }
}
```

```java
// unchecked — pode ou não tratar
try {
    double preco = PlanoService.getMensalidade("vip");
} catch (PlanoInvalidoException e) {
    System.out.println(e.getMessage());
}

// checked — obrigado a tratar
try {
    EmpresaService.adicionarUsuario(empresa);
} catch (LimiteUsuariosException e) {
    System.out.printf("Erro: %s (limite: %d, atual: %d)%n",
        e.getMessage(), e.getLimite(), e.getAtual());
}
```

---

## 8. try-with-resources (Java 7+)

Para recursos que precisam ser fechados (arquivos, conexões):

```java
// sem try-with-resources — verboso e frágil
FileReader reader = null;
try {
    reader = new FileReader("arquivo.txt");
    // usa reader
} catch (IOException e) {
    System.out.println(e.getMessage());
} finally {
    if (reader != null) {
        try {
            reader.close(); // pode lançar outra IOException
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// com try-with-resources — fecha automaticamente
try (FileReader reader = new FileReader("arquivo.txt")) {
    // usa reader — fecha automaticamente no final
} catch (IOException e) {
    System.out.println(e.getMessage());
}
```

Funciona com qualquer classe que implementa `AutoCloseable`.

---

## 9. Boas práticas

```java
// ✅ exceção específica, não genérica
} catch (NullPointerException e) { ... }   // bom
} catch (Exception e) { ... }              // evite — muito genérico

// ✅ mensagem de erro informativa
throw new IllegalArgumentException("Orçamento deve ser positivo, recebido: " + orcamento);

// ❌ nunca ignore exceções silenciosamente
} catch (Exception e) { } // bloco vazio — péssima prática

// ✅ preserve a causa original ao relançar
} catch (IOException e) {
    throw new RuntimeException("Erro ao ler configuração", e); // e = causa original
}

// ✅ prefira unchecked para erros de programação
// ✅ prefira checked para erros recuperáveis que o chamador deve tratar

// ❌ não use exceções para controle de fluxo
try {
    return lista.get(indice); // não use exceção para verificar índice
} catch (IndexOutOfBoundsException e) {
    return null; // use lista.size() antes
}
```

---

## 10. Informações úteis do objeto exceção

```java
try {
    int[] arr = new int[3];
    arr[5] = 10;
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println(e.getMessage());        // "Index 5 out of bounds for length 3"
    System.out.println(e.getClass().getName()); // "java.lang.ArrayIndexOutOfBoundsException"
    e.printStackTrace();                        // imprime o stack trace completo
}
```