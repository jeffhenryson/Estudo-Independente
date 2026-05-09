// ## Exercício 1 — Sealed class básica

// Crie a hierarquia selada:

// ```java
// sealed class FormaPagamento permits Cartao, Boleto, Pix { }
// ```

// - `Cartao` → `final`, atributos: `numero`, `bandeira`, `parcelas`
// - `Boleto` → `final`, atributos: `codigoBarras`, `vencimento`
// - `Pix` → `final`, atributos: `chave`, `tipochave` (`"CPF"`, `"EMAIL"`, `"TELEFONE"`)

// No `main`:

// 1. Crie uma instância de cada tipo
// 2. Use `switch` com pattern matching para processar cada pagamento e imprimir uma mensagem específica
// 3. Mostre que adicionar uma classe fora do `permits` gera erro — coloque como comentário explicando

import java.util.List;

public class Exercicio01 {
    public static void main(String[] args) {

        FormaPagamento p1 = new Cartao(12345678, "Visa", 10);
        FormaPagamento p2 = new Boleto("23793.31290.60063", "20/12/2026");
        FormaPagamento p3 = new Pix("usuario@email.com", "EMAIL");

        List<FormaPagamento> pagamentos = List.of(p1, p2, p3);

        for (FormaPagamento p : pagamentos) {
            processarPagamento(p);
        }
    }

    public static void processarPagamento(FormaPagamento p) {

        switch (p) {
            case Cartao c ->
                System.out.println("Pagamento em Cartão: " + c.getBandeira() + " em " + c.getParcelas() + "x.");

            case Boleto b ->
                System.out.println("Pagamento em Boleto: Código " + b.getCodigoBarras());

            case Pix pix ->
                System.out.println("Pagamento via Pix: Chave " + pix.getTipoChave() + " (" + pix.getChave() + ")");

            default -> throw new IllegalStateException("Forma de pagamento desconhecida: " + p.getClass().getName());
        }
    }
}

sealed class FormaPagamento permits Cartao, Boleto, Pix {
}

final class Cartao extends FormaPagamento {
    private final int numero;
    private final String bandeira;
    private final int parcelas;

    Cartao(int numero, String bandeira, int parcelas) {
        this.numero = numero;
        this.bandeira = bandeira;
        this.parcelas = parcelas;
    }

    public String getBandeira() {
        return bandeira;
    }

    public int getParcelas() {
        return parcelas;
    }
}

final class Boleto extends FormaPagamento {
    private final String codigoBarras;
    private final String vencimento;

    Boleto(String codigoBarras, String vencimento) {
        this.codigoBarras = codigoBarras;
        this.vencimento = vencimento;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }
}

final class Pix extends FormaPagamento {
    private final String chave;
    private final String tipoChave; // Simplificado para String conforme o enunciado

    Pix(String chave, String tipoChave) {
        this.chave = chave;
        this.tipoChave = tipoChave;
    }

    public String getChave() {
        return chave;
    }

    public String getTipoChave() {
        return tipoChave;
    }
}

// 3. Tentativa de adicionar classe fora do permits:
/*
 * final class Cripto extends FormaPagamento { }
 * // ERRO DE COMPILAÇÃO: 'Cripto' is not allowed in the sealed hierarchy.
 * // O compilador impede a criação pois 'Cripto' não está na cláusula 'permits'
 * de FormaPagamento.
 */