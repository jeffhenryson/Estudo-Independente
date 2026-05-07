// ## 4. Animais e seus Sons

// **Enunciado:** Crie uma classe base chamada `Animal` com o atributo `String nome` e um método `emitirSom()`.
// * Crie subclasses `Cachorro` e `Gato` que herdam de `Animal`.
// * Sobrescreva o método `emitirSom()` em ambas as subclasses para imprimir o som específico de cada um (por exemplo, "Au Au" e "Miau").

public class Exercicio04 {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Rex");
        Gato gato = new Gato("Mimi");

        System.out.println(cachorro.nome + " diz:");
        cachorro.emitirSom();

        System.out.println(gato.nome + " diz:");
        gato.emitirSom();
    }
}

class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void emitirSom() {
        System.out.println("O animal emite um som.");
    }
}

class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Au Au");
    }
}

class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Miau");
    }
}