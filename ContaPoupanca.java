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
    
}
