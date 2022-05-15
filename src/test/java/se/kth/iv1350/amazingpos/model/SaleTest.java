package se.kth.iv1350.amazingpos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
/**
 *
 * @author sushil
 */
public class SaleTest {
    
    private ItemInformationDTO itemInfo1; 
    private ItemInformationDTO itemInfo2;
    private ItemInformationDTO itemInfo3;
    private Sale saleInstance = new Sale();  
    boolean itemCheckFalse = false; 
    boolean itemCheckTrue = true; 
    
    @BeforeEach
    public void setUp() {
        itemInfo1 = new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.13, 10); 
        itemInfo2 = new ItemInformationDTO("Milk", "MilkBarCode", 10, 0.11, 2); 
        itemInfo3 = new ItemInformationDTO(); 

    }
    
    
    @AfterEach
    public void tearDown() {
        itemInfo1 = null; 
        itemInfo2 = null; 
        itemInfo3 = null; 
    }

    @Test
    public void testAddOneItem() {
        saleInstance.additem(itemInfo1);
        ArrayList<ItemInformationDTO> testItemList = saleInstance.getListOfItems();  
        ArrayList<ItemInformationDTO> goodsItemList = new ArrayList<ItemInformationDTO>();  
        goodsItemList.add(itemInfo1); 
        assertEquals(testItemList.get(0).getItemIdentifier(), goodsItemList.get(0).getItemIdentifier(), "The items in the two lists are not the same");   
    }

    @Test
    public void testAddMultipelItem() {
        saleInstance.additem(itemInfo1);
        saleInstance.additem(itemInfo2);
        saleInstance.additem(itemInfo3);
        ArrayList<ItemInformationDTO> testItemList = saleInstance.getListOfItems();  

        ArrayList<ItemInformationDTO> goodsItemList = new ArrayList<ItemInformationDTO>();  
        goodsItemList.add(itemInfo1); 
        goodsItemList.add(itemInfo2);
        goodsItemList.add(itemInfo3);

        assertEquals(testItemList.get(0).getItemIdentifier(), goodsItemList.get(0).getItemIdentifier(), "The items1 in the two lists are not the same");   
        assertEquals(testItemList.get(1).getItemIdentifier(), goodsItemList.get(1).getItemIdentifier(), "The items2 in the two lists are not the same");
        assertEquals(testItemList.get(2).getItemIdentifier(), goodsItemList.get(2).getItemIdentifier(), "The items3 in the two lists are not the same");
    }

    @Test
    public void testAddOneItemAlreadyRegister() {
        Sale instance = new Sale();
        instance.additem(itemInfo1);
        instance.additem(itemInfo2);
        ArrayList<ItemInformationDTO> testItemList = instance.getListOfItems();  

        ArrayList<ItemInformationDTO> goodsItemList = new ArrayList<ItemInformationDTO>();  
        goodsItemList.add(itemInfo2); 
        
        assertEquals(testItemList.get(0).getItemIdentifier(), goodsItemList.get(0).getItemIdentifier(), "Item added when it is already registered");  
    }


    @Test
    public void testCheckIfItemAlreadyRegisterFalse() {
        String itemIdentifier = "RandomBarCode";
        Sale instance = new Sale();
        boolean expResult = false;
        boolean result = instance.checkIfItemAlreadyRegister(itemIdentifier);
        assertEquals(expResult, result, "Item ditected when its is not in the sale list.");
    }

 
    @Test
    public void testCheckIfItemIsNotRegistered() {
        String itemIdentifier = "AppleBarCode";
         boolean expResult = true;
        Sale instance = new Sale();
        instance.additem(itemInfo1);
        
        boolean result = instance.checkIfItemAlreadyRegister(itemIdentifier);
        assertEquals(expResult, result, "Item detected when it's not in the sale list.");
    }

    @Test
    public void testCountRunningTotal() {
        Sale instance = new Sale();
        instance.additem(itemInfo1);
        instance.additem(itemInfo2);
        double runningTotal = instance.countRunningTotal();

        double testRunningTotal = itemInfo1.getItemQuantity() * itemInfo1.getItemPrice(); 
        testRunningTotal += itemInfo2.getItemQuantity() * itemInfo2.getItemPrice(); 
        assertEquals(runningTotal, testRunningTotal, "the running total are not same.");
    }


    @Test
    public void testGetTotalAmount() {
        Sale instance = new Sale();
        instance.additem(itemInfo1);
        instance.additem(itemInfo2);
        double runningTotal = instance.getTotalAmount();

        double testGetExpectedTotalAmount = itemInfo1.getItemQuantity() * itemInfo1.getItemPrice(); 
        testGetExpectedTotalAmount += itemInfo2.getItemQuantity() * itemInfo2.getItemPrice(); 
        assertEquals(runningTotal, testGetExpectedTotalAmount, "the running total are not same.");
    }
    
}
