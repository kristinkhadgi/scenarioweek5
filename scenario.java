import java.util.Scanner;

/**
 * Write a description of class scenario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class scenario
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" Nepal Investment Bank - Fixed Deposit Calculator");

        char choice = 'y';

        while (choice == 'y' || choice == 'Y') {

            System.out.print("Enter deposit amount (minimum Rs. 1000): ");
            double P = sc.nextDouble();

            while (P < 1000) {
                System.out.print("Amount must be at least Rs. 1000. Enter again: ");
                P = sc.nextDouble();
            }

            System.out.print("Enter annual interest rate (8% to 12%): ");
            double annualRate = sc.nextDouble();

            while (annualRate < 8 || annualRate > 12) {
                System.out.print("Rate must be between 8% and 12%. Enter again: ");
                annualRate = sc.nextDouble();
            }

            System.out.print("Enter duration in years (1 to 5): ");
            int years = sc.nextInt();

            while (years < 1 || years > 5) {
                System.out.print("Years must be between 1 and 5. Enter again: ");
                years = sc.nextInt();
            }

            double monthlyRate = annualRate / 12 / 100; 
            int months = years * 12;

            double A = P * Math.pow((1 + monthlyRate), months);

    
            double feeRate = 0.005;  // 0.5%
            double fee = A * feeRate;

            // Final amount that customer receives
            double finalAmount = A - fee;

            
            System.out.println("\n Fixed Deposit Summary");
            System.out.println("Principal (P): Rs. " + P);
            System.out.println("Annual Rate: " + annualRate + "%");
            System.out.println("Monthly Rate: " + monthlyRate);
            System.out.println("Duration: " + years + " years (" + months + " months)");
            System.out.println("Maturity Amount before fee (A): Rs. " + String.format("%.2f", A));
            System.out.println("Processing Fee (0.5%): Rs. " + String.format("%.2f", fee));
            System.out.println("Final Amount Received: Rs. " + String.format("%.2f", finalAmount));

            System.out.print("\nDo you want to calculate another FD? (y/n): ");
            choice = sc.next().charAt(0);
        }

        System.out.println("\nThank you for using NIB FD Calculator!");
    }
}


