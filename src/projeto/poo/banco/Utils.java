package projeto.poo.banco;

import java.util.Scanner;

public class Utils {

    public static int inputInt() {
        Scanner ler = new Scanner(System.in);
        int valor = ler.nextInt();
        return valor;
    }

    public static String inputString() {
        Scanner ler = new Scanner(System.in);
        String valor = ler.next();
        return valor;
    }

    public static double inputDouble() {
        Scanner ler = new Scanner(System.in);
        double valor = ler.nextDouble();
        return valor;
    }

}
