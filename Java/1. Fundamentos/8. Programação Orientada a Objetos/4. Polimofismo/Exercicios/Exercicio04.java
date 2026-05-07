// ## 4. Personagens de um Jogo

// **Enunciado:** Crie uma classe base chamada `Personagem` com um método `atacar()`.
// * Crie duas subclasses: `Guerreiro` e `Mago`.
// * Sobrescreva o método `atacar()` em cada uma:
//   * O `Guerreiro` deve imprimir a mensagem "Atacando com espada!".
//   * O `Mago` deve imprimir a mensagem "Lançando feitiço!".
// * Crie uma instância de cada um armazenando-as em variáveis do tipo `Personagem` e chame o método `atacar()` para demonstrar o comportamento polimórfico.

public class Exercicio04 {
    public static void main(String[] args) {
        Personagem guerreiro = new Guerreiro();
        Personagem mago = new Mago();

        guerreiro.atacar(); // Saída: Atacando com espada!
        mago.atacar(); // Saída: Lançando feitiço!
    }
}

class Personagem {
    public void atacar() {
        System.out.println("Atacando!");
    }
}

class Guerreiro extends Personagem {
    @Override
    public void atacar() {
        System.out.println("Atacando com espada!");
    }
}

class Mago extends Personagem {
    @Override
    public void atacar() {
        System.out.println("Lançando feitiço!");
    }
}