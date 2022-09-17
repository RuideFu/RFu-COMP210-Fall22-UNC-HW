package assn02;
import java.util.Scanner;  // Import the Scanner class

public class JavaWarmUp {
    public static void main(String[] args) {
        // Construct a Java Scanner Obj
        Scanner scanner = new Scanner(System.in);

        // Prompt and take in number of transactions
        System.out.println("How many transactions will be entered in the database?");
        int nTransaction = Integer.parseInt(scanner.nextLine());

        // Loop: Prompt and take in transactions
        String[] Transactions = new String[nTransaction];
        for (int i = 0; i < nTransaction; i++) {
            String message = "Please enter transaction (" + (i+1) + "/" + nTransaction +
                    ") in the given format: MM/DD/YY, HH:MM, Category, Price, Quantity, Rating, Duration)";
            System.out.println(message);
            Transactions[i] = scanner.nextLine();
        }
        System.out.println(Transactions);
    }
}
