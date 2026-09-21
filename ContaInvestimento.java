public class ContaInvestimento extends ContaBancaria {
    private Data vencimento;

    public ContaInvestimento() {}; //Construtor genérico

    public ContaInvestimento(double saldoInicial, Data vencimento){
        super(saldoInicial);
        this.vencimento = vencimento;
    }

    public void movimenta(Operacao op) {
        super.movimenta(op); // Permite tratar depósito (D) reaproveitando da mãe
        
        if (op.getTipo() == 'J') {
            double taxa = op.getValor();
            double rendimento = getSaldoAtual() * (taxa / 100);
            setSaldoAtual(getSaldoAtual() + rendimento);
            getJuros().setQuantidade(getJuros().getQuantidade() + 1); // Adiciona um na quantidade de depósitos feitos
            getJuros().setValorTotal(getJuros().getValorTotal() + rendimento); // Soma o valor do novo deposito aos que já forma feitos
        }
    
    }

    public Data getVencimento() {
        return vencimento;
    }
    
}
