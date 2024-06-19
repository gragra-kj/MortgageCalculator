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
        int principal=0;
        float monthlyRate=0;
        int numberOfPayment=0;
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.print("Principal: ");
            principal=scanner.nextInt();
            if (principal >= 1000 && principal<=1000000)
                break;
            System.out.println("Please enter a value between 1000 and 1000000");
        }
        while (true){
            System.out.print("Annual Interest Rate: ");
            float rate=scanner.nextFloat();
            if (rate >0 && rate <=30){
                monthlyRate=rate / PERCENT / MONTH;
                break;
            }else {
                System.out.println("Enter a value between 1 and 30");
            }

        }
        while (true){
            System.out.print("Period (Years): ");
            int period=scanner.nextInt();
            if (period >1 && period <=30){
                numberOfPayment=period * MONTH;
                break;
            }else {
                System.out.println("Enter a value between 1 and 30");
            }

        }

        double mortgage= principal *((monthlyRate*Math.pow(1+monthlyRate,numberOfPayment))/(Math.pow(1+monthlyRate,numberOfPayment) -1));
        String mortgageFormat= NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " +mortgageFormat);



    }
}