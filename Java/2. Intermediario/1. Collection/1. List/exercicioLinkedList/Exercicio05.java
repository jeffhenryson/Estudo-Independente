// ## Exercício 5 — ArrayList vs LinkedList

// Responda sem rodar e explique o porquê:

// ```java
// // Cenário A
// LinkedList<String> lista = new LinkedList<>();
// lista.add("a");
// lista.add("b");
// lista.add("c");

// lista.addFirst("z");
// System.out.println(lista.getFirst());
// System.out.println(lista.get(2));
// lista.removeLast();
// System.out.println(lista);

// Cenário B — qual estrutura é mais adequada e por quê?
// 1. Uma lista de produtos exibida em uma tabela paginada (muito get por índice)
// 2. Uma fila de emails para envio em massa (muito add no final, remove no início)
// 3. Um histórico de navegação com botão voltar (último a entrar, primeiro a sair)

// Cenário B
// 1. Para uma lista de produtos exibida em uma tabela paginada, a 
    // estrutura mais adequada seria um ArrayList, pois ele oferece acesso 
    // rápido por índice, o que é essencial para a exibição paginada. 
    // O ArrayList é otimizado para operações de leitura e acesso por índice, 
    // tornando-o ideal para esse cenário.
// 2. Para uma fila de emails para envio em massa, a estrutura mais adequada 
    // seria uma LinkedList, pois ela permite adições e remoções eficientes no início 
    // e no final da lista.
// 3. Para um histórico de navegação com botão voltar, a estrutura mais adequada 
    // seria uma LinkedList, pois ela permite adições e remoções eficientes no final 
    // da lista.

