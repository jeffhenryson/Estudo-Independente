## 1. O que é e por que existe

Enum é um tipo especial que representa um **conjunto fixo de constantes**. Antes de enums, usava-se constantes inteiras — frágil e sem semântica:

```java
// antes — ruim
public static final int PLANO_STARTER = 1;
public static final int PLANO_PRO = 2;
public static final int PLANO_ENTERPRISE = 3;

int plano = 99; // compilador não reclama — mas 99 não existe
```

```java
// com enum — seguro e expressivo
public enum Plano {
    STARTER, PRO, ENTERPRISE
}

Plano plano = Plano.STARTER; // só valores válidos são aceitos
Plano invalido = 99;         // ❌ erro de compilação
```

---

## 2. Sintaxe básica

```java
public enum DiaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
}
```

```java
DiaSemana dia = DiaSemana.SEXTA;
System.out.println(dia);          // SEXTA
System.out.println(dia.name());   // "SEXTA" — nome como String
System.out.println(dia.ordinal()); // 4 — posição (começa em 0)

// comparação
if (dia == DiaSemana.SEXTA) {
    System.out.println("Sextou!");
}

// switch
switch (dia) {
    case SABADO, DOMINGO -> System.out.println("Fim de semana");
    default -> System.out.println("Dia útil");
}
```

---

## 3. Enum com atributos e métodos

Enums são classes — podem ter atributos, construtores e métodos:

```java
public enum Plano {

    STARTER("Starter", 49.90, 5, 10),
    PRO("Pro", 149.90, 20, 50),
    ENTERPRISE("Enterprise", 499.90, 100, 200);

    // atributos — sempre final em enum
    private final String nome;
    private final double mensalidade;
    private final int limiteUsuarios;
    private final int limiteCampanhas;

    // construtor — sempre private em enum
    Plano(String nome, double mensalidade, int limiteUsuarios, int limiteCampanhas) {
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.limiteUsuarios = limiteUsuarios;
        this.limiteCampanhas = limiteCampanhas;
    }

    // getters
    public String getNome() { return nome; }
    public double getMensalidade() { return mensalidade; }
    public int getLimiteUsuarios() { return limiteUsuarios; }
    public int getLimiteCampanhas() { return limiteCampanhas; }

    // método
    public double calcularAnual() {
        return mensalidade * 12;
    }

    public String resumo() {
        return String.format("%s — R$ %.2f/mês | %d usuários | %d campanhas",
            nome, mensalidade, limiteUsuarios, limiteCampanhas);
    }
}
```

```java
Plano plano = Plano.PRO;
System.out.println(plano.getMensalidade());  // 149.9
System.out.println(plano.calcularAnual());   // 1798.8
System.out.println(plano.resumo());
// Pro — R$ 149,90/mês | 20 usuários | 50 campanhas
```

---

## 4. Métodos úteis nativos

```java
// values() — retorna array com todos os valores
for (Plano p : Plano.values()) {
    System.out.println(p.resumo());
}

// valueOf() — converte String para enum
Plano p = Plano.valueOf("PRO"); // ✅ "PRO" exato
Plano x = Plano.valueOf("pro"); // ❌ IllegalArgumentException — case sensitive

// name() — nome como String
System.out.println(Plano.PRO.name()); // "PRO"

// ordinal() — posição na declaração
System.out.println(Plano.STARTER.ordinal());    // 0
System.out.println(Plano.PRO.ordinal());        // 1
System.out.println(Plano.ENTERPRISE.ordinal()); // 2
```

---

## 5. Enum com métodos abstratos

Cada constante pode ter comportamento diferente:

```java
public enum Plataforma {

    META_ADS {
        @Override
        public String formatarRelatorio(String campanha, double roi) {
            return String.format("[Meta Ads] %s → ROI: %.1f%% | Sugestão: %s",
                campanha, roi, roi > 50 ? "Escalar" : "Otimizar");
        }
    },

    GOOGLE_ADS {
        @Override
        public String formatarRelatorio(String campanha, double roi) {
            return String.format("[Google Ads] %s → ROI: %.1f%% | CPC otimizado: %s",
                campanha, roi, roi > 30 ? "Sim" : "Não");
        }
    },

    TIKTOK_ADS {
        @Override
        public String formatarRelatorio(String campanha, double roi) {
            return String.format("[TikTok Ads] %s → ROI: %.1f%% | Criativo: %s",
                campanha, roi, roi > 40 ? "Alto impacto" : "Revisar");
        }
    };

    // método abstrato — cada constante implementa
    public abstract String formatarRelatorio(String campanha, double roi);
}
```

