public class ContaInvestimento extends ContaBancaria {
    private Data vencimento;

    public ContaInvestimento() {}; //Construtor genérico

    public ContaInvestimento(double saldoInicial, Data vencimento){
        super(saldoInicial);
        this.vencimento = vencimento;
    }

    public void movimenta(Operacao op) {
        super.movimenta(op); // Permite tratar depósito (D) reaproveitando da mãe    
    }

    public Data getVencimento() {
        return vencimento;
    }
    
}
