package view;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInt(String msg){
        int valor = 0;
        while(true){
            try { 
                System.out.print(msg + ": ");
                valor = scanner.nextInt();
                break; 
            
            } catch (InputMismatchException e) {
                System.out.println("O valor informado não é um inteiro.");
            
            } finally { 

                scanner.nextLine(); 
            }
        }

        return valor;
    }

    public static float lerFloat() {
        float valor = 0;

        while (true) {
            try {
                valor = scanner.nextFloat();
                scanner.nextLine();
                break;

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("O valor informado não é um 'float'. Digite novamente: ");
            }
        }
        return valor;
    }

    public static String lerString(String msg) {
        System.out.print(msg + ": ");
        return scanner.nextLine();
    }


}
