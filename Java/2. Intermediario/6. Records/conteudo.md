## 1. O que é e por que existe

Record é uma forma concisa de criar **classes imutáveis de dados**. Antes, para uma classe simples de dados você precisava escrever muito código repetitivo:

```java
// antes — classe simples com muito boilerplate
public class Campanha {
    private final String nome;
    private final String plataforma;
    private final double orcamento;

    public Campanha(String nome, String plataforma, double orcamento) {
        this.nome = nome;
        this.plataforma = plataforma;
        this.orcamento = orcamento;
    }

    public String getNome() { return nome; }
    public String getPlataforma() { return plataforma; }
    public double getOrcamento() { return orcamento; }

    @Override
    public boolean equals(Object o) { ... }

    @Override
    public int hashCode() { ... }

    @Override
    public String toString() { ... }
}

// com Record — tudo isso em uma linha
public record Campanha(String nome, String plataforma, double orcamento) {}
```

---

## 2. O que Java gera automaticamente

```java
public record Campanha(String nome, String plataforma, double orcamento) {}
```

Java gera automaticamente:

- Atributos `private final` para cada componente
- Construtor com todos os parâmetros
- Getters com o mesmo nome do atributo (sem `get`)
- `equals()` baseado em todos os componentes
- `hashCode()` baseado em todos os componentes
- `toString()` formatado

```java
Campanha c = new Campanha("Black Friday", "Meta Ads", 1000.0);

// getters — sem "get" no nome
System.out.println(c.nome());        // "Black Friday"
System.out.println(c.plataforma());  // "Meta Ads"
System.out.println(c.orcamento());   // 1000.0

// toString automático
System.out.println(c);
// Campanha[nome=Black Friday, plataforma=Meta Ads, orcamento=1000.0]

// equals automático — compara por valor, não referência
Campanha c2 = new Campanha("Black Friday", "Meta Ads", 1000.0);
System.out.println(c.equals(c2)); // true
```

---

## 3. Imutabilidade

Records são **imutáveis** — atributos são `final`, sem setters:

```java
Campanha c = new Campanha("Black Friday", "Meta Ads", 1000.0);
c.nome = "Outro"; // ❌ erro — campo final
```

Para "modificar", crie uma nova instância:

```java
// padrão comum — cria nova instância com valor alterado
Campanha comNovoOrcamento = new Campanha(c.nome(), c.plataforma(), 2000.0);
```

---

## 4. Construtor compacto — validação

O construtor compacto permite validar sem repetir a atribuição:

```java
public record Campanha(String nome, String plataforma, double orcamento) {

    // construtor compacto — sem parênteses, sem atribuição manual
    public Campanha {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (orcamento < 0) {
            throw new IllegalArgumentException("Orçamento não pode ser negativo");
        }
        // normalização — modifica antes de atribuir
        nome = nome.trim();
        plataforma = plataforma.toUpperCase();
    }
}
```

```java
new Campanha("", "Meta Ads", 1000.0);   // ❌ IllegalArgumentException
new Campanha("BF", "Meta Ads", -100.0); // ❌ IllegalArgumentException
Campanha c = new Campanha("  BF  ", "meta ads", 1000.0);
System.out.println(c.nome());           // "BF" — trim aplicado
System.out.println(c.plataforma());     // "META ADS" — uppercase aplicado
```

---

## 5. Métodos customizados

Records podem ter métodos — só não podem ter atributos de instância extras:

```java
public record Campanha(String nome, String plataforma, double orcamento, double receita) {

    // método de instância
    public double calcularRoi() {
        return ((receita - orcamento) / orcamento) * 100;
    }

    public boolean isPlusvalia() {
        return receita > orcamento;
    }

    public String resumo() {
        return String.format("%s [%s] — ROI: %.1f%%", nome, plataforma, calcularRoi());
    }

    // método estático
    public static Campanha criar(String nome, String plataforma, double orcamento) {
        return new Campanha(nome, plataforma, orcamento, 0.0);
    }
}
```

```java
Campanha c = new Campanha("Black Friday", "Meta Ads", 1000.0, 1500.0);
System.out.println(c.calcularRoi());  // 50.0
System.out.println(c.isPlusvalia());  // true
System.out.println(c.resumo());       // Black Friday [Meta Ads] — ROI: 50,0%

Campanha nova = Campanha.criar("Verão", "Google Ads", 800.0);
```

---

## 6. Implementando interfaces

Records podem implementar interfaces:

```java
public interface Relatoravel {
    String gerarRelatorio();
}

public record Campanha(String nome, String plataforma, double orcamento, double receita)
        implements Relatoravel {

    @Override
    public String gerarRelatorio() {
        return String.format(
            "=== %s ===\nPlataforma: %s\nOrçamento: R$ %.2f\nReceita: R$ %.2f\nROI: %.1f%%",
            nome, plataforma, orcamento, receita, calcularRoi()
        );
    }

    public double calcularRoi() {
        return ((receita - orcamento) / orcamento) * 100;
    }
}
```

---

## 7. Record com coleções — cuidado com mutabilidade

```java
// ⚠️ a referência é imutável, mas a lista não
public record Empresa(String nome, List<String> campanhas) {}

Empresa e = new Empresa("Cerne", new ArrayList<>());
e.campanhas().add("Black Friday"); // ✅ compila — a lista em si é mutável

// ✅ para imutabilidade real, use List.copyOf
public record Empresa(String nome, List<String> campanhas) {
    public Empresa {
        campanhas = List.copyOf(campanhas); // cópia imutável
    }
}

e.campanhas().add("Black Friday"); // ❌ UnsupportedOperationException
```

---

## 8. Limitações dos Records

```java
// ❌ não pode herdar de outra classe (já herda de Record implicitamente)
public record Campanha(...) extends OutraClasse {} // erro

// ❌ não pode ter atributos de instância extras
public record Campanha(String nome) {
    private String extra; // ❌ erro — só constantes estáticas
    static final String VERSAO = "1.0"; // ✅ constante estática — ok
}

// ❌ não pode ser abstrato
public abstract record Base(...) {} // erro

// ✅ pode ser final (já é implicitamente)
// ✅ pode implementar interfaces
// ✅ pode ter métodos estáticos e de instância
// ✅ pode ter construtores alternativos
```

---

## 9. Quando usar Record vs Classe normal

| Situação | Use |
| --- | --- |
| Dados imutáveis simples (DTO, Value Object) | `record` |
| Precisa de herança | classe normal |
| Precisa de atributos mutáveis | classe normal |
| Resposta de API, parâmetros agrupados | `record` |
| Entidade com comportamento rico | classe normal |
| Chave composta em Map | `record` — equals/hashCode grátis |

---

## 10. Records como chave de Map

```java
// equals e hashCode automáticos tornam records perfeitos como chave
record ChaveCampanha(String nome, String plataforma) {}

Map<ChaveCampanha, Double> rois = new HashMap<>();
rois.put(new ChaveCampanha("Black Friday", "Meta Ads"), 75.5);
rois.put(new ChaveCampanha("Verão", "Google Ads"), 42.0);

// busca funciona porque equals compara por valor
Double roi = rois.get(new ChaveCampanha("Black Friday", "Meta Ads"));
System.out.println(roi); // 75.5
```

---