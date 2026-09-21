public class Cliente {
    private String nome;
    private String cpf;
    private Data nascimento;

    public Cliente() {} //Contrutor genérico

    public Cliente(String nome, String cpf, Data nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public String getNome() {// Método para acessar o nome do cliente
        return nome;
    }

    public String getCpf() {// Método para acessar o cpf do cliente
        return cpf;
    }

    public Data getNascimento() {
        return nascimento;
    }
    

    
}
