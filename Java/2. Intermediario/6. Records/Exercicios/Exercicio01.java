// ## Exercício 1 — Record básico

// Crie o record `Plano` com os componentes `nome`, `mensalidade` e `limiteUsuarios` e:

// 1. Crie 3 instâncias: starter, pro e enterprise
// 2. Acesse cada componente pelos getters automáticos
// 3. Imprima o `toString()` automático de cada um
// 4. Compare dois records com os mesmos valores usando `equals()` e mostre o resultado
// 5. Use os records como chave em um `HashMap<Plano, List<String>>` — adicione empresas para cada plano e itere

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercicio01{
    public static void main(String[] args) {
        Plano starter = new Plano("Starter", 29.99, 5);
        Plano pro = new Plano("Pro", 59.99, 20);
        Plano enterprise = new Plano("Enterprise", 99.99, 100);

        System.out.println(starter.nome());
        System.out.println(starter.mensalidade());
        System.out.println(starter.limiteUsuarios());

        System.out.println(starter.toString());
        System.out.println(pro.toString());
        System.out.println(enterprise.toString());

        Plano outroStarter = new Plano("Starter", 29.99, 5);
        System.out.println(starter.equals(outroStarter)); // true

        HashMap<Plano, List<String>> empresasPorPlano = new HashMap<>();
        empresasPorPlano.put(starter, Arrays.asList("Empresa A", "Empresa B"));
        empresasPorPlano.put(pro, Arrays.asList("Empresa C"));
        empresasPorPlano.put(enterprise, Arrays.asList("Empresa D", "Empresa E", "Empresa F"));

        for (Map.Entry<Plano, List<String>> entry : empresasPorPlano.entrySet()) {
            System.out.println("Plano: " + entry.getKey().nome() + " - Empresas: " + entry.getValue());
        }
    }
}

record Plano(String nome, double mensalidade, int limiteUsuarios) {}