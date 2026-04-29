### Conteúdo

Antes de Generics (Java 1.4), coleções aceitavam qualquer coisa:

```java
// sem Generics — perigoso
List lista = new ArrayList();
lista.add("texto");
lista.add(42);
lista.add(true);

String s = (String) lista.get(1); // ❌ ClassCastException em runtime — 42 não é String
```

Com Generics o erro aparece em **tempo de compilação**, não em runtime:

```java
// com Generics — seguro
List<String> lista = new ArrayList<>();
lista.add("texto");
lista.add(42);    // ❌ erro de compilação — detectado antes de rodar
```

---

## 2. Sintaxe básica

O `<T>` é o **parâmetro de tipo** — um placeholder que será substituído pelo tipo real:

```java
// T = Type — convenção mais comum
// E = Element — usado em coleções
// K = Key, V = Value — usados em Map
// N = Number — para tipos numéricos
// ? = wildcard — qualquer tipo

List<String>           // T = String
Map<String, Double>    // K = String, V = Double
Optional<Campanha>     // T = Campanha
```

---

## 3. Classe genérica

```java
// sem Generics — só funciona com String
public class Caixa {
    private String conteudo;

    public void guardar(String item) { this.conteudo = item; }
    public String pegar() { return conteudo; }
}

// com Generics — funciona com qualquer tipo
public class Caixa<T> {
    private T conteudo;

    public void guardar(T item) { this.conteudo = item; }
    public T pegar() { return conteudo; }
}
```

```java
Caixa<String> caixaTexto = new Caixa<>();
caixaTexto.guardar("Campanha Black Friday");
String texto = caixaTexto.pegar(); // sem cast

Caixa<Double> caixaNumero = new Caixa<>();
caixaNumero.guardar(149.90);
Double preco = caixaNumero.pegar(); // sem cast

Caixa<Campanha> caixaCampanha = new Caixa<>();
caixaCampanha.guardar(new Campanha("Black Friday", "Meta Ads", 1));
```

---

## 4. Múltiplos parâmetros de tipo

```java
public class Par<K, V> {
    private K chave;
    private V valor;

    public Par(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() { return chave; }
    public V getValor() { return valor; }

    @Override
    public String toString() {
        return chave + " → " + valor;
    }
}
```

```java
Par<String, Double> preco = new Par<>("pro", 149.90);
Par<String, Integer> limite = new Par<>("starter", 5);
Par<Integer, String> codigo = new Par<>(42, "ativo");

System.out.println(preco);   // pro → 149.9
System.out.println(limite);  // starter → 5
```

---

## 5. Método genérico

Você pode ter métodos genéricos independente da classe ser genérica ou não:

```java
public class Utilitarios {

    // método genérico — T declarado antes do retorno
    public static <T> void imprimir(T item) {
        System.out.println(item);
    }

    // retorna o maior de dois comparáveis
    public static <T extends Comparable<T>> T maior(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    // troca dois elementos de posição em um array
    public static <T> void trocar(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
```

```java
Utilitarios.imprimir("Jeff");        // funciona com String
Utilitarios.imprimir(42);            // funciona com Integer
Utilitarios.imprimir(3.14);          // funciona com Double

System.out.println(Utilitarios.maior(10, 20));        // 20
System.out.println(Utilitarios.maior("Ana", "Bob"));  // Bob

String[] nomes = {"Carlos", "Ana", "Bob"};
Utilitarios.trocar(nomes, 0, 2);
System.out.println(Arrays.toString(nomes)); // [Bob, Ana, Carlos]
```

---

## 6. Bounded type parameters — limitando o tipo

`extends` restringe quais tipos são aceitos:

```java
// só aceita Number ou subclasses (Integer, Double, Float...)
public static <T extends Number> double somar(List<T> lista) {
    double total = 0;
    for (T item : lista) {
        total += item.doubleValue();
    }
    return total;
}
```

```java
List<Integer> inteiros = Arrays.asList(1, 2, 3, 4, 5);
List<Double> decimais = Arrays.asList(1.5, 2.5, 3.5);

System.out.println(somar(inteiros)); // 15.0
System.out.println(somar(decimais)); // 7.5

// List<String> textos = Arrays.asList("a", "b");
// somar(textos); // ❌ erro de compilação — String não é Number
```

Múltiplos bounds — tipo deve implementar várias coisas:

```java
// T deve ser Comparable E Serializable
public static <T extends Comparable<T> & java.io.Serializable> T minimo(T a, T b) {
    return a.compareTo(b) <= 0 ? a : b;
}
```

---

## 7. Wildcards — `?`

Wildcard representa um tipo desconhecido. Tem três formas:

```java
// ? — qualquer tipo (unbounded)
public static void imprimirLista(List<?> lista) {
    for (Object item : lista) {
        System.out.println(item);
    }
}

imprimirLista(new ArrayList<String>());   // ✅
imprimirLista(new ArrayList<Integer>());  // ✅
imprimirLista(new ArrayList<Campanha>()); // ✅
```

```java
// ? extends T — upper bounded — T ou subtipos (leitura)
public static double somarNumeros(List<? extends Number> lista) {
    double total = 0;
    for (Number n : lista) {
        total += n.doubleValue();
    }
    return total;
}

somarNumeros(new ArrayList<Integer>()); // ✅
somarNumeros(new ArrayList<Double>());  // ✅
```

```java
// ? super T — lower bounded — T ou supertipos (escrita)
public static void adicionarNumeros(List<? super Integer> lista) {
    lista.add(1);
    lista.add(2);
    lista.add(3);
}

adicionarNumeros(new ArrayList<Integer>()); // ✅
adicionarNumeros(new ArrayList<Number>());  // ✅
adicionarNumeros(new ArrayList<Object>());  // ✅
```

> Regra **PECS** — Producer Extends, Consumer Super:
> 
> - Se a lista **produz** (você lê dela) → `? extends T`
> - Se a lista **consome** (você escreve nela) → `? super T`

---

## 8. Generics com interfaces e herança

```java
public interface Repositorio<T, ID> {
    void salvar(T entidade);
    T buscarPorId(ID id);
    List<T> buscarTodos();
    void deletar(ID id);
}

public class CampanhaRepositorio implements Repositorio<Campanha, Integer> {
    private List<Campanha> campanhas = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void salvar(Campanha c) {
        campanhas.add(c);
    }

    @Override
    public Campanha buscarPorId(Integer id) {
        return campanhas.stream()
            .filter(c -> c.getId() == id)
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Campanha> buscarTodos() {
        return new ArrayList<>(campanhas);
    }

    @Override
    public void deletar(Integer id) {
        campanhas.removeIf(c -> c.getId() == id);
    }
}
```

> Esse padrão é exatamente o que o **Spring Data JPA** usa — `JpaRepository<Entidade, TipoDoId>`. Você já está vendo o fundamento do que usa no Cerne.
> 

---

## 9. Restrições dos Generics

```java
// ❌ não pode instanciar T diretamente
public class Caixa<T> {
    T item = new T(); // erro — Java apaga o tipo em runtime (type erasure)
}

// ❌ não pode criar array de tipo genérico
T[] array = new T[10]; // erro

// ❌ não pode usar primitivos como tipo genérico
List<int> lista; // erro — use o wrapper
List<Integer> lista; // ✅

// ❌ não pode usar instanceof com tipo genérico
if (item instanceof T) { } // erro

// ✅ o que pode
List<Integer> lista = new ArrayList<>(); // wrapper types
Caixa<?> caixa;                          // wildcard
Class<T> tipo;                           // Class como referência
```

---