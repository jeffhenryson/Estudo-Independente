// ## Exercício 6 — Desafio

// Construa um gerenciador de campanhas do **Cerne** usando tudo do ArrayList:

// 1. Crie um `List<String>` de campanhas ativas
// 2. Menu `do-while` com as opções:
//    - `1 - Adicionar campanha` → lê o nome e adiciona
//    - `2 - Listar campanhas` → exibe todas com índice
//    - `3 - Remover campanha` → lê o índice e remove
//    - `4 - Buscar campanha` → lê o nome e informa se existe e em qual índice
//    - `5 - Ordenar campanhas` → ordena alfabeticamente e exibe
//    - `0 - Sair`
// 3. Bloqueie remoção se a lista estiver vazia
// 4. Bloqueie adição de campanha com nome já existente usando `contains()`
// 5. Use `removeIf()` em vez de `remove()` na opção de remoção por índice

import java.util.ArrayList;
import java.util.List;

public class Exercicio06 {
    public static void main(String[] args) {

        List<String> campanhas = new ArrayList<>();

        // 2. Menu `do-while` com as opções:
        int opcao;
        do {
            System.out.println("\nMenu de Gerenciamento de Campanhas do Cerne:");
            System.out.println("1 - Adicionar campanha");
            System.out.println("2 - Listar campanhas");
            System.out.println("3 - Remover campanha");
            System.out.println("4 - Buscar campanha");
            System.out.println("5 - Ordenar campanhas");
            System.out.println("0 - Sair");
            opcao = Integer.parseInt(System.console().readLine("Escolha uma opção: "));
            switch (opcao) {
                case 1:
                    String nomeCampanha = System.console().readLine("Digite o nome da campanha: ");
                    if (campanhas.contains(nomeCampanha)) {
                        System.out.println("Campanha já existe! Não pode adicionar.");
                    } else {
                        campanhas.add(nomeCampanha);
                        System.out.println("Campanha adicionada com sucesso!");
                    }
                    break;
                case 2:
                    if (campanhas.isEmpty()) {
                        System.out.println("Nenhuma campanha ativa.");
                    } else {
                        System.out.println("Campanhas ativas:");
                        for (int i = 0; i < campanhas.size(); i++) {
                            System.out.println(i + ": " + campanhas.get(i));
                        }
                    }
                    break;
                case 3:
                    if (campanhas.isEmpty()) {
                        System.out.println("Nenhuma campanha para remover.");
                    } else {
                        int indiceRemover = Integer.parseInt(System.console().readLine("Digite o índice da campanha a remover: "));
                        if (indiceRemover >= 0 && indiceRemover < campanhas.size()) {
                            String campanhaRemovida = campanhas.get(indiceRemover);
                            campanhas.removeIf(c -> c.equals(campanhaRemovida));
                            System.out.println("Campanha removida com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                    }
                    break;
                case 4:
                    String nomeBuscar = System.console().readLine("Digite o nome da campanha a buscar: ");
                    if (campanhas.contains(nomeBuscar)) {
                        int indiceEncontrado = campanhas.indexOf(nomeBuscar);
                        System.out.println("Campanha encontrada no índice: " + indiceEncontrado);
                    } else {
                        System.out.println("Campanha não encontrada.");
                    }
                    break;
                case 5:
                    campanhas.sort(String::compareTo);
                    System.out.println("Campanhas ordenadas alfabeticamente:");
                    for (String campanha : campanhas) {
                        System.out.println(campanha);
                    }
                    break;
                case 0:
                    System.out.println("Saindo do gerenciador de campanhas. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}
