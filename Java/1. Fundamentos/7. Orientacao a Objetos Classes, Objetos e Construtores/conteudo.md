## 1. O que é uma classe

Classe é um **molde** que define atributos (dados) e métodos (comportamentos). Objeto é uma **instância** desse molde.

```java
// molde
public class Usuario {
    // atributos
    String nome;
    String email;
    String plano;
    boolean ativo;

    // comportamento
    public void apresentar() {
        System.out.printf("Usuário: %s | Plano: %s | Ativo: %b%n", nome, plano, ativo);
    }
}
```

```java
// instâncias — objetos independentes
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

Construtor é um método especial chamado no momento do `new`. Serve para **inicializar o objeto já com valores**:

```java
public class Usuario {
    String nome;
    String email;
    String plano;
    boolean ativo;

    // construtor
    public Usuario(String nome, String email, String plano) {
        this.nome = nome;
        this.email = email;
        this.plano = plano;
        this.ativo = true; // padrão ao criar
    }
}
```

```java
// sem construtor — verboso e frágil
Usuario u = new Usuario();
u.nome = "Jeff";
u.email = "jeff@cerne.com";
u.plano = "pro";
u.ativo = true;

// com construtor — limpo e seguro
Usuario u = new Usuario("Jeff", "jeff@cerne.com", "pro");
```

---

## 3. Construtor padrão

Se você **não declarar nenhum construtor**, Java gera um automaticamente sem parâmetros:

```java
// Java gera isso invisível:
public Usuario() { }
```

Mas se você declarar **qualquer construtor**, o padrão deixa de existir:

```java
public class Usuario {
    public Usuario(String nome) { ... } // declarou um

    // agora new Usuario() ← ❌ erro, não existe mais o sem parâmetros
}
```

---

## 4. Sobrecarga de construtores

Assim como métodos, construtores também podem ser sobrecarregados:

```java
public class Usuario {
    String nome;
    String email;
    String plano;
    boolean ativo;

    // construtor completo
    public Usuario(String nome, String email, String plano) {
        this.nome = nome;
        this.email = email;
        this.plano = plano;
        this.ativo = true;
    }

    // construtor simplificado — plano padrão
    public Usuario(String nome, String email) {
        this(nome, email, "starter"); // ← chama o construtor acima
    }

    // construtor mínimo
    public Usuario(String nome) {
        this(nome, "sem-email@cerne.com"); // ← chama o de cima
    }
}
```

> `this(...)` chama outro construtor da mesma classe — deve ser **sempre a primeira linha**.
> 

---

## 5. `this` revisitado

`this` referencia o objeto atual. Tem três usos principais:

```java
public class Conta {
    double saldo;
    String titular;

    // 1. diferenciar atributo do parâmetro (shadowing)
    public Conta(double saldo, String titular) {
        this.saldo = saldo;       // this.saldo = atributo
        this.titular = titular;   // titular = parâmetro
    }

    // 2. chamar outro construtor
    public Conta(String titular) {
        this(0.0, titular);
    }

    // 3. passar o próprio objeto como argumento
    public void registrar(Repositorio repo) {
        repo.salvar(this); // passa o objeto atual
    }
}
```

---

## 6. Atributos e métodos estáticos

`static` significa que pertence à **classe**, não ao objeto:

```java
public class Usuario {
    static int totalUsuarios = 0; // compartilhado entre todos os objetos

    String nome;

    public Usuario(String nome) {
        this.nome = nome;
        totalUsuarios++; // incrementa a cada novo usuário criado
    }
}
```

```java
Usuario u1 = new Usuario("Jeff");
Usuario u2 = new Usuario("Ana");

System.out.println(Usuario.totalUsuarios); // 2 ← acessa pela classe, não pelo objeto
```

---

## 7. Anatomia completa de uma classe

```java
public class Plano {

    // constante de classe
    static final double DESCONTO_ANUAL = 0.15;

    // atributos de instância
    String nome;
    double mensalidade;
    int limiteUsuarios;

    // atributo de classe
    static int totalPlanos = 0;

    // construtor completo
    public Plano(String nome, double mensalidade, int limiteUsuarios) {
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.limiteUsuarios = limiteUsuarios;
        totalPlanos++;
    }

    // construtor simplificado
    public Plano(String nome, double mensalidade) {
        this(nome, mensalidade, 5); // limite padrão
    }

    // método de instância
    public double calcularAnual() {
        return mensalidade * 12 * (1 - DESCONTO_ANUAL);
    }

    // método de classe
    public static int getTotalPlanos() {
        return totalPlanos;
    }

    // representação textual do objeto
    public String toString() {
        return String.format("Plano{nome=%s, mensalidade=%.2f}", nome, mensalidade);
    }
}
```