public class ContaPoupanca extends ContaBancaria {
    private int diaAniversario;

    public ContaPoupanca() {} // Contrutor genérico 

    public ContaPoupanca(double saldoInicial, int diaAniversario) {// Contrutor que tem os parâmetros de saldo inicial e "dia do aniversário" da conta
        super(saldoInicial); // Atualiza o saldo na conta mãe
        this.diaAniversario = diaAniversario; // Atualiza o atributo 
    }

    public int getDiaAniversario() { // Método get criado para disponibilizar o acesso ao atributo
        return diaAniversario;
    }
    
   public void movimenta (Operacao op) {
        super.movimenta(op); // Reutiliza a lógica de Saque e Depósito da classe mãe
        
        if (op.getTipo() == 'J') { // Trata especificamente dos juros
            double taxa = op.getValor();
            double rendimento = getSaldoAtual() * (taxa / 100);
            setSaldoAtual(getSaldoAtual() + rendimento);
            getJuros().setQuantidade(getJuros().getQuantidade() + 1); // Adiciona um na quantidade de depósitos feitos
            getJuros().setValorTotal(getJuros().getValorTotal() + rendimento); // Soma o valor do novo deposito aos que já forma feitos
        }
    }
}
