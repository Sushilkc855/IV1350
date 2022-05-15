package se.kth.iv1350.amazingpos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sushil
 */
public class CashPaymentTest {

    private ItemInformationDTO itemInfo1; 

    public CashPaymentTest() {
    }
    
    @BeforeEach
    public void setUp() {
        itemInfo1 = new ItemInformationDTO("Apple", "AppleBarCode", 8, 0.13, 10); 
    }
    
    @AfterEach
    public void tearDown() {
        itemInfo1 = null; 
    }

    @Test
    public void testChangeToGiveCostumer() {
        Sale sale = new Sale(); 
        sale.additem(itemInfo1);
        double cashPayed = 100;
        double expResult = 20;

        CashPayment payment = new CashPayment(); 
        double result = payment.changeToGiveCustomer(sale, cashPayed);

        assertEquals(expResult, result, "The test case is a prototype.");
    }
    
}