# Exercícios — Generics

---

## Exercício 1 — Classe genérica básica

Crie uma classe `Caixa<T>` com:

1. Atributo privado `conteudo` do tipo `T`
2. Método `guardar(T item)` — armazena o conteúdo
3. Método `pegar()` — retorna o conteúdo
4. Método `estaVazia()` — retorna `true` se conteúdo for `null`
5. Método `toString()` — retorna `"Caixa[conteudo=X]"`

No `main`, crie instâncias de `Caixa` com:
- `String`
- `Integer`
- `Double`
- Uma classe própria `Campanha` com `nome` e `plataforma`

---

## Exercício 2 — Múltiplos parâmetros de tipo

Crie uma classe `Resultado<T, E>` que representa o resultado de uma operação:

- Atributos: `T valor` (resultado em caso de sucesso) e `E erro` (em caso de falha)
- Construtor privado — crie dois factory methods estáticos:
  - `sucesso(T valor)` → cria resultado com valor, erro null
  - `falha(E erro)` → cria resultado com erro, valor null
- Métodos: `isSucesso()`, `getValor()`, `getErro()`, `toString()`

No `main`:
```java
Resultado<String, String> r1 = Resultado.sucesso("Campanha criada com sucesso");
Resultado<String, String> r2 = Resultado.falha("Orçamento insuficiente");

Resultado<Double, String> r3 = Resultado.sucesso(149.90);
Resultado<Double, String> r4 = Resultado.falha("Plano não encontrado");
```

---

## Exercício 3 — Método genérico

Crie uma classe `Utilitarios` com os métodos estáticos genéricos:

1. `<T> void imprimir(List<T> lista)` → imprime cada elemento com índice
2. `<T extends Comparable<T>> T maior(T a, T b)` → retorna o maior
3. `<T extends Comparable<T>> T maiorDaLista(List<T> lista)` → retorna o maior da lista
4. `<T> List<T> filtrar(List<T> lista, T valor)` → retorna nova lista sem o valor
5. `<T> void trocar(T[] array, int i, int j)` → troca dois elementos

Teste todos no `main` com tipos diferentes — `String`, `Integer`, `Double`.

---

## Exercício 4 — Bounded type parameters

Crie uma classe `Calculadora` com métodos que aceitam apenas `Number`:

1. `<T extends Number> double somar(List<T> lista)` → soma todos os elementos
2. `<T extends Number> double media(List<T> lista)` → calcula a média
3. `<T extends Number> T maiorNumero(List<T> lista)` → retorna o maior
4. `<T extends Number> T menorNumero(List<T> lista)` → retorna o menor

No `main`:
```java
List<Integer> inteiros = Arrays.asList(10, 30, 20, 50, 40);
List<Double> decimais = Arrays.asList(1.5, 3.5, 2.5, 5.5, 4.5);

// teste todos os métodos com as duas listas
```

---

## Exercício 5 — Interface genérica Repository

Implemente o padrão Repository com Generics:

**Interface:**
```java
interface Repositorio<T, ID> {
    void salvar(T entidade);
    T buscarPorId(ID id);
    List<T> buscarTodos();
    boolean deletar(ID id);
    int total();
}
```

**Classe `Campanha`:**
- Atributos: `int id`, `String nome`, `String plataforma`
- Construtor + getters + toString

**Classe `CampanhaRepositorio`** implements `Repositorio<Campanha, Integer>`:
- Use `List<Campanha>` internamente
- `salvar()` → adiciona na lista
- `buscarPorId()` → busca por id com for-each, retorna null se não achar
- `buscarTodos()` → retorna cópia da lista
- `deletar()` → remove por id, retorna true se removeu
- `total()` → retorna tamanho da lista

No `main`:
1. Salve 3 campanhas
2. Busque por id existente e inexistente
3. Liste todas
4. Delete uma e liste novamente

---

## Exercício 6 — Desafio

Construa um sistema genérico de cache simples para o **Cerne**:

**Classe `Cache<K, V>`:**
- Use `Map<K, V>` internamente
- Atributo `int capacidadeMaxima`
- Métodos:
  - `put(K chave, V valor)` → adiciona no cache
    - Se atingir capacidade máxima, remove a entrada mais antiga
  - `get(K chave)` → retorna o valor ou `null`
  - `contem(K chave)` → retorna boolean
  - `remover(K chave)` → remove entrada
  - `tamanho()` → retorna quantidade de entradas
  - `listar()` → imprime todas as entradas formatadas

**Restrição:** use `LinkedHashMap` internamente — ele mantém ordem de inserção, o que permite saber qual é a entrada mais antiga.

No `main`, crie três caches com tipos diferentes:

```java
// Cache de sessões de usuário
Cache<String, String> cacheSessoes = new Cache<>(3);
cacheSessoes.put("token-abc", "jeff@cerne.com");
cacheSessoes.put("token-def", "ana@cerne.com");
cacheSessoes.put("token-ghi", "bob@cerne.com");
cacheSessoes.put("token-jkl", "carlos@cerne.com"); // deve remover o mais antigo

// Cache de preços de planos
Cache<String, Double> cachePrecos = new Cache<>(2);
cachePrecos.put("pro", 149.90);
cachePrecos.put("enterprise", 499.90);

// Cache de configurações
Cache<String, Integer> cacheConfig = new Cache<>(5);
cacheConfig.put("timeout", 3000);
cacheConfig.put("maxUsuarios", 50);
```

---