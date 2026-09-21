public class Movimentacao {
    private int quantidade;
    private double valorTotal;

    public Movimentacao() {} //Contrutor genérico

    public int getQuantidade() { // Método para acessar o atributo quantidade
        return quantidade;
    }

    public void setQuantidade(int quantidade) { // Método para definir o valor do atributo quantidade
        this.quantidade = quantidade;
    }

    public double getValorTotal() { // Método para acessar o atributo valor total
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) { // Método para definir o valor do atributo valor total
        this.valorTotal = valorTotal;
    } 

    
}
