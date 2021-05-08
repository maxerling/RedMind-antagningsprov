import org.junit.jupiter.api.BeforeEach;
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

    @Test
    public void withdrawTest() {
        String result = atm.withdraw(500);
        assertEquals("Current amount: " + atm.getBalance() + "\n" +
                "Thousand bills x 0" + "\n" +
                "Five hundred bills x 1" + "\n" +
                "Hundred bills x 0",result);
    }

    @Test
    public void withdrawGreaterThanBalanceTest() {
        String result = atm.withdraw(5000);
        assertEquals("Not enough balance, try again!",result);
    }

    @Test
    public void withdrawLessThanBalanceTest() {
        String result = atm.withdraw(-500);
        assertEquals("Not enough balance, try again!",result);
    }



    @Test
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

        assertEquals("Current amount: " + atm2.getBalance() + "\n" +
                "Thousand bills x 0" + "\n" +
                "Five hundred bills x 0" + "\n" +
                "Hundred bills x 4",result);


        result = atm2.withdraw(1100);

        assertEquals("Current amount: " + atm2.getBalance() + "\n" +
                "Thousand bills x 1" + "\n" +
                "Five hundred bills x 0" + "\n" +
                "Hundred bills x 1",result);


        result = atm2.withdraw(1000);

        assertEquals("Not enough balance, try again!",result);

        result = atm2.withdraw(700);

        assertEquals("Not enough balance, try again!",result);

        result = atm2.withdraw(300);

        assertEquals("Current amount: " + atm2.getBalance() + "\n" +
                "Thousand bills x 0" + "\n" +
                "Five hundred bills x 0" + "\n" +
                "Hundred bills x 3",result);

        assertEquals(0,atm2.getBalance());
        assertNotEquals(100,atm2.getBalance());

    }




}