```java
System.out.println(Plataforma.META_ADS.formatarRelatorio("Black Friday", 75.0));
// [Meta Ads] Black Friday → ROI: 75,0% | Sugestão: Escalar

System.out.println(Plataforma.GOOGLE_ADS.formatarRelatorio("Search Branded", 25.0));
// [Google Ads] Search Branded → ROI: 25,0% | CPC otimizado: Não
```

---

## 6. EnumSet e EnumMap

Coleções otimizadas para enums:

```java
import java.util.EnumSet;
import java.util.EnumMap;

// EnumSet — Set otimizado para enums
EnumSet<Plano> planosAtivos = EnumSet.of(Plano.STARTER, Plano.PRO);
EnumSet<Plano> todosPlanos = EnumSet.allOf(Plano.class);
EnumSet<Plano> semStarter = EnumSet.complementOf(EnumSet.of(Plano.STARTER));

System.out.println(planosAtivos.contains(Plano.PRO));  // true
System.out.println(planosAtivos.contains(Plano.ENTERPRISE)); // false

// EnumMap — Map otimizado com enum como chave
EnumMap<Plano, List<String>> empresasPorPlano = new EnumMap<>(Plano.class);
empresasPorPlano.put(Plano.STARTER, new ArrayList<>());
empresasPorPlano.put(Plano.PRO, new ArrayList<>());
empresasPorPlano.get(Plano.PRO).add("Cerne");

for (Map.Entry<Plano, List<String>> entry : empresasPorPlano.entrySet()) {
    System.out.printf("%s: %s%n", entry.getKey().getNome(), entry.getValue());
}
```

---

## 7. Enum implementando interface

```java
public interface Calculavel {
    double calcularTotal(int meses);
}

public enum Plano implements Calculavel {

    STARTER("Starter", 49.90),
    PRO("Pro", 149.90),
    ENTERPRISE("Enterprise", 499.90);

    private final String nome;
    private final double mensalidade;

    Plano(String nome, double mensalidade) {
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    @Override
    public double calcularTotal(int meses) {
        return mensalidade * meses;
    }

    public double getMensalidade() { return mensalidade; }
    public String getNome() { return nome; }
}
```

```java
for (Plano p : Plano.values()) {
    System.out.printf("%s — 12 meses: R$ %.2f%n", p.getNome(), p.calcularTotal(12));
}
// Starter — 12 meses: R$ 598,80
// Pro — 12 meses: R$ 1798,80
// Enterprise — 12 meses: R$ 5998,80
```

---

## 8. Enum em switch moderno

```java
Plano plano = Plano.PRO;

String descricao = switch (plano) {
    case STARTER -> "Ideal para pequenas empresas";
    case PRO -> "Para empresas em crescimento";
    case ENTERPRISE -> "Solução corporativa completa";
};

System.out.println(descricao);
```

> O compilador verifica se todos os casos do enum estão cobertos — se adicionar um novo valor ao enum e esquecer de cobrir no switch, **erro de compilação**. Isso não acontece com String ou int.
> 

---

## 9. Boas práticas

```java
// ✅ nomes em UPPER_SNAKE_CASE
enum Status { ATIVO, INATIVO, PENDENTE }

// ✅ use valueOf() com try/catch para input do usuário
try {
    Plano p = Plano.valueOf(entrada.toUpperCase());
} catch (IllegalArgumentException e) {
    System.out.println("Plano inválido: " + entrada);
}

// ✅ prefira enum a constantes int/String
// ✅ use EnumSet/EnumMap quando a chave for enum
// ❌ não use ordinal() para lógica de negócio — ordinal muda se reordenar o enum
```

---