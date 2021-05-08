/**
 * Created by Max Erling
 * Date: 2021-05-08
 * Copyright: MIT
 * Class: Java20B
 */



public class ATM {
    private int balance;
    private int thousandBills;
    private int fiveHundredBills;
    private int hundredBills;


    public ATM(int balance,int thousandBills, int fiveHundredBills, int hundredBills) {
        this.balance = balance;
        this.thousandBills = thousandBills;
        this.fiveHundredBills = fiveHundredBills;
        this.hundredBills = hundredBills;


    }


    public String withdraw(int amount) {
        int[] billCounter = new int[3];
        if (amount <= balance && amount > 0) {
            setBalance(this.balance-amount);
            int amountOfThousandBillsAmount = (int) Math.floor(amount/1000);

            if (amountOfThousandBillsAmount <= thousandBills && amount >= 1000) {
                billCounter[0] = amountOfThousandBillsAmount;
                amount -= 1000 * billCounter[0];
            }

            int amountOfFiveHundredBillsAmount = (int) Math.floor(amount/500);

            if (amountOfFiveHundredBillsAmount <= fiveHundredBills && amount >= 500) {
                billCounter[1] = amountOfFiveHundredBillsAmount;
                amount -= 500 * billCounter[1];
            }

            int amountOfHundredBillsAmount = (int) Math.floor(amount/100);

            if (amountOfHundredBillsAmount <= hundredBills && amount >= 100) {
                billCounter[2] = amountOfHundredBillsAmount;
                amount -= 100 * billCounter[2];
            }

            return "Current amount: " + getBalance() + "\n" +
                    "Thousand bills x " + billCounter[0] + "\n" +
                    "Five hundred bills x " + billCounter[1] + "\n" +
                    "Hundred bills x " + billCounter[2];
        } else {
            return "Not enough balance, try again!";
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
