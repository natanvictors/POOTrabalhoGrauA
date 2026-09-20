public class ContaBancaria {
    private Cliente cliente;
    private double saldoInicial;
    private Movimentacao depositos;
    private Movimentacao saques;
    private Movimentacao juros;

    public void movimenta(Operacao op){
        if (op.getTipo()=='D'){
            saldoInicial+=op.getValor();
        }
    }
}
