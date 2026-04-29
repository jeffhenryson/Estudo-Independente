// ## Exercício 1 — if / else básico

// Dado um valor `salario` (double), imprima a faixa de imposto de renda:

// | Faixa | Alíquota |
// | --- | --- |
// | Até R$ 2.112 | Isento |
// | De R$ 2.112 até R$ 3.751 | 15% |
// | De R$ 3.751 até R$ 7.786 | 22,5% |
// | Acima de R$ 7.786 | 27,5% |

// Teste com pelo menos 3 valores diferentes.

public class Exercicio01 {
        public static void main(String[] args) {
		double salario = 5.987;
			if(salario < 2.112){
				System.out.printf("Com o salario de %f você é isento de imposto de renda", salario);
			}
			else if (salario >= 2.112 && salario <= 3.751){
				System.out.printf("Com o salario de %f você tem 15% de imposto de renda", (salario * 0.15));
			}
			else if (salario >= 3.751 && salario <= 7.786){
				System.out.printf("Com o salario de %f você tem 22.5% de imposto de renda", (salario * 0.22));
			}
			else{
				System.out.printf("Com o salario de %f você tem 27.5% de imposto de renda", (salario * 0.27));
			}
    }
}