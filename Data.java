public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
    } // Construtor genérico

    public Data(int dia, int mes, int ano) { // Construtor com os parâmetros da classe
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}
