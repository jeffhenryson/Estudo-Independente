// ## Exercício 3 — Operações de conjunto

// Dado o contexto do **Cerne**:

// ```java
// Set<String> skillsVaga = new HashSet<>(Arrays.asList(
//     "Java", "Spring Boot", "PostgreSQL", "Docker", "React"
// ));

// Set<String> skillsCanditado = new HashSet<>(Arrays.asList(
//     "Java", "Python", "PostgreSQL", "Docker", "AWS"
// ));
// ```

// 1. Encontre as skills que o candidato **tem e a vaga exige** (interseção)
// 2. Encontre as skills que a vaga exige mas o candidato **não tem** (diferença)
// 3. Encontre todas as skills envolvidas nos dois conjuntos (união)
// 4. Verifique se o candidato tem **todas** as skills da vaga (`containsAll`)
// 5. Imprima um resumo:
// ```
// Skills em comum: [Java, PostgreSQL, Docker]
// Skills faltando: [Spring Boot, React]
// Total de skills únicas: 7
// Aprovado para próxima fase? false

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercicio03 {
    public static void main(String[] args) {

        Set<String> skillsVaga = new HashSet<>(Arrays.asList(
            "Java", "Spring Boot", "PostgreSQL", "Docker", "React"
        ));

        Set<String> skillsCandidato = new HashSet<>(Arrays.asList(
            "Java", "Python", "PostgreSQL", "Docker", "AWS"
        ));

        Set<String> skillsEmComum = new HashSet<>(skillsVaga);
        skillsEmComum.retainAll(skillsCandidato);

        Set<String> skillsFaltando = new HashSet<>(skillsVaga);
        skillsFaltando.removeAll(skillsCandidato);

        Set<String> todasSkills = new HashSet<>(skillsVaga);
        todasSkills.addAll(skillsCandidato);

        boolean aprovado = skillsVaga.containsAll(skillsCandidato);

        System.out.println("Skills em comum: " + skillsEmComum);
        System.out.println("Skills faltando: " + skillsFaltando);
        System.out.println("Total de skills únicas: " + todasSkills.size());
        System.out.println("Aprovado para próxima fase? " + aprovado);
    }
}
