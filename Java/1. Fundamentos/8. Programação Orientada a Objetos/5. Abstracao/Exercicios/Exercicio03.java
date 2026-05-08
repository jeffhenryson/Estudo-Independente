// ## 3. Dispositivos Eletrônicos

// **Enunciado:** Crie uma classe abstrata `DispositivoEletronico` com os métodos abstratos `ligar()` e `desligar()`.
// * Crie a classe concreta `Televisao` e a classe concreta `Smartphone`.
// * Implemente os métodos em cada subclasse imprimindo mensagens específicas para cada dispositivo (ex: `"Televisão ligada. Tela sintonizada na TV a cabo."` e `"Smartphone ligado. Desbloqueando tela..."`).

public class Exercicio03 {
    public static void main(String[] args) {
        Televisao tv = new Televisao();
        Smartphone smartphone = new Smartphone();

        tv.ligar();
        tv.desligar();

        smartphone.ligar();
        smartphone.desligar();
    }
}

class DispositivoEletronico {
    public void ligar() {
        System.out.println("Dispositivo eletrônico ligado.");
    }

    public void desligar() {
        System.out.println("Dispositivo eletrônico desligado.");
    }
}

class Televisao extends DispositivoEletronico {
    @Override
    public void ligar() {
        System.out.println("Televisão ligada. Tela sintonizada na TV a cabo.");
    }

    @Override
    public void desligar() {
        System.out.println("Televisão desligada. Tela escurecida.");
    }
}

class Smartphone extends DispositivoEletronico {
    @Override
    public void ligar() {
        System.out.println("Smartphone ligado. Desbloqueando tela...");
    }

    @Override
    public void desligar() {
        System.out.println("Smartphone desligado. Tela apagada.");
    }
}
