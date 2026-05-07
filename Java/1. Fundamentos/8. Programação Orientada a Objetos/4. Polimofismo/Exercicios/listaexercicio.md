
---

## 1. Sistema de Pagamentos

**Enunciado:** Crie uma classe base chamada `MetodoPagamento` com um método público chamado `processarPagamento()`.
* Crie duas subclasses: 
  * `CartaoCredito`
  * `Pix`
* Sobrescreva o método `processarPagamento()` em ambas as classes para exibir mensagens diferentes (ex: "Processando pagamento no cartão..." e "Processando pagamento via Pix...").
* No método `main`, crie um array do tipo `MetodoPagamento` contendo instâncias das duas classes e utilize um loop para processar o pagamento de ambos.

---

## 2. Tributação de Produtos

**Enunciado:** Crie uma classe chamada `Produto` com um método `calcularImposto()` que retorna um valor padrão (por exemplo, 10% do preço).
* Crie duas subclasses:
  * `Eletronico`
  * `Alimento`
* Sobrescreva o método `calcularImposto()` em cada subclasse:
  * Para `Eletronico`, o imposto deve ser de 30%.
  * Para `Alimento`, o imposto deve ser isento (0%).
* No `main`, crie uma lista de produtos de diferentes tipos e exiba o imposto de cada um.

---

## 3. Funcionários e Comissão

**Enunciado:** Crie uma classe base `Funcionario` com o método `calcularSalario()` que retorna o salário fixo.
* Crie subclasses `Vendedor` e `Gerente`:
  * `Vendedor` deve adicionar o atributo `comissao` e sobrescrever o método para adicionar a comissão ao salário base.
  * `Gerente` deve adicionar o atributo `bonus` e sobrescrever o método adicionando o bônus ao salário base.
* Utilize o polimorfismo para calcular e imprimir o salário de vários tipos de funcionários.

---

## 4. Personagens de um Jogo

**Enunciado:** Crie uma classe base chamada `Personagem` com um método `atacar()`.
* Crie duas subclasses: `Guerreiro` e `Mago`.
* Sobrescreva o método `atacar()` em cada uma:
  * O `Guerreiro` deve imprimir a mensagem "Atacando com espada!".
  * O `Mago` deve imprimir a mensagem "Lançando feitiço!".
* Crie uma instância de cada um armazenando-as em variáveis do tipo `Personagem` e chame o método `atacar()` para demonstrar o comportamento polimórfico.

---

## 5. Veículos e Multas

**Enunciado:** Crie uma classe `Veiculo` com um método `calcularMulta(double velocidade)` que calcula uma multa genérica caso a velocidade ultrapasse o limite de 80 km/h.
* Crie as subclasses `Carro` e `Moto`:
  * `Carro` deve ter um cálculo de multa diferenciado (ex: valor fixo + valor por km ultrapassado).
  * `Moto` deve ter um cálculo com desconto na multa.
* Demonstre o polimorfismo ao testar o método com diferentes instâncias.

---
