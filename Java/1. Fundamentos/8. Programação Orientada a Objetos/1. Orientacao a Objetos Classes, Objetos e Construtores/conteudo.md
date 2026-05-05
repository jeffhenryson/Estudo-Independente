
---

## 1. O que é uma Classe e um Objeto

Uma classe é como um **molde** ou uma planta baixa que define os atributos (os dados) e os métodos (os comportamentos) que os objetos terão. Um objeto, por sua vez, é uma **instância** concreta criada a partir desse molde.
w
```java
// Molde: a classe
public class Usuario {
    // Atributos (dados)
    String nome;
    String email;
    String plano;
    boolean ativo;

    // Comportamento (método)
    public void apresentar() {
        System.out.printf("Usuário: %s | Plano: %s | Ativo: %b%n", nome, plano, ativo);
    }
}
```

Para utilizarmos a classe, criamos objetos na memória com a palavra-chave `new`:

```java
// Instâncias — objetos independentes
Usuario u1 = new Usuario();
u1.nome = "Jeff";
u1.email = "jeff@cerne.com";
u1.plano = "pro";
u1.ativo = true;

Usuario u2 = new Usuario();
u2.nome = "Ana";
u2.plano = "starter";
u2.ativo = false;

u1.apresentar(); // Usuário: Jeff | Plano: pro | Ativo: true
u2.apresentar(); // Usuário: Ana | Plano: starter | Ativo: false
```



---

## 2. Construtores

Um construtor é um bloco de construção especial invocado no exato momento da criação do objeto (quando usamos o `new`). O objetivo do construtor é **inicializar o objeto já com valores válidos**, evitando que ele seja criado em um estado inconsistente.

```java
public class Usuario {
    String nome;
    String email;
    String plano;
    boolean ativo;

    // Construtor
    public Usuario(String nome, String email, String plano) {
        this.nome = nome;
        this.email = email;
        this.plano = plano;
        this.ativo = true; // Todo novo usuário começa ativo por padrão
    }
}
```

A grande vantagem de usar um construtor é tornar o código mais seguro, legível e direto:

```java
// Sem construtor — verboso e frágil
Usuario u = new Usuario();
u.nome = "Jeff";
u.email = "jeff@cerne.com";
u.plano = "pro";
u.ativo = true;

// Com construtor — limpo e seguro em uma única linha
Usuario u = new Usuario("Jeff", "jeff@cerne.com", "pro");
```

---

## 3. Construtor Padrão

Se você **não declarar nenhum construtor** na sua classe, o compilador do Java gera um construtor oculto e sem parâmetros automaticamente.

```java
// O Java cria este construtor silenciosamente nos bastidores:
public Usuario() { }
```

> **Atenção:** Se você criar **qualquer** construtor com parâmetros, o Java deixa de gerar esse construtor padrão. Portanto, se precisar de ambas as formas, terá que declará-las explicitamente.

---

## 4. Sobrecarga (Overload) de Construtores

Assim como ocorre com métodos normais, você pode ter mais de um construtor na mesma classe, desde que tenham listas de parâmetros diferentes. Isso permite criar objetos de maneiras mais flexíveis.

```java
public class Usuario {
    String nome;
    String email;
    String plano;
    boolean ativo;

    // 1. Construtor completo
    public Usuario(String nome, String email, String plano) {
        this.nome = nome;
        this.email = email;
        this.plano = plano;
        this.ativo = true;
    }

    // 2. Construtor simplificado — assume plano "starter"
    public Usuario(String nome, String email) {
        this(nome, email, "starter"); // ← Chama o construtor 1
    }

    // 3. Construtor mínimo — assume e-mail padrão
    public Usuario(String nome) {
        this(nome, "sem-email@cerne.com"); // ← Chama o construtor 2
    }
}
```

> **Regra de Ouro:** A chamada `this(...)` para usar outro construtor deve ser **sempre a primeira linha** do bloco.

---

## 5. O Papel do `this`

A palavra-chave `this` referencia a instância atual do objeto na memória. Seus três usos principais são:

```java
public class Conta {
    double saldo;
    String titular;

    public Conta(double saldo, String titular) {
        // 1. Diferencia atributo de parâmetro com o mesmo nome (shadowing)
        this.saldo = saldo;       // this.saldo refere-se ao atributo
        this.titular = titular;
    }

    // 2. Chama outro construtor da mesma classe
    public Conta(String titular) {
        this(0.0, titular);
    }

    // 3. Passa a própria instância do objeto como argumento
    public void registrar(Repositorio repo) {
        repo.salvar(this);
    }
}
```

---

## 6. Atributos e Métodos Estáticos (`static`)

O modificador `static` indica que o membro pertence à **classe**, e não a um objeto individual. Ele é compartilhado por todas as instâncias criadas.

```java
public class Usuario {
    // Atributo estático (compartilhado por todos os usuários)
    static int totalUsuarios = 0; 

    String nome;

    public Usuario(String nome) {
        this.nome = nome;
        totalUsuarios++; // Incrementa globalmente a cada novo objeto criado
    }
}
```

```java
Usuario u1 = new Usuario("Jeff");
Usuario u2 = new Usuario("Ana");

// Acessamos o membro estático diretamente pelo nome da classe
System.out.println(Usuario.totalUsuarios); // Imprime: 2
```

---

## 7. Anatomia Completa de uma Classe

Para integrar todos os conceitos vistos acima, veja uma estrutura completa e limpa:

```java
public class Plano {

    // Constante de classe
    static final double DESCONTO_ANUAL = 0.15;

    // Atributos de instância
    String nome;
    double mensalidade;
    int limiteUsuarios;

    // Atributo de classe
    static int totalPlanos = 0;

    // Construtor completo
    public Plano(String nome, double mensalidade, int limiteUsuarios) {
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.limiteUsuarios = limiteUsuarios;
        totalPlanos++;
    }

    // Construtor simplificado
    public Plano(String nome, double mensalidade) {
        this(nome, mensalidade, 5); // Limite padrão
    }

    // Método de instância
    public double calcularAnual() {
        return mensalidade * 12 * (1 - DESCONTO_ANUAL);
    }

    // Método de classe
    public static int getTotalPlanos() {
        return totalPlanos;
    }

    // Representação textual do objeto
    public String toString() {
        return String.format("Plano{nome=%s, mensalidade=%.2f}", nome, mensalidade);
    }
}
```

---

Gostaria de prosseguir para os exercícios de fixação dessa base antes de começarmos a falar dos pilares da POO?