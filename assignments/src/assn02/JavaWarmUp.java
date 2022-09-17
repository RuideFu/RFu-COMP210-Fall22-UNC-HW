package assn02;
import java.util.Scanner;  // Import the Scanner class

public class JavaWarmUp {
    // 11/22/22 12:23 food 6.9 69 0.69 69
    public static void main(String[] args) {
        // Construct a Java Scanner Obj
        Scanner scanner = new Scanner(System.in);

        // Prompt and take in number of transactions
        System.out.println("How many transactions will be entered in the database?");
        int nTransaction = Integer.parseInt(scanner.nextLine());

        // Loop: Prompt and take in transactions
        Transactions transactions = new Transactions(nTransaction);
        for (int i = 0; i < nTransaction; i++) {
            String message = "Please enter transaction (" + (i+1) + "/" + nTransaction +
                    ") in the given format: MM/DD/YY HH:MM Category Price Quantity Rating Duration)";
            System.out.println(message);
            transactions.updateTransaction(i, new Transaction(scanner.nextLine()));
        }

        System.out.println("Highest per unit sale:");
        System.out.println(transactions.getMaxUnitSale());

        System.out.println("Lowest per unit sale:");
        System.out.println(transactions.getMinUnitSale());

        System.out.println("Averages by book:");
        System.out.println(transactions.getStatsByCatalogue("book"));
        System.out.println("Averages by jewelry:");
        System.out.println(transactions.getStatsByCatalogue("jewelry"));
        System.out.println("Averages by phone:");
        System.out.println(transactions.getStatsByCatalogue("phone"));

    }
}
