import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        ContaBancaria conta = null;
        
        while(option!=7){
            System.out.println("Bem vindo ao sistema bancário! Digite o número correspondente a operação que deseja realizar:");    
            if(conta == null) {
                System.out.println("1 - Abrir Conta");
            }else{
                System.out.println("2 - Realizar Depósito");
                System.out.println("3 - Realizar Saque");
                System.out.println("4 - Aplicar Juros");
                System.out.println("5 - Mostrar Extrato");
                System.out.println("6 - Integrantes do Grupo");
            }
            System.out.println("7 - Sair do Programa");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    if(conta == null){

                    }else{
                        System.out.println("A conta já foi aberta, não é possível mais utilizar essa função");
                    }
                    break;
                case 2:
                    realizaDeposito(conta, scanner);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void realizaDeposito(ContaBancaria conta, Scanner scanner){
        double valor;
        
        System.out.println("Quanto você deseja depositar?");
        valor = scanner.nextDouble();
        if(valor <= 0){
            System.out.println("Operação inválida!");
            return;
        }
        conta.movimenta(new Operacao('D', valor));
    }
}


