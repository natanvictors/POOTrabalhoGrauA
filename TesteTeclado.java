public class TesteTeclado {

    public static void main(String[] args) {
        int a = Teclado.leInt("Digite um inteiro: ");
        double b = Teclado.leDouble("Digite um double: ");
        String c = Teclado.leString("Digite uma string: ");
        char d = Teclado.leChar("Digite um char: ");

        System.out.println("Você digitou o inteiro: " + a);
        System.out.println("Você digitou o double: " + b);
        System.out.println("Você digitou a string: " + c);
        System.out.println("Você digitou o char: " + d);
    }
}