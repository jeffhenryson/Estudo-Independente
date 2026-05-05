// ## Exercício 4 — Record implementando interface

// Crie a interface:

// ```java
// interface Exportavel {
//     String exportarCsv();
//     String exportarJson();
// }
// ```

// Crie o record `RelatorioPlano` com `plano`, `totalEmpresas`, `receitaTotal`, `ticketMedio` implementando `Exportavel`:

// 1. `exportarCsv()` → `"plano,totalEmpresas,receitaTotal,ticketMedio"`
// 2. `exportarJson()` → `{"plano":"...", "totalEmpresas":..., ...}`
// 3. Método `resumo()` com dados formatados

// No `main`:

// 1. Crie 3 relatórios um para cada plano
// 2. Chame `exportarCsv()` e `exportarJson()` em cada um
// 3. Use a interface como tipo: `Exportavel e = new RelatorioPlano(...)`

public class Exercicio04 {
    public static void main(String[] args) {
        
        RelatorioPlano basico = new RelatorioPlano("Básico", 100, 5000.00, 50.00);
        RelatorioPlano premium = new RelatorioPlano("Premium", 50, 7500.00, 150.00);
        RelatorioPlano enterprise = new RelatorioPlano("Enterprise", 20, 20000.00, 1000.00);

        Exportavel e1 = basico;
        Exportavel e2 = premium;
        Exportavel e3 = enterprise;

        System.out.println(e1.exportarCsv());
        System.out.println(e1.exportarJson());
        System.out.println(basico.resumo());

        System.out.println(e2.exportarCsv());
        System.out.println(e2.exportarJson());
        System.out.println(premium.resumo());

        System.out.println(e3.exportarCsv());
        System.out.println(e3.exportarJson());
        System.out.println(enterprise.resumo());
    }
}

interface Exportavel {
    String exportarCsv();
    String exportarJson();
}

record RelatorioPlano(String plano, int totalEmpresas, double receitaTotal, double ticketMedio) implements Exportavel {
    @Override
    public String exportarCsv() {
        return String.format("%s,%d,%.2f,%.2f", plano, totalEmpresas, receitaTotal, ticketMedio);
    }

    @Override
    public String exportarJson() {
        return String.format("{\"plano\":\"%s\", \"totalEmpresas\":%d, \"receitaTotal\":%.2f, \"ticketMedio\":%.2f}", plano, totalEmpresas, receitaTotal, ticketMedio);
    }

    public String resumo() {
        return String.format("Plano: %s | Total Empresas: %d | Receita Total: %.2f | Ticket Médio: %.2f", plano, totalEmpresas, receitaTotal, ticketMedio);
    }
}