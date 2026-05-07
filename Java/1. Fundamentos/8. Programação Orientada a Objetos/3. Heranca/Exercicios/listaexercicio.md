
---

## 1. Sistema de Veículos

**Enunciado:** Crie uma classe chamada `Veiculo` com os atributos protegidos `marca`, `modelo` e `ano`.
* Crie um construtor e um método chamado `exibirDetalhes()` que imprima essas informações.
* Crie uma subclasse chamada `Carro` que herda de `Veiculo` e adiciona o atributo privado `int numeroDePortas`.
* Crie um construtor na classe `Carro` utilizando a palavra `super` para inicializar a classe mãe, e adicione um método que exiba as portas do carro.

---

## 2. Funcionário e Subclasses

**Enunciado:** Crie uma classe base chamada `Funcionario` com os atributos `String nome` e `double salario`.
* Crie um método `calcularBonus()` que retorna `0.10 * salario` (10% de bônus).
* Crie duas subclasses:
  * `Gerente`, que adiciona o atributo `String departamento`.
  * `Desenvolvedor`, que adiciona o atributo `String linguagem`.
* Sobrescreva o método `calcularBonus()` na classe `Gerente` para retornar `0.20 * salario` (20% de bônus).

---

## 3. Cadastro de Clientes e Funcionários

**Enunciado:** Crie uma superclasse chamada `Pessoa` com os atributos `String nome` e `String cpf`.
* Crie subclasses chamadas `Cliente` (com atributo `int codigoCliente`) e `Funcionario` (com atributo `double salarioBase`).
* Implemente os construtores adequados em ambas as classes utilizando o comando `super()` e garanta que os atributos sejam protegidos ou privados com os respectivos *getters*.

---

## 4. Animais e seus Sons

**Enunciado:** Crie uma classe base chamada `Animal` com o atributo `String nome` e um método `emitirSom()`.
* Crie subclasses `Cachorro` e `Gato` que herdam de `Animal`.
* Sobrescreva o método `emitirSom()` em ambas as subclasses para imprimir o som específico de cada um (por exemplo, "Au Au" e "Miau").

---

## 5. E-commerce: Produtos Físicos e Digitais

**Enunciado:** Crie uma classe base chamada `Produto` com os atributos `String nome` e `double preco`.
* Crie duas subclasses:
  * `ProdutoFisico`, que adiciona o atributo `double peso`.
  * `ProdutoDigital`, que adiciona o atributo `double tamanhoEmMb`.
* Crie um método em ambas as subclasses que calcule o preço total, adicionando taxas ou descontos específicos para o tipo de produto.

---
