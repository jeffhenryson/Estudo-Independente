// ## Exercício 6 — Desafio

// Construa um sistema de gestão de clientes do **Cerne** usando múltiplas coleções:

// **Estrutura:**

// - `Map<String, List<String>>` → chave = plano, valor = lista de nomes de empresas
// - `Set<String>` → emails já cadastrados (para evitar duplicatas)
// - `Queue<String>` → fila de onboarding (empresas aguardando ativação)

// **Funcionalidades via menu `do-while`:**

// 1. Cadastrar empresa → lê nome, email e plano
//     - Bloqueia se email já existir no Set
//     - Adiciona no Map pelo plano
//     - Adiciona na fila de onboarding
// 2. Listar empresas por plano → mostra o Map completo
// 3. Processar onboarding → remove e exibe o próximo da fila com `poll()`
// 4. Exibir estatísticas:
//     - Total de empresas por plano
//     - Total de emails cadastrados
//     - Quantidade na fila de onboarding
// 5. Sair

public class Exercicio06 {
    
}
