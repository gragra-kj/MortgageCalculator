import java.nio.channels.FileLock;
import java.security.Principal;
import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final byte MONTH=12;
        final byte PERCENT=100;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Principal: ");
        int principal=scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        float rate=scanner.nextFloat();
        float monthlyRate=rate / PERCENT / MONTH;
        System.out.print("Period (Years): ");
        int period=scanner.nextInt();
        int numberOfPayment=period * MONTH;

        double mortgage= principal *((monthlyRate*Math.pow(1+monthlyRate,numberOfPayment))/(Math.pow(1+monthlyRate,numberOfPayment) -1));
        String mortgageFormat= NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " +mortgageFormat);



    }
}