import java.util.Scanner;

/**
 * Created by Max Erling
 * Date: 2021-05-08
 * Copyright: MIT
 * Class: Java20B
 */
public class Main {

    public static void main(String[] args) {
        ATM atm = new ATM(4000,2,3,5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the ATM, what would you like to do?");
            System.out.println("1.Withdraw");
            System.out.println("2.See current amount");
            System.out.println("3.Exit");

            String action = sc.nextLine();

            switch (action) {
                case "1":
                    while (true) {
                    System.out.println("How much do you wanna withdraw?");
                    try {
                        int amount = Integer.parseInt(sc.nextLine());
                        System.out.println(atm.withdraw(amount));
                        break;
                    } catch (NumberFormatException n) {
                        System.out.println("Incorrect entry, try again!");
                    }
                    }
                    break;
                case "2":
                    System.out.println(atm.getBalance());
                    break;
                case "3":
                    System.out.println("Shutting down...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect entry, try again!");

            }
        }
    }
}
