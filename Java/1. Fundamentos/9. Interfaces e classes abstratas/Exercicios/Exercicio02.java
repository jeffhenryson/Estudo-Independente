// ## Exercício 2 — Interface básica

// Crie a interface `Exportavel` com os métodos:

// - `exportarCsv()` → retorna `String`
// - `exportarJson()` → retorna `String`
// - `default void exportarTodos()` → chama os dois e imprime

// Crie duas classes que implementam `Exportavel`:

// **`RelatorioUsuarios`**

// - Atributo: array de nomes `String[]`
// - `exportarCsv()` → retorna os nomes separados por vírgula
// - `exportarJson()` → retorna no formato `["nome1","nome2",...]`

// **`RelatorioFinanceiro`**

// - Atributos: `mes`, `totalReceita`, `totalDespesas`
// - `exportarCsv()` → retorna `"mes,receita,despesas"`
// - `exportarJson()` → retorna `{"mes":"...", "receita":..., "despesas":...}`

// No `main`, chame `exportarTodos()` em ambos.

public class Exercicio02 {
    public static void main(String[] args) {
        RelatorioUsuarios relatorioUsuarios = new RelatorioUsuarios(new String[]{"Alice", "Bob", "Charlie"});
        RelatorioFinanceiro relatorioFinanceiro = new RelatorioFinanceiro("Janeiro", 10000.0, 5000.0);

        System.out.println("Relatório de Usuários:");
        relatorioUsuarios.exportarTodos();
        System.out.println();

        System.out.println("Relatório Financeiro:");
        relatorioFinanceiro.exportarTodos();
    }
}

interface Exportavel {
    String exportarCsv();
    String exportarJson();

    default void exportarTodos() {
        System.out.println("CSV:");
        System.out.println(exportarCsv());
        System.out.println("JSON:");
        System.out.println(exportarJson());
    }
}

class RelatorioUsuarios implements Exportavel {

    private String[] nomes;

    public RelatorioUsuarios(String[] nomes) {
        this.nomes = nomes;
    }

    @Override
    public String exportarCsv() {
        return String.join(",", nomes);
    }

    @Override
    public String exportarJson() {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < nomes.length; i++) {
            json.append("\"").append(nomes[i]).append("\"");
            if (i < nomes.length - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }
}

class RelatorioFinanceiro implements Exportavel {

    private String mes;
    private double totalReceita;
    private double totalDespesas;

    public RelatorioFinanceiro(String mes, double totalReceita, double totalDespesas) {
        this.mes = mes;
        this.totalReceita = totalReceita;
        this.totalDespesas = totalDespesas;
    }

    @Override
    public String exportarCsv() {
        return mes + "," + totalReceita + "," + totalDespesas;
    }

    @Override
    public String exportarJson() {
        return "{\"mes\":\"" + mes + "\", \"receita\":" + totalReceita + ", \"despesas\":" + totalDespesas + "}";
    }
}