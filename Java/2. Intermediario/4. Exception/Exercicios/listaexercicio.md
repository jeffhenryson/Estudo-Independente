## Exercício 1 — try/catch básico

Dado o código abaixo, adicione tratamento de exceção para cada operação:

```java
public class Main {
    public static void main(String[] args) {
        // operação 1
        int[] numeros = {1, 2, 3};
        System.out.println(numeros[5]);

        // operação 2
        String texto = null;
        System.out.println(texto.length());

        // operação 3
        int resultado = 10 / 0;

        // operação 4
        String numero = "abc";
        int parsed = Integer.parseInt(numero);
    }
}
```

Para cada operação:

1. Envolva em try/catch com a exceção correta e específica
2. Imprima uma mensagem clara de erro com `e.getMessage()`
3. Adicione um bloco `finally` na operação 1 que imprima `"Operação 1 finalizada"`

---

## Exercício 2 — throws e checked exceptions

Crie um sistema de leitura de configuração:

1. Método `lerConfiguracao(String caminho) throws IOException` que:
    - Se o caminho for `null` ou vazio → lança `IllegalArgumentException`
    - Se o caminho não terminar com `".properties"` → lança `IllegalArgumentException`
    - Simula leitura — se caminho for `"config.properties"` retorna `"host=localhost;porta=5432"`
    - Qualquer outro caminho → lança `IOException` com mensagem `"Arquivo não encontrado: [caminho]"`
2. No `main`, chame o método com 4 cenários diferentes e trate cada exceção separadamente

---

## Exercício 3 — Exceção unchecked customizada

Crie o sistema de validação de planos do **Cerne**:

**Exceção:**

```java
class PlanoInvalidoException extends RuntimeException {
    // construtor com nome do plano
    // construtor com nome do plano e causa (Throwable)
    // getter para o plano inválido
}
```

**Serviço:**

```java
class PlanoService {
    // planos válidos: "starter", "pro", "enterprise"
    double getMensalidade(String plano)    // lança PlanoInvalidoException se inválido
    int getLimiteUsuarios(String plano)    // lança PlanoInvalidoException se inválido
    String getDescricao(String plano)      // lança PlanoInvalidoException se inválido
}
```

No `main`:

1. Teste com planos válidos e imprima as informações
2. Teste com plano inválido e capture `PlanoInvalidoException`
3. Mostre que não é obrigado a declarar `throws` — é unchecked

---

## Exercício 4 — Exceção checked customizada

Crie o sistema de limite de usuários do **Cerne**:

**Exceção:**

```java
class LimiteUsuariosException extends Exception {
    // atributos: limite, atual
    // construtor com limite e atual
    // getters para limite e atual
}
```

**Classe `Empresa`:**

- Atributos: `nome`, `plano`, `limiteUsuarios`, `totalUsuarios`
- Método `adicionarUsuario(String nome) throws LimiteUsuariosException`
    - Lança se `totalUsuarios >= limiteUsuarios`
- Método `listarUsuarios()`

No `main`:

1. Crie uma empresa com limite de 3 usuários
2. Adicione usuários até ultrapassar o limite
3. Capture `LimiteUsuariosException` e use `getLimite()` e `getAtual()` na mensagem
4. Mostre que o compilador **obriga** o tratamento por ser checked

---

## Exercício 5 — multi-catch e relançamento

```java
public static void processarEntrada(String valor, String[] array, int indice) {
    // pode lançar: NumberFormatException, ArrayIndexOutOfBoundsException, NullPointerException
}
```

1. Implemente o método que:
    - Converte `valor` para `int` com `Integer.parseInt()`
    - Acessa `array[indice]`
    - Chama `valor.toUpperCase()`
2. No `main`, chame com cenários que disparem cada exceção
3. Crie uma versão 2 do método que:
    - Usa multi-catch para `NumberFormatException | ArrayIndexOutOfBoundsException`
    - Relança como `IllegalArgumentException` preservando a causa original
    - Trata `NullPointerException` separadamente

---

## Exercício 6 — Desafio

Construa o sistema de cadastro de empresas do **Cerne** com tratamento completo de exceções:

**Exceções customizadas:**

```java
// unchecked
class EmailInvalidoException extends RuntimeException {
    // deve conter o email inválido
}

// unchecked
class EmpresaJaCadastradaException extends RuntimeException {
    // deve conter o nome da empresa
}

// checked
class LimitePlanoException extends Exception {
    // deve conter: plano, limite, atual
}
```

**Classe `CadastroService`:**

```java
class CadastroService {
    // Map<String, String> empresas — nome → email
    // Map<String, String> planos — nome → plano
    // Map<String, Integer> limites — plano → limite de empresas

    void cadastrarEmpresa(String nome, String email, String plano)
        throws LimitePlanoException
    // lança EmailInvalidoException se email não contém "@" e "."
    // lança EmpresaJaCadastradaException se nome já existe
    // lança PlanoInvalidoException se plano não é válido (reutilize do Ex 3)
    // lança LimitePlanoException se o plano atingiu limite de empresas

    void listarEmpresas()
    Map<String, Long> contagemPorPlano() // quantas empresas por plano
}
```

**No `main`:**

1. Cadastre empresas válidas de diferentes planos
2. Tente cadastrar email inválido → `EmailInvalidoException`
3. Tente cadastrar empresa duplicada → `EmpresaJaCadastradaException`
4. Tente cadastrar plano inválido → `PlanoInvalidoException`
5. Encha um plano até o limite e tente mais uma → `LimitePlanoException`
6. Ao final, liste todas as empresas e a contagem por plano

---