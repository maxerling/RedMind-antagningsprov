import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Max Erling
 * Date: 2021-05-08
 * Copyright: MIT
 * Class: Java20B
 */
public class MainTest {
    private ATM atm;

    @BeforeEach
    public void setUp() { atm = new ATM(4000,2,3,5);}

    @Nested
    @DisplayName("withdraw method")
    class withdrawTest {
        @Test
        @DisplayName("Testing for viable withdraw")
        public void withdrawTest() {
            String result = atm.withdraw(500);
            assertEquals("Current amount: " + atm.getBalance() + "\n" +
                    "Thousand bills x 0" + "\n" +
                    "Five hundred bills x 1" + "\n" +
                    "Hundred bills x 0",result, "should return viable message");}

        @Test
        @DisplayName("Testing for greater than the balance amount")
        public void withdrawGreaterThanBalanceTest() {
            String result = atm.withdraw(5000);
            assertEquals("Not enough balance, try again!",result, "should return nonviable message");
        }

        @Test
        @DisplayName("Testing for less than the balance amount")
        public void withdrawLessThanBalanceTest() {
            String result = atm.withdraw(-500);
            assertEquals("Not enough balance, try again!",result, "should return nonviable message");
        }

        @Test
        @DisplayName("Testing for not available bill")
        public void withdrawLessThanBillTest() {

            String result = atm.withdraw(5);

            assertEquals("Not enough balance, try again!",result, "should return nonviable message");
        }

    }




    @Test
    @DisplayName("Testing the entire \"simulation\"")
    public void completeTest() {
        ATM atm2 = new ATM(4000,2,3,5);

        String result = atm2.withdraw(1500);

        assertEquals("Current amount: " + atm2.getBalance() + "\n" +
                "Thousand bills x 1" + "\n" +
                "Five hundred bills x 1" + "\n" +
                "Hundred bills x 0",result);


        result = atm2.withdraw(700);

        assertEquals("Current amount: " + atm2.getBalance() + "\n" +
                "Thousand bills x 0" + "\n" +
                "Five hundred bills x 1" + "\n" +
                "Hundred bills x 2",result);


        result = atm2.withdraw(400);
        assertEquals("Not enough balance, try again!",result,"should return nonviable message");


        result = atm2.withdraw(1100);

        assertEquals("Current amount: " + atm2.getBalance() + "\n" +
                "Thousand bills x 1" + "\n" +
                "Five hundred bills x 0" + "\n" +
                "Hundred bills x 1",result);


        result = atm2.withdraw(1000);

        assertEquals("Not enough balance, try again!",result,"should return nonviable message");

        result = atm2.withdraw(700);

        assertEquals("Current amount: 0\n" +
                "Thousand bills x 0\n" +
                "Five hundred bills x 1\n" +
                "Hundred bills x 2",result);

        result = atm2.withdraw(300);

        assertEquals("Not enough balance, try again!",result,"should return nonviable message");

        assertEquals(0,atm2.getBalance(), "should return 0");
        assertNotEquals(100,atm2.getBalance(), "should not return 100");


        assertEquals(0,atm2.getThousandBills(), "should return 0");
        assertEquals(0,atm2.getFiveHundredBills(), "should return 0");
        assertEquals(0,atm2.getHundredBills(),"should return 0");
    }




}
