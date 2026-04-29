## PARTE 1 — Classes Abstratas

### 1. O problema que resolve

No exercício anterior, `Usuario.temPermissao()` retornava `false` por padrão — mas faz sentido existir um `Usuario` genérico sem tipo definido? Nem sempre. Classes abstratas resolvem isso:

```java
// não pode ser instanciada diretamente
public abstract class Usuario {
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // método abstrato — sem implementação, obriga o filho a implementar
    public abstract boolean temPermissao(String acao);

    // método concreto — herdado normalmente
    public void perfil() {
        System.out.printf("Nome: %s | Email: %s%n", nome, email);
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
}
```

```java
new Usuario("Jeff", "jeff@cerne.com"); // ❌ erro — classe abstrata não instancia

UsuarioAdmin admin = new UsuarioAdmin("Jeff", "jeff@cerne.com", 3); // ✅
```

---

### 2. Método abstrato

Método abstrato define **o que** deve existir, mas não **como**:

```java
public abstract class Relatorio {
    private String titulo;

    public Relatorio(String titulo) {
        this.titulo = titulo;
    }

    // todo relatório deve saber gerar seu conteúdo — mas cada um do seu jeito
    public abstract String gerarConteudo();

    // comportamento comum a todos
    public void imprimir() {
        System.out.println("=== " + titulo + " ===");
        System.out.println(gerarConteudo()); // polimorfismo
        System.out.println("==================");
    }
}
```

```java
public class RelatorioVendas extends Relatorio {
    private double totalVendas;

    public RelatorioVendas(double totalVendas) {
        super("Relatório de Vendas");
        this.totalVendas = totalVendas;
    }

    @Override
    public String gerarConteudo() {
        return String.format("Total vendido: R$ %.2f", totalVendas);
    }
}
```

---

## PARTE 2 — Interfaces

### 1. O que é uma interface

Interface é um **contrato** — define o que uma classe deve fazer, sem dizer como. É como uma lista de capacidades:

```java
public interface Exportavel {
    void exportarPdf();
    void exportarCsv();
}

public interface Notificavel {
    void enviarEmail(String destinatario);
    void enviarSms(String telefone);
}
```

Uma classe pode implementar **várias interfaces** — resolvendo a limitação de herança simples:

```java
public class RelatorioVendas extends Relatorio
        implements Exportavel, Notificavel {

    @Override
    public String gerarConteudo() { ... }

    @Override
    public void exportarPdf() {
        System.out.println("Exportando PDF...");
    }

    @Override
    public void exportarCsv() {
        System.out.println("Exportando CSV...");
    }

    @Override
    public void enviarEmail(String destinatario) {
        System.out.println("Enviando email para " + destinatario);
    }

    @Override
    public void enviarSms(String telefone) {
        System.out.println("Enviando SMS para " + telefone);
    }
}
```

---

### 2. Interfaces vs Classes Abstratas

|  | Classe Abstrata | Interface |
| --- | --- | --- |
| Instanciar | ❌ | ❌ |
| Herança/Implementação | `extends` (só uma) | `implements` (várias) |
| Métodos concretos | ✅ | ✅ (com `default`) |
| Métodos abstratos | ✅ | ✅ (implicitamente) |
| Atributos de instância | ✅ | ❌ só constantes |
| Construtor | ✅ | ❌ |
| Quando usar | Compartilhar código + forçar contrato | Definir capacidades |

---

### 3. `default` methods (Java 8+)

Interfaces podem ter implementação padrão:

```java
public interface Exportavel {
    void exportarPdf();
    void exportarCsv();

    // implementação padrão — a classe pode sobrescrever ou não
    default void exportarTodos() {
        exportarPdf();
        exportarCsv();
        System.out.println("Exportação completa.");
    }
}
```

---

### 4. Constantes em interfaces

Atributos em interfaces são implicitamente `public static final`:

```java
public interface Planos {
    double MENSALIDADE_STARTER = 49.90;    // public static final implícito
    double MENSALIDADE_PRO = 149.90;
    double MENSALIDADE_ENTERPRISE = 499.90;
}
```

---

### 5. Interface como tipo

Assim como classe abstrata, interface funciona como tipo polimórfico:

```java
public interface Calculavel {
    double calcularTotal();
}

public class Pedido implements Calculavel {
    private double valor;
    public Pedido(double valor) { this.valor = valor; }

    @Override
    public double calcularTotal() { return valor * 1.1; } // + 10% taxa
}

public class Assinatura implements Calculavel {
    private double mensalidade;
    private int meses;
    public Assinatura(double mensalidade, int meses) {
        this.mensalidade = mensalidade;
        this.meses = meses;
    }

    @Override
    public double calcularTotal() { return mensalidade * meses; }
}
```

```java
// polimorfismo via interface
Calculavel[] itens = {
    new Pedido(500.0),
    new Assinatura(149.90, 12)
};

double totalGeral = 0;
for (Calculavel item : itens) {
    totalGeral += item.calcularTotal(); // cada um calcula do seu jeito
}

System.out.printf("Total geral: R$ %.2f%n", totalGeral);
```

---

### 6. Exemplo completo

```java
// interfaces — capacidades
public interface Relatoravel {
    String gerarRelatorio();
}

public interface Notificavel {
    void notificar(String mensagem);
}

// classe abstrata — base comum
public abstract class Campanha {
    protected String nome;
    protected double orcamento;

    public Campanha(String nome, double orcamento) {
        this.nome = nome;
        this.orcamento = orcamento;
    }

    public abstract double calcularRoi();

    public void exibir() {
        System.out.printf("Campanha: %s | Orçamento: R$ %.2f | ROI: %.1f%%%n",
            nome, orcamento, calcularRoi());
    }
}

// implementação concreta
public class CampanhaMetaAds extends Campanha
        implements Relatoravel, Notificavel {

    private double receita;

    public CampanhaMetaAds(String nome, double orcamento, double receita) {
        super(nome, orcamento);
        this.receita = receita;
    }

    @Override
    public double calcularRoi() {
        return ((receita - orcamento) / orcamento) * 100;
    }

    @Override
    public String gerarRelatorio() {
        return String.format("Relatório Meta Ads — %s: ROI %.1f%%", nome, calcularRoi());
    }

    @Override
    public void notificar(String mensagem) {
        System.out.println("[Meta Ads] " + mensagem);
    }
}
```

---

### 7. Quando usar cada um

```
Tem código comum para compartilhar?
└── SIM → Classe abstrata (ou classe normal)
└── NÃO → Interface

A classe já herda de outra?
└── SIM → Interface (Java não tem herança múltipla)
└── NÃO → Pode ser classe abstrata ou interface

É uma capacidade/comportamento independente?
(Exportável, Notificável, Ordenável)
└── SIM → Interface
└── NÃO → Classe abstrata
```

---