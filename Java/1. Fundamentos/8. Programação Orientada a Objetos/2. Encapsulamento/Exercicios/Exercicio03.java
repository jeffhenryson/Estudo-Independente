// ## 3. Controle de Temperatura

// **Enunciado:** Crie uma classe chamada `Termostato` com um atributo privado `double temperaturaEmCelsius`.
// * O atributo não pode ser alterado diretamente. 
// * Crie um `setter` chamado `setTemperaturaEmCelsius(double temperatura)` que garanta que a temperatura não desça abaixo do zero absoluto ($-273{,}15^\circ\text{C}$).
// * Crie um método que retorne a temperatura convertida para Fahrenheit (fórmula: $\text{F} = \text{C} \times 1{,}8 + 32$).

public class Exercicio03 {
    public static void main(String[] args) {
        Termostato termostato = new Termostato();
        
        // Testando a definição de temperatura válida
        termostato.setTemperaturaEmCelsius(25.0);
        System.out.println("Temperatura em Fahrenheit: " + termostato.getTemperaturaEmFahrenheit());

        // Testando a definição de temperatura inválida
        termostato.setTemperaturaEmCelsius(-300.0); // Deve exibir uma mensagem de erro
    }
}

class Termostato {
    private double temperaturaEmCelsius;

    public void setTemperaturaEmCelsius(double temperatura) {
        if (temperatura >= -273.15) {
            this.temperaturaEmCelsius = temperatura;
        } else {
            System.out.println("Erro: A temperatura não pode ser inferior ao zero absoluto (-273,15°C). Temperatura não alterada.");
        }
    }

    public double getTemperaturaEmFahrenheit() {
        return this.temperaturaEmCelsius * 1.8 + 32;
    }
}