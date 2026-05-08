
---

## 1. Sistema de Funcionários e Salários

**Enunciado:** Crie uma classe abstrata chamada `Funcionario` com o atributo protegido `String nome` e o atributo protegido `double salarioBase`.
* Crie um construtor que inicialize esses atributos.
* Crie um método abstrato `double calcularSalario()`.
* Crie a subclasse `FuncionarioIntegral` que implementa o método retornando o próprio `salarioBase`.
* Crie a subclasse `FuncionarioHorista` que adiciona os atributos privados `double horasTrabalhadas` e `double valorHora`. Implemente o método `calcularSalario()` multiplicando as horas pelo valor da hora.

---

## 2. Sistema de Pagamentos

**Enunciado:** Crie uma classe abstrata `MetodoPagamento` que contenha:
* Um método concreto `emitirComprovante()`.
* Um método abstrato `boolean validarPagamento()`.
* Crie as subclasses concretas `CartaoCredito` e `BoletoBancario`.
* `CartaoCredito` deve validar o pagamento se o limite for suficiente.
* `BoletoBancario` deve validar o pagamento se a data de vencimento não estiver expirada (para simplificar, utilize um atributo `boolean pago`).

---

## 3. Dispositivos Eletrônicos

**Enunciado:** Crie uma classe abstrata `DispositivoEletronico` com os métodos abstratos `ligar()` e `desligar()`.
* Crie a classe concreta `Televisao` e a classe concreta `Smartphone`.
* Implemente os métodos em cada subclasse imprimindo mensagens específicas para cada dispositivo (ex: `"Televisão ligada. Tela sintonizada na TV a cabo."` e `"Smartphone ligado. Desbloqueando tela..."`).

---

## 4. Sistema de Tributação de Veículos

**Enunciado:** Crie uma classe abstrata `Veiculo` com o atributo protegido `double valorVeiculo` e um método abstrato `double calcularIPVA()`.
* Crie as subclasses `Carro` e `Caminhao`.
* `Carro` deve calcular o IPVA aplicando uma taxa de $4\%$ sobre o valor do veículo.
* `Caminhao` deve calcular o IPVA aplicando uma taxa de $1{,}5\%$ sobre o valor do veículo.
* Imprima o valor do IPVA de instâncias de ambas as classes.

---

## 5. Sistema de Entrega de Pedidos

**Enunciado:** Crie uma classe abstrata `ServicoEntrega` com um construtor que recebe `String enderecoDestino` e `double pesoKg`.
* Crie um método abstrato `double calcularFrete()`.
* Crie as subclasses `FreteExpresso` e `FreteEconomico`.
* No `FreteExpresso`, o cálculo é feito cobrando `pesoKg * 5.0 + 20.0` (taxa de urgência).
* No `FreteEconomico`, o cálculo é feito cobrando `pesoKg * 2.0`.
* Teste a abstração calculando o frete de diferentes pedidos.

---
