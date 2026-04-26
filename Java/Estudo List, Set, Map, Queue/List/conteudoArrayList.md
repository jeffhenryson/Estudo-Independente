# ☕ Java — Coleções: ArrayList

---

## 1. O que é e por que existe

```java
// array comum — tamanho fixo, dor de cabeça
String[] campanhas = new String[5];
// e se precisar de 6? Cria outro array, copia tudo... trabalhoso.

// ArrayList — cresce e encolhe automaticamente
List<String> campanhas = new ArrayList<>();
campanhas.add("Campanha Black Friday");
campanhas.add("Campanha Verão");
// adiciona quantos quiser
```

Internamente o ArrayList **é** um array — mas ele gerencia o redimensionamento automaticamente pra você.

---

## 2. Declaração

```java
import java.util.ArrayList;
import java.util.List;

// forma correta — tipo na esquerda é a interface List
List<String> nomes = new ArrayList<>();

// também funciona, mas menos flexível
ArrayList<String> nomes = new ArrayList<>();
```

> Sempre prefira declarar com a **interface** (`List`) na esquerda — você pode trocar a implementação sem mudar o resto do código. Isso é programar para interfaces, não implementações.

```java
// o <String> é o Generics — define o tipo dos elementos
// veremos Generics em profundidade mais à frente
List<String> nomes = new ArrayList<>();
List<Integer> numeros = new ArrayList<>();
List<Double> precos = new ArrayList<>();
List<Campanha> campanhas = new ArrayList<>(); // funciona com qualquer tipo
```

---

## 3. Adicionando elementos

```java
List<String> planos = new ArrayList<>();

// add no final — o mais comum
planos.add("starter");
planos.add("pro");
planos.add("enterprise");
// [starter, pro, enterprise]

// add em índice específico — empurra os outros pra frente
planos.add(1, "basic");
// [starter, basic, pro, enterprise]

// addAll — adiciona outra coleção inteira
List<String> extras = new ArrayList<>();
extras.add("vip");
extras.add("trial");
planos.addAll(extras);
// [starter, basic, pro, enterprise, vip, trial]

// addAll em índice específico
planos.addAll(2, extras);
```

---

## 4. Acessando elementos

```java
List<String> planos = new ArrayList<>();
planos.add("starter");
planos.add("pro");
planos.add("enterprise");

// get — acessa por índice
System.out.println(planos.get(0)); // "starter"
System.out.println(planos.get(2)); // "enterprise"

// size — quantidade de elementos
System.out.println(planos.size()); // 3

// primeiro e último
System.out.println(planos.get(0));                // primeiro
System.out.println(planos.get(planos.size() - 1)); // último

// indexOf — índice da primeira ocorrência (-1 se não existir)
System.out.println(planos.indexOf("pro"));        // 1
System.out.println(planos.indexOf("vip"));        // -1

// lastIndexOf — índice da última ocorrência
planos.add("pro"); // duplicata
System.out.println(planos.lastIndexOf("pro"));    // 3
```

---

## 5. Verificando elementos

```java
List<String> planos = new ArrayList<>();
planos.add("starter");
planos.add("pro");

// contains — existe na lista?
System.out.println(planos.contains("pro"));       // true
System.out.println(planos.contains("enterprise")); // false

// isEmpty — lista vazia?
System.out.println(planos.isEmpty());             // false

List<String> vazia = new ArrayList<>();
System.out.println(vazia.isEmpty());              // true

// containsAll — contém todos?
List<String> verificar = new ArrayList<>();
verificar.add("starter");
verificar.add("pro");
System.out.println(planos.containsAll(verificar)); // true
```

---

## 6. Modificando elementos

```java
List<String> planos = new ArrayList<>();
planos.add("starter");
planos.add("pro");
planos.add("enterprise");

// set — substitui no índice
planos.set(1, "business");
// [starter, business, enterprise]

System.out.println(planos.get(1)); // "business"
```

---

## 7. Removendo elementos

