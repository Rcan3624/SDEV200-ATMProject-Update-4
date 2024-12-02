import java.util.Scanner;

public class ATMSimulation {

    // Account information (PIN and balance)
    private static final String PIN = "1234"; // Hardcoded PIN for simplicity
    private static double balance = 1000.0; // Initial balance for the account

    // Method to display the main menu
    private static void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
    }

    // Method to handle the login process
    private static boolean login(String pin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();
        return enteredPin.equals(pin);
    }

    // Method to check the balance
    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Method to deposit money
    private static void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". Your new balance is $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    private static void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". Your new balance is $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        // Login process
        if (!login(PIN)) {
            System.out.println("Incorrect PIN. Exiting program.");
            return;
        }

        boolean isRunning = true;
        while (isRunning) {
            // Display the menu options
            displayMenu();
            int choice = scanner.nextInt();

            // Perform actions based on user's choice
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Exiting. Thank you for using the ATM!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
