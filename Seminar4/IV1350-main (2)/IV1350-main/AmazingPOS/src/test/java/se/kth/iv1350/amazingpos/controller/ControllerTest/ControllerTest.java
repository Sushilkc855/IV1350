package se.kth.iv1350.amazingpos.controller.ControllerTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.amazingpos.model.CashPayment;
import se.kth.iv1350.amazingpos.model.Receipt;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.model.StoreAddress;
import se.kth.iv1350.amazingpos.controller.*;
import se.kth.iv1350.amazingpos.integration.DatabaseServerNotRunning;
import se.kth.iv1350.amazingpos.integration.ItemNotFoundInInventoryException;
import se.kth.iv1350.amazingpos.model.*;


public class ControllerTest {
    private ItemInformationDTO itemInfo1; 
    private ItemInformationDTO itemInfo2;
    
    @BeforeEach
    public void setUp() {
        itemInfo1 = new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.13, 10); 
        itemInfo2 = new ItemInformationDTO("Milk", "MilkBarCode", 10, 0.11, 2); 
        
    }
    
    @AfterEach
    public void tearDown() {
        itemInfo1 = null; 
        itemInfo2 = null; 
    }

    @Test
    public void testScanItem() throws ItemNotFoundInInventoryException, DatabaseServerNotRunning {
        Controller contr = new Controller();
        ItemInformationDTO item2 = new ItemInformationDTO();
        contr.startSale();
        try{
        item2 = contr.scanItem("AppleBarCode", 10);
        }
        catch(Exception exception){
            assert(true);
        }
        String itemName = item2.getItemName();
        String itemName2 = itemInfo1.getItemName();
        assertEquals(itemName, itemName2, "The method did not return the expexted item"); 
    }

    @Test
    public void testRunningTotal() throws ItemNotFoundInInventoryException, DatabaseServerNotRunning {
        Controller instance = new Controller();
        instance.startSale();
        instance.scanItem("AppleBarCode", 10);
        double expResult = 150;
        double result = instance.runningTotal();
        assertEquals(expResult, result, "The method returns the expected running totalamount");
    }

    @Test
    public void testRunningTotal2() {
        Controller instance = new Controller();
        instance.startSale();
        double expResult = 0;
        double result = instance.runningTotal();
        assertEquals(expResult, result, "The method returns the expected running totalamount");
    }

@Test
    public void testTotalAmount() throws ItemNotFoundInInventoryException, DatabaseServerNotRunning {
        Controller instance = new Controller();
        instance.startSale();
        instance.scanItem("AppleBarCode", 10);
        double expResult = 150;
        double result = instance.totalAmount();
        assertEquals(expResult, result, "The method returns the expected totalamount");
    }

    @Test
    public void testTotalAmount2() {
        Controller instance = new Controller();
        instance.startSale();
        double expResult = 0;
        double result = instance.totalAmount();
        assertEquals(expResult, result, "The method returns the expected running totalamount");
    }


    @Test
    public void testRegisterPayment() throws ItemNotFoundInInventoryException, DatabaseServerNotRunning {
        double amountPayedByCostumer = 300;
        Controller instance = new Controller();
        instance.startSale();
        double expResult = 150;
        instance.scanItem("AppleBarCode", 10);
        double result = instance.registerPayment(amountPayedByCostumer);
        assertEquals(expResult, result, "The test case is a prototype.");
    }

    @Test
    public void testRegisterPayment2() {
        double amountPayedByCostumer = 150;
        Controller instance = new Controller();
        instance.startSale();
        double expResult = 150;
        double result = instance.registerPayment(amountPayedByCostumer);
        assertEquals(expResult, result, "The test case is a prototype.");
    }


    @Test
    public void testGetReceipt() {
        Controller instance = new Controller();
        instance.startSale();
        Sale sale = new Sale();
        StoreAddress storeAddress = new StoreAddress();
        CashPayment payment = new CashPayment();
        Receipt result = instance.getReceipt(sale, storeAddress, payment);
        String expResult =  " Isafjordsgatan 22";
        assertEquals(expResult, result.getStoreAddress().getStreetName(), "The test case is a prototype.");
    }

    
}