```java
List<String> planos = new ArrayList<>();
planos.add("starter");
planos.add("pro");
planos.add("enterprise");
planos.add("trial");

// remove por índice
planos.remove(0);
// [pro, enterprise, trial]

// remove por valor — remove a primeira ocorrência
planos.remove("trial");
// [pro, enterprise]

// removeAll — remove todos que existem em outra coleção
List<String> remover = new ArrayList<>();
remover.add("pro");
planos.removeAll(remover);
// [enterprise]

// clear — remove tudo
planos.clear();
System.out.println(planos.size()); // 0
```

> ⚠️ Cuidado com `remove` em lista de inteiros:

```java
List<Integer> numeros = new ArrayList<>();
numeros.add(10);
numeros.add(20);
numeros.add(30);

numeros.remove(1);   // remove por ÍNDICE → [10, 30]
numeros.remove(Integer.valueOf(10)); // remove por VALOR → [30]
```

---

## 8. Iterando

```java
List<String> planos = new ArrayList<>();
planos.add("starter");
planos.add("pro");
planos.add("enterprise");

// for-each — mais comum, quando não precisa do índice
for (String plano : planos) {
    System.out.println(plano);
}

// for tradicional — quando precisa do índice
for (int i = 0; i < planos.size(); i++) {
    System.out.printf("%d: %s%n", i, planos.get(i));
}

// forEach com lambda — veremos lambdas em profundidade depois
planos.forEach(plano -> System.out.println(plano));
```

---

## 9. Ordenando

```java
import java.util.Collections;
import java.util.Comparator;

List<String> planos = new ArrayList<>();
planos.add("enterprise");
planos.add("starter");
planos.add("pro");

// ordem alfabética
Collections.sort(planos);
System.out.println(planos); // [enterprise, pro, starter]

// ordem reversa
Collections.sort(planos, Comparator.reverseOrder());
System.out.println(planos); // [starter, pro, enterprise]

// sort com lambda — para objetos customizados
List<Double> precos = new ArrayList<>();
precos.add(499.90);
precos.add(49.90);
precos.add(149.90);

precos.sort((a, b) -> Double.compare(a, b)); // crescente
System.out.println(precos); // [49.9, 149.9, 499.9]
```

---

## 10. Convertendo

```java
// Array → ArrayList
String[] array = {"starter", "pro", "enterprise"};
List<String> lista = new ArrayList<>(Arrays.asList(array));

// ArrayList → Array
String[] novoArray = lista.toArray(new String[0]);

// subList — fatia da lista (como slice do Python)
List<String> sub = lista.subList(0, 2); // índice 0 até 1 (exclusive 2)
System.out.println(sub); // [starter, pro]
```

---

## 11. Armadilhas comuns

```java
// ❌ modificar lista enquanto itera com for-each — ConcurrentModificationException
for (String plano : planos) {
    if (plano.equals("trial")) {
        planos.remove(plano); // ❌ erro em runtime
    }
}

// ✅ use removeIf
planos.removeIf(plano -> plano.equals("trial"));

// ✅ ou itere com índice de trás pra frente
for (int i = planos.size() - 1; i >= 0; i--) {
    if (planos.get(i).equals("trial")) {
        planos.remove(i);
    }
}
```

---

## 12. Resumo dos métodos

| Método | O que faz |
|---|---|
| `add(e)` | Adiciona no final |
| `add(i, e)` | Adiciona no índice |
| `addAll(c)` | Adiciona coleção inteira |
| `get(i)` | Retorna elemento no índice |
| `set(i, e)` | Substitui no índice |
| `remove(i)` | Remove por índice |
| `remove(obj)` | Remove por valor |
| `contains(e)` | Verifica se existe |
| `indexOf(e)` | Índice da primeira ocorrência |
| `size()` | Quantidade de elementos |
| `isEmpty()` | Está vazia? |
| `clear()` | Remove tudo |
| `sort(comparator)` | Ordena |
| `subList(de, até)` | Fatia da lista |
| `toArray()` | Converte para array |

---