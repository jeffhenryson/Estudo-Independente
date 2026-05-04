// ## Exercício 4 — EnumSet e EnumMap

// Usando o enum `Plano` do exercício 2:

// 1. Crie um `EnumSet` com todos os planos usando `allOf()`
// 2. Crie um `EnumSet` só com `STARTER` e `PRO` usando `of()`
// 3. Crie um `EnumSet` com o complemento — só `ENTERPRISE`
// 4. Verifique se `PRO` está no set de starter+pro
// 5. Crie um `EnumMap<Plano, List<String>>` mapeando plano → lista de empresas
// 6. Adicione 2 empresas para cada plano
// 7. Itere o `EnumMap` e imprima plano + empresas formatado

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Exercicio04 {
    public static void main(String[] args) {
        // 1. EnumSet com todos os planos
        EnumSet<Plano> todosPlanos = EnumSet.allOf(Plano.class);
        System.out.println("Todos os planos: " + todosPlanos);

        // 2. EnumSet com STARTER e PRO
        EnumSet<Plano> starterPro = EnumSet.of(Plano.STARTER, Plano.PRO);
        System.out.println("Planos Starter e Pro: " + starterPro);

        // 3. EnumSet com complemento (ENTERPRISE)
        EnumSet<Plano> complemento = EnumSet.complementOf(starterPro);
        System.out.println("Complemento (Enterprise): " + complemento);

        // 4. Verificar se PRO está no set de starter+pro
        boolean proIncluido = starterPro.contains(Plano.PRO);
        System.out.println("PRO está no set de Starter+Pro? " + proIncluido);

        // 5. Criar EnumMap mapeando plano → lista de empresas
        EnumMap<Plano, List<String>> mapaEmpresas = new EnumMap<>(Plano.class);

        // 6. Adicionar 2 empresas para cada plano
        mapaEmpresas.put(Plano.STARTER, Arrays.asList("Empresa A", "Empresa B"));
        mapaEmpresas.put(Plano.PRO, Arrays.asList("Empresa C", "Empresa D"));
        mapaEmpresas.put(Plano.ENTERPRISE, Arrays.asList("Empresa E", "Empresa F"));

        // 7. Iterar o EnumMap e imprimir plano + empresas formatado
        for (Map.Entry<Plano, List<String>> entry : mapaEmpresas.entrySet()) {
            Plano plano = entry.getKey();
            List<String> empresas = entry.getValue();
            System.out.printf("%s: %s%n", plano.name(), String.join(", ", empresas));
        }
    }
}


enum Plano {
    STARTER("Starter", 29.99, 5, 10),
    PRO("Pro", 59.99, 20, 50),
    ENTERPRISE("Enterprise", 99.99, 100, 200);

    private String nome;
    private double mensalidade;
    private int limiteUsuarios;
    private int limiteCampanhas;

    Plano(String nome, double mensalidade, int limiteUsuarios, int limiteCampanhas) {
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.limiteUsuarios = limiteUsuarios;
        this.limiteCampanhas = limiteCampanhas;
    }

    public double calcularAnual() {
        return mensalidade * 12;
    }

    public double calcularComDesconto(double percentual) {
        return mensalidade * (1 - percentual / 100);
    }

    public String resumo() {
        return String.format("%s: R$%.2f/mês, Limite de Usuários: %d, Limite de Campanhas: %d",
                nome, mensalidade, limiteUsuarios, limiteCampanhas);
    }

    public boolean podeAdicionarUsuario(int totalAtual) {
        return totalAtual < limiteUsuarios;
    }
}