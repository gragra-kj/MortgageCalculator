import java.nio.channels.FileLock;
import java.security.Principal;
import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static byte MONTHINYEARS=12;
    final static byte PERCENT=100;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int principal=(int) readNumber("Principal:",10000,1000000);
        float annualInterest=(float) readNumber("Annual Interest Rate: ",0,30);
        byte period=(byte) readNumber("Period (Years): ",1,30);
        double mortgage=calculateMortgage(principal,annualInterest,period);
        String mortgageFormat= NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Mortgage: ");
        System.out.println("-----------");
        System.out.println("Monthly Payments: " +mortgageFormat);
        printPaymentSchedule(period, principal, annualInterest);
    }

    private static void printPaymentSchedule(byte period, int principal, float annualInterest) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (short month = 1; month <= period *MONTHINYEARS; month++){
           double balance= calculateBalance(principal, annualInterest, period,month);
           System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public  static double readNumber(String prompt,double min,double max){
        Scanner scanner=new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt);
            value=scanner.nextFloat();
            if (value >= min && value <= max )
                break;
            System.out.println("Enter a value between " + min + "and " +max);
        }
        return value;
    }
    public static double calculateMortgage(int principal,float annualInterest,byte period){
        short numberOfPayment=(short) (period * MONTHINYEARS);
        float monthlyRate=annualInterest / PERCENT / MONTHINYEARS;
        double mortgage= principal *((monthlyRate*Math.pow(1+monthlyRate,numberOfPayment))/(Math.pow(1+monthlyRate,numberOfPayment) -1));
        return mortgage;
    }
    public static double calculateBalance(int principal, float annualInterest,byte period,short numberOfPaymentsMade){

        float monthlyInterest=annualInterest /PERCENT/MONTHINYEARS;
        float numberPayments=period * MONTHINYEARS;
        double balance=principal*
                (Math.pow(1+monthlyInterest,numberPayments)-Math.pow(1+monthlyInterest,numberOfPaymentsMade))
                /(Math.pow(1+monthlyInterest,numberPayments)-1);
        return balance;

    }
}