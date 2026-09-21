public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {} //Construtor genérico 

    public Data(int dia, int mes, int ano) { // Construtor com os parâmetros da classe
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public String toString() { // To String para mostrar os dados
        return dia + "/" + mes + "/" + ano;
    } 
}
