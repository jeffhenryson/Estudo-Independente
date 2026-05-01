// ## Exercício 5 — Iterable vs Iterator na prática

// Responda sem rodar e explique:

// ```java
// List<String> lista = new ArrayList<>(Arrays.asList("a", "b", "c"));

// // Bloco 1
// for (String s : lista) { System.out.print(s); }
// System.out.println();
// for (String s : lista) { System.out.print(s); }
// System.out.println();

// // Bloco 2
// Iterator<String> it = lista.iterator();
// while (it.hasNext()) { System.out.print(it.next()); }
// System.out.println();
// while (it.hasNext()) { System.out.print(it.next()); }
// System.out.println();

// // Bloco 3
// Iterator<String> it2 = lista.iterator();
// System.out.println(it2.next());
// System.out.println(it2.next());
// it2.remove();
// System.out.println(lista);
// ```

// O que cada bloco imprime e por quê?

// **Resposta:**
// Bloco 1: Imprime "abc" duas vezes. O loop for-each utiliza o método iterator() da lista
//  para criar um novo iterador a cada iteração, permitindo que a lista seja percorrida
//  completamente em cada loop.

// Bloco 2: Imprime "abc" na primeira execução e nada na segunda. O iterador "it" é
//  criado uma vez e consumido completamente na primeira execução do while. Na segunda
//  execução, o iterador já está no final da lista, então hasNext() retorna false e nada é impresso.

// Bloco 3: Imprime "a" e "b", e depois "[c]". O iterador "it2" é criado e os dois primeiros
//  elementos "a" e "b" são consumidos. O método remove() é chamado, removendo o último elemento
//  retornado pelo iterador, que é "b". Assim,
