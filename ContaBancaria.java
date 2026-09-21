public class ContaBancaria {
    private Cliente cliente;
    private double saldoAtual;
    private Movimentacao depositos;
    private Movimentacao saques;
    private Movimentacao juros;
    private double saldoMaximo;
    private double saldoMinimo;
    private double saldoInicial;

    public ContaBancaria() {
    } // Contrutor genérico

    public ContaBancaria(double saldoInicial) { // Contrutor que tem como parâmetro o Saldo Inicial
        this.saldoInicial = saldoInicial;
        this.saldoAtual = saldoInicial;
        this.depositos = new Movimentacao();
        this.saques = new Movimentacao();
        this.juros = new Movimentacao();
        this.saldoMinimo = saldoInicial;
        this.saldoMaximo = saldoInicial;
    }

    public void movimenta(Operacao op) {
        if (op.getTipo() == 'S') { // Lógica padrão de saque
            double saldoAtualizado = getSaldoAtual() - op.getValor();
            setSaldoAtual(saldoAtualizado);
            getSaques().setQuantidade(getSaques().getQuantidade() + 1);
            getSaques().setValorTotal(getSaques().getValorTotal() + op.getValor());
        } else if (op.getTipo() == 'D') { // Lógica padrão de depósito
            double saldoAtualizado = getSaldoAtual() + op.getValor();
            setSaldoAtual(saldoAtualizado);
            getDepositos().setQuantidade(getDepositos().getQuantidade() + 1);
            getDepositos().setValorTotal(getDepositos().getValorTotal() + op.getValor());
        } else if (op.getTipo() == 'J') {
            double valorJuros = getSaldoAtual() * op.getValor() / 100;
            double saldoAtualizado = getSaldoAtual() + valorJuros;
            setSaldoAtual(saldoAtualizado);
            getJuros().setQuantidade(getJuros().getQuantidade() + 1);
            getJuros().setValorTotal(getJuros().getValorTotal() + valorJuros);
        }
    }

    public double getSaldoAtual() {// Getter usado para retornar o valor do atributo
        return saldoAtual;
    }

    public void setSaldoAtual(double novoSaldo) {
        this.saldoAtual = novoSaldo;
        if (saldoMaximo < novoSaldo) {
            this.saldoMaximo = novoSaldo;
        }
        if (saldoMinimo > novoSaldo) {
            this.saldoMinimo = novoSaldo;
        }
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Movimentacao getDepositos() {
        return depositos;
    }

    public Movimentacao getSaques() {
        return saques;
    }

    public Movimentacao getJuros() {
        return juros;
    }

    public double getSaldoMaximo() {
        return saldoMaximo;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean verificaCedulas(int valor, int indice, int[] quantidade) {
        int[] cedulas = { 100, 50, 20, 10, 5, 2 };

        if (valor == 0) {
            return true;
        }

        if (valor < 0 || indice == cedulas.length) {
            return false;
        }

        quantidade[indice]++;

        if (verificaCedulas(valor - cedulas[indice], indice, quantidade)) {
            return true;
        }

        quantidade[indice]--;

        return verificaCedulas(valor, indice + 1, quantidade);
    }

    public boolean podeSacar(double valor) {
        return valor <= getSaldoAtual();
    }

}
