## 1. Introdução

Você já iterou sobre coleções com `for-each` — mas como Java sabe como percorrer qualquer coleção? Por baixo dos panos existe um mecanismo padronizado: `Iterable` e `Iterator`.

```java
// isso que você escreve
for (String item : lista) {
    System.out.println(item);
}

// isso que o compilador gera
Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    String item = it.next();
    System.out.println(item);
}
```

---

## 2. A interface Iterator

```java
public interface Iterator<E> {
    boolean hasNext(); // tem próximo elemento?
    E next();          // retorna o próximo e avança o cursor
    void remove();     // remove o elemento atual (opcional)
}
```

```java
List<String> planos = new ArrayList<>();
planos.add("starter");
planos.add("pro");
planos.add("enterprise");

Iterator<String> it = planos.iterator();

while (it.hasNext()) {
    String plano = it.next();
    System.out.println(plano);
}
```

---

## 3. A interface Iterable

Qualquer classe que implementa `Iterable` pode ser usada no `for-each`:

```java
public interface Iterable<T> {
    Iterator<T> iterator(); // retorna um Iterator para percorrer os elementos
}
```

`ArrayList`, `HashSet`, `HashMap.entrySet()`, arrays — todos implementam `Iterable`, por isso funcionam no `for-each`.

---

## 4. Por que usar Iterator diretamente

O caso mais importante: **remover elementos durante a iteração** sem `ConcurrentModificationException`:

```java
List<String> emails = new ArrayList<>();
emails.add("jeff@cerne.com");
emails.add("spam@temp.com");
emails.add("ana@cerne.com");
emails.add("lixo@temp.com");

// ❌ erro em runtime — modifica a lista enquanto for-each itera
for (String email : emails) {
    if (email.endsWith("@temp.com")) {
        emails.remove(email); // ConcurrentModificationException
    }
}

// Quando você usa um for-each (o famoso Enhanced For Loop), o Java o transforma magicamente em um Iterator.
// O código que você escreveu é compilado para algo parecido com isto:
Iterator<String> it = emails.iterator();
while (it.hasNext()) {
    String email = it.next();
    if (email.endsWith("@temp.com")) {
        emails.remove(email); // O erro acontece aqui!
    }
}

// Por que o ConcurrentModificationException acontece?

// Toda lista no Java (como o ArrayList) possui um contador interno chamado modCount (contador de modificações).
// > A Promessa: Quando o Iterator é criado, ele tira uma "foto" do valor atual do modCount e a guarda (chamamos de expectedModCount).
// > A Traição: Quando você chama emails.remove(email), você está modificando a lista diretamente, o que aumenta o modCount.
// > O Flagrante: Na próxima iteração, o Iterator chama o método next(). A primeira coisa que esse método faz é checar: "O modCount atual ainda é igual ao expectedModCount que eu tinha no início?".
// > A Falha: Como você alterou a lista por fora do Iterator, os números não batem. O Java entra em pânico para evitar comportamentos imprevisíveis (como pular elementos ou ler dados nulos) e lança a exceção.

// Existem três (3) formas principais de lidar com isso, dependendo da versão do Java que você está usando e da sua preferência de estilo:

// 1. O Jeito Moderno (Java 8+)
emails.removeIf(email -> email.endsWith("@temp.com"));

// 2. Usando o Iterator Explicitamente
// ✅ correto — Iterator tem permissão para remover durante iteração
Iterator<String> it = emails.iterator();
while (it.hasNext()) {
    String email = it.next();
    if (email.endsWith("@temp.com")) {
        it.remove(); // seguro — remove o elemento atual
    }
}

System.out.println(emails); // [jeff@cerne.com, ana@cerne.com]


// 3. Criar uma Lista Auxiliar

List<String> paraRemover = new ArrayList<>();
for (String email : emails) {
    if (email.endsWith("@temp.com")) {
        paraRemover.add(email);
    }
}
emails.removeAll(paraRemover);
```

---

## 5. ListIterator — bidirecional

`ListIterator` estende `Iterator` — permite navegar para frente e para trás, e modificar elementos:

```java
public interface ListIterator<E> extends Iterator<E> {
    boolean hasNext();
    E next();
    boolean hasPrevious(); // tem anterior?
    E previous();          // retorna o anterior e recua o cursor
    int nextIndex();       // índice do próximo
    int previousIndex();   // índice do anterior
    void remove();         // remove o elemento atual
    void set(E e);         // substitui o elemento atual
    void add(E e);         // insere antes do próximo
}
```

