// ## Exercício 5 — Record com coleção imutável

// Crie o record `Empresa` com `nome`, `plano` e `campanhas` (`List<String>`):

// 1. No construtor compacto use `List.copyOf(campanhas)` para garantir imutabilidade
// 2. Adicione método `totalCampanhas()`
// 3. Adicione método `temCampanha(String nome)` → `boolean`
// 4. Adicione método estático `criar(String nome, String plano)` → cria com lista vazia

// No `main`:

// 1. Crie empresa com lista mutável e tente modificar depois — mostre a exceção
// 2. Crie empresa com `criar()` e imprima
// 3. Verifique `temCampanha()` com valores existentes e inexistentes
// 4. Use como chave em `Map<Empresa, Double>` mapeando empresa → receita total

import java.util.List;
import java.util.Map;

public class Exercicio05 {
    public static void main(String[] args) {
        
        List<String> campanhasMutaveis = List.of("Campanha A", "Campanha B");
        Empresa empresa1 = new Empresa("Empresa 1", "Básico", campanhasMutaveis);
        
        try {
            campanhasMutaveis.add("Campanha C"); // Isso lançará UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Não é possível modificar a lista de campanhas: " + e.getMessage());
        }

        Empresa empresa2 = Empresa.criar("Empresa 2", "Premium");
        System.out.println(empresa2);

        System.out.println("Empresa 1 tem Campanha A? " + empresa1.temCampanha("Campanha A"));
        System.out.println("Empresa 1 tem Campanha C? " + empresa1.temCampanha("Campanha C"));

        Map<Empresa, Double> receitaPorEmpresa = Map.of(
            empresa1, 5000.00,
            empresa2, 7500.00
        );

        System.out.println("Receita da Empresa 1: " + receitaPorEmpresa.get(empresa1));
        System.out.println("Receita da Empresa 2: " + receitaPorEmpresa.get(empresa2));
    }
}

record Empresa(String nome, String plano, List<String> campanhas) {
    
    public Empresa {
        campanhas = List.copyOf(campanhas);
    }

    public int totalCampanhas() {
        return campanhas.size();
    }

    public boolean temCampanha(String nome) {
        return campanhas.contains(nome);
    }

    public static Empresa criar(String nome, String plano) {
        return new Empresa(nome, plano, List.of());
    }
}
