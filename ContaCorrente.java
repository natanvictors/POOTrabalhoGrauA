public class ContaCorrente extends ContaBancaria { // Extends usado para herdar as caracteristicas da classe
                                                   // ContaBancaria
    private double limiteCredito;

    public ContaCorrente() {
    } // Contrutor genérico

    public ContaCorrente(double saldoInicial, double limiteCredito) { // Construtor que tem os parâmetros Saldo Inicial
                                                                      // e Limite de Crédito
        super(saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    public void movimenta(Operacao op) {
        super.movimenta(op); // Reutiliza a lógica de Saque e Depósito da classe mãe
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public boolean podeSacar(double valor) {
        return valor <= getSaldoAtual() + limiteCredito;
    }

}
