public class Operacao {
    private char tipo;
    private double valor;

    public Operacao(){} //Construtor genérico criado devido boas práticas

    public Operacao(char tipo, double valor){  // Contrutor criado para realizar a operação
        this.tipo = tipo; // Atualizando o atributo tipo
        this.valor = valor; // Atualizando o atributo valor 
    }

    public char getTipo() {// Metodo Get para retornar o valor do atributo tipo
        return tipo; // Busca o valor presente no atibuto e revolve
    }

    public double getValor() { // Metodo Get para retornar o valor do atributo valor
        return valor; // Busca o valor presente no atibuto e revolve
    }

    
}

