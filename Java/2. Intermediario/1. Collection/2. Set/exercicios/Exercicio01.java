// ## Exercício 1 — HashSet básico
// 
// Crie um `HashSet<String>` de tags de campanhas e:
// 
// 1. Adicione 6 tags, sendo 2 delas duplicatas intencionais
// 2. Capture o retorno booleano do `add()` e imprima se cada inserção foi bem sucedida ou não
// 3. Imprima o tamanho antes e depois das inserções duplicadas
// 4. Verifique se uma tag específica existe
// 5. Remova uma tag e confirme a remoção com `contains()`
// 6. Itere e imprima todas as tags restantes

import java.util.HashSet;


public class Exercicio01 {
    public static void main(String[] args) {
        HashSet<String> tags = new HashSet<>();

        String[] novasTags = {"promoção", "desconto", "oferta", "promoção", "novidade", "desconto"};
        for (String tag : novasTags) {
            boolean added = tags.add(tag);
            System.out.println("Adicionando '" + tag + "': " + (added ? "Sucesso" : "Duplicada"));
        }

        System.out.println("Tamanho do HashSet: " + tags.size());

        String tagEspecifica = "oferta";
        System.out.println("Existe a tag '" + tagEspecifica + "'? " + tags.contains(tagEspecifica));

        String tagParaRemover = "novidade";
        boolean removed = tags.remove(tagParaRemover);
        System.out.println("Removendo '" + tagParaRemover + "': " + (removed ? "Removida" : "Não encontrada"));
        System.out.println("Existe a tag '" + tagParaRemover + "'? " + tags.contains(tagParaRemover));

        System.out.println("Tags restantes:");
        for (String tag : tags) {
            System.out.println("- " + tag);
        }
    }
}
