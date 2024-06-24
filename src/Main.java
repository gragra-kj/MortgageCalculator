import java.nio.channels.FileLock;
import java.security.Principal;
import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int principal=0;
        float annualInterest=0;
        byte period=0;
        Scanner scanner=new Scanner(System.in);
        principal=(int) readNumber("Principal:",1000,100000);
        annualInterest=(float) readNumber("Annual Interest Rate: ",0,30);
        readNumber("Perion (Years): ",1,30);
        double mortgage=calculateMortgage(principal,annualInterest,period);
        String mortgageFormat= NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " +mortgageFormat);
    }
    public  static double readNumber(String prompt,double min,double max){
        Scanner scanner=new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt);
            value=scanner.nextFloat();
            if (value >= min && value <= max )
                break;
            System.out.println("Enter a value between " +min+ "and " +max);
        }
        return value;
    }
    public static double calculateMortgage(int principal,float annualInterest,byte period){
        final byte MONTH=12;
        final byte PERCENT=100;
        short numberOfPayment=(short) (period * MONTH);
        float monthlyRate=annualInterest / PERCENT / MONTH;
        double mortgage= principal *((monthlyRate*Math.pow(1+monthlyRate,numberOfPayment))/(Math.pow(1+monthlyRate,numberOfPayment) -1));
        return mortgage;
    }
}