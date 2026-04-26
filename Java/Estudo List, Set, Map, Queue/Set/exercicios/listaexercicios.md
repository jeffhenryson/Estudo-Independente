# Exercícios — Set

---

## Exercício 1 — HashSet básico

Crie um `HashSet<String>` de tags de campanhas e:

1. Adicione 6 tags, sendo 2 delas duplicatas intencionais
2. Capture o retorno booleano do `add()` e imprima se cada inserção foi bem sucedida ou não
3. Imprima o tamanho antes e depois das inserções duplicadas
4. Verifique se uma tag específica existe
5. Remova uma tag e confirme a remoção com `contains()`
6. Itere e imprima todas as tags restantes

---

## Exercício 2 — Comparando as três implementações

Use o mesmo conjunto de dados nos três tipos de Set e observe as diferenças:

```java
String[] plataformas = {"Meta Ads", "Google Ads", "TikTok Ads", "Meta Ads", "Google Ads", "LinkedIn Ads"};
```

1. Insira em `HashSet`, `LinkedHashSet` e `TreeSet`
2. Imprima os três e observe a diferença de ordem
3. Confirme que todos têm o mesmo `size()`
4. Explique com comentários no código por que cada um imprime diferente

---

## Exercício 3 — Operações de conjunto

Dado o contexto do **Cerne**:

```java
Set<String> skillsVaga = new HashSet<>(Arrays.asList(
    "Java", "Spring Boot", "PostgreSQL", "Docker", "React"
));

Set<String> skillsCanditado = new HashSet<>(Arrays.asList(
    "Java", "Python", "PostgreSQL", "Docker", "AWS"
));
```

1. Encontre as skills que o candidato **tem e a vaga exige** (interseção)
2. Encontre as skills que a vaga exige mas o candidato **não tem** (diferença)
3. Encontre todas as skills envolvidas nos dois conjuntos (união)
4. Verifique se o candidato tem **todas** as skills da vaga (`containsAll`)
5. Imprima um resumo:
```
Skills em comum: [Java, PostgreSQL, Docker]
Skills faltando: [Spring Boot, React]
Total de skills únicas: 7
Aprovado para próxima fase? false
```

---

## Exercício 4 — TreeSet e navegação

Crie um `TreeSet<Integer>` com os orçamentos de campanhas em reais:

```java
// valores para adicionar:
// 5000, 1500, 8000, 3000, 12000, 750, 4500
```

1. Adicione todos e imprima o set ordenado
2. Imprima o menor e o maior orçamento com `first()` e `last()`
3. Use `floor()` para encontrar o maior orçamento **menor ou igual** a 4000
4. Use `ceiling()` para encontrar o menor orçamento **maior ou igual** a 4000
5. Use `headSet()` para listar campanhas com orçamento abaixo de 5000
6. Use `tailSet()` para listar campanhas com orçamento a partir de 5000
7. Use `subSet()` para listar campanhas entre 2000 e 8000

---

## Exercício 5 — Conversão List ↔ Set

```java
List<String> emails = new ArrayList<>(Arrays.asList(
    "jeff@cerne.com",
    "ana@cerne.com",
    "jeff@cerne.com",
    "bob@cerne.com",
    "ana@cerne.com",
    "carlos@cerne.com"
));
```

1. Imprima o tamanho original da List com duplicatas
2. Converta para `HashSet` para remover duplicatas
3. Converta para `LinkedHashSet` e compare — a ordem de inserção é mantida?
4. Converta o Set de volta para List
5. Ordene a List final com `Collections.sort()`
6. Imprima a List final e o tamanho

---

## Exercício 6 — Desafio

Construa um sistema de controle de acesso do **Cerne** usando Sets:

**Estrutura:**
- `Set<String>` de emails cadastrados — evita duplicatas
- `Set<String>` de admins — subconjunto dos cadastrados
- `Set<String>` de usuários bloqueados

**Menu `do-while`:**
1. Cadastrar usuário → adiciona email no set de cadastrados
   - Bloqueia se email já existir
   - Informa se foi adicionado com o retorno do `add()`
2. Promover a admin → move email para o set de admins
   - Só promove se o email estiver cadastrado
3. Bloquear usuário → adiciona no set de bloqueados
   - Só bloqueia se estiver cadastrado e não for admin
4. Verificar acesso → dado um email informa:
   - Se está bloqueado → `"Acesso negado"`
   - Se é admin → `"Acesso admin"`
   - Se é cadastrado → `"Acesso padrão"`
   - Se não existe → `"Usuário não encontrado"`
5. Exibir estatísticas:
   - Total de usuários cadastrados
   - Lista de admins (use `LinkedHashSet` para manter ordem)
   - Lista de bloqueados
   - Usuários ativos (cadastrados - bloqueados) usando operação de conjunto
0. Sair

---