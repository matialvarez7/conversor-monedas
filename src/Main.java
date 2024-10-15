import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();
        System.out.println("Ingrese la cantidad de dólares que desea convertir a pesos argentinos:");
        double valor = input.nextDouble();
        double resultado = conversor.convertirValorMoneda("USD", "ARS", valor);
        System.out.println("El valor es: " + resultado);
        
    }
}