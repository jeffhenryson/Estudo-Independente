
---

## 1. Classe Produto com Validação de Preço

**Enunciado:** Crie uma classe chamada `Produto` com os seguintes atributos privados: `String nome` e `double preco`. 
* Crie um construtor que receba o nome e o preço.
* Implemente os métodos `getters` e `setters`.
* No `setter` do `preco`, adicione uma validação para que não seja permitido cadastrar um preço negativo. Caso o valor seja menor ou igual a 0, exiba uma mensagem de erro e não altere o valor.

---

## 2. Conta Bancária com Limite de Saque

**Enunciado:** Crie uma classe chamada `ContaBancaria` com os atributos privados: `String numeroConta`, `double saldo` e `double limiteSaque`.
* O `saldo` só pode ser alterado através dos métodos `depositar` e `sacar`.
* O `limiteSaque` deve poder ser alterado através de um `setter`, mas deve ser sempre um valor positivo maior que zero.
* No método `sacar(double valor)`, valide se o valor solicitado é menor ou igual ao saldo somado ao limite.

---

## 3. Controle de Temperatura

**Enunciado:** Crie uma classe chamada `Termostato` com um atributo privado `double temperaturaEmCelsius`.
* O atributo não pode ser alterado diretamente. 
* Crie um `setter` chamado `setTemperaturaEmCelsius(double temperatura)` que garanta que a temperatura não desça abaixo do zero absoluto ($-273{,}15^\circ\text{C}$).
* Crie um método que retorne a temperatura convertida para Fahrenheit (fórmula: $\text{F} = \text{C} \times 1{,}8 + 32$).

---

## 4. Cadastro de Usuário com Validação de Senha

**Enunciado:** Crie uma classe chamada `Usuario` com os atributos privados `String nome` e `String senha`.
* O nome não pode ser alterado depois da inicialização (não deve ter o `setter` do nome).
* A senha pode ser alterada através do método `setSenha`, mas o programa deve validar se a nova senha possui pelo menos 6 caracteres. Caso contrário, exiba uma mensagem como `"Senha muito curta!"`.

---

## 5. Classe Retângulo com Área e Perímetro

**Enunciado:** Crie uma classe `Retangulo` com os atributos privados `double largura` e `double altura`.
* Crie um construtor para inicializar ambos os lados com valores válidos (maior que 0).
* Crie `getters` e `setters` que impeçam valores menores ou iguais a zero.
* Crie métodos públicos que retornem a `calcularArea()` e o `calcularPerimetro()`.

---