```java
List<String> planos = new ArrayList<>();
planos.add("starter");
planos.add("pro");
planos.add("enterprise");

ListIterator<String> lit = planos.listIterator();

// para frente
System.out.println("→ Para frente:");
while (lit.hasNext()) {
    System.out.println(lit.nextIndex() + ": " + lit.next());
}

// para trás — cursor já está no final
System.out.println("← Para trás:");
while (lit.hasPrevious()) {
    System.out.println(lit.previousIndex() + ": " + lit.previous());
}
```

Modificando durante a iteração com `ListIterator`:

```java
List<Double> precos = new ArrayList<>();
precos.add(49.90);
precos.add(149.90);
precos.add(499.90);

// aplica 10% de desconto em todos
ListIterator<Double> lit = precos.listIterator();
while (lit.hasNext()) {
    Double preco = lit.next();
    lit.set(preco * 0.9); // substitui o elemento atual
}

System.out.println(precos); // [44.91, 134.91, 449.91]
```

---

## 6. Criando sua própria classe Iterable

Aqui fica claro como tudo funciona por baixo. Vamos criar uma coleção customizada que funciona no `for-each`:

```java
public class FilaCampanhas implements Iterable<String> {

    private String[] campanhas;
    private int tamanho;

    public FilaCampanhas(int capacidade) {
        campanhas = new String[capacidade];
        tamanho = 0;
    }

    public void adicionar(String campanha) {
        if (tamanho < campanhas.length) {
            campanhas[tamanho++] = campanha;
        }
    }

    // obrigatório — implementa Iterable
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < tamanho;
            }

            @Override
            public String next() {
                if (!hasNext()) throw new java.util.NoSuchElementException();
                return campanhas[indice++];
            }
        };
    }
}
```

```java
FilaCampanhas fila = new FilaCampanhas(5);
fila.adicionar("Black Friday");
fila.adicionar("Verão");
fila.adicionar("Remarketing");

// funciona no for-each porque implementa Iterable
for (String campanha : fila) {
    System.out.println(campanha);
}
```

---

## 7. Iterator com estado — exemplo avançado

Um Iterator que filtra elementos durante a iteração:

```java
public class IteratorFiltrado implements Iterator<String> {

    private final List<String> lista;
    private final String filtro;
    private int indice = 0;
    private String proximo = null;

    public IteratorFiltrado(List<String> lista, String filtro) {
        this.lista = lista;
        this.filtro = filtro;
        avancarParaProximo();
    }

    private void avancarParaProximo() {
        proximo = null;
        while (indice < lista.size()) {
            String candidato = lista.get(indice++);
            if (candidato.contains(filtro)) {
                proximo = candidato;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return proximo != null;
    }

    @Override
    public String next() {
        String resultado = proximo;
        avancarParaProximo();
        return resultado;
    }
}
```

```java
List<String> campanhas = Arrays.asList(
    "Meta Black Friday",
    "Google Remarketing",
    "Meta Verão",
    "TikTok Lançamento",
    "Meta Natal"
);

Iterator<String> metaIterator = new IteratorFiltrado(campanhas, "Meta");
while (metaIterator.hasNext()) {
    System.out.println(metaIterator.next());
}
// Meta Black Friday
// Meta Verão
// Meta Natal
```

---

## 8. Iterable vs Iterator — diferença central

|  | `Iterable<T>` | `Iterator<T>` |
| --- | --- | --- |
| O que é | A coleção que pode ser percorrida | O cursor que percorre |
| Método principal | `iterator()` | `hasNext()`, `next()` |
| Pode reusar | ✅ chama `iterator()` várias vezes | ❌ cursor de uso único |
| Habilita | `for-each` | iteração manual com controle |

```java
List<String> lista = new ArrayList<>(Arrays.asList("a", "b", "c"));

// Iterable — pode iterar várias vezes
for (String s : lista) { System.out.print(s); } // abc
for (String s : lista) { System.out.print(s); } // abc — funciona de novo

// Iterator — cursor de uso único
Iterator<String> it = lista.iterator();
while (it.hasNext()) { System.out.print(it.next()); } // abc
while (it.hasNext()) { System.out.print(it.next()); } // nada — cursor no fim
```