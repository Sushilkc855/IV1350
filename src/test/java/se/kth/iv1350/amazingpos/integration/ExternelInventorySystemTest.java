package se.kth.iv1350.amazingpos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.amazingpos.model.ItemInformationDTO;
import se.kth.iv1350.amazingpos.model.Sale;
import java.util.ArrayList;
public class ExternelInventorySystemTest {
    
    private ItemInformationDTO itemInfo1; 


    public ExternelInventorySystemTest() {
    }
    
    @BeforeEach
    public void setUp() {
        itemInfo1 = new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.13, 10); 
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetItemInformation() {
        ExternelInventorySystem inventoryInstance = new ExternelInventorySystem();
        inventoryInstance.additem(itemInfo1);

        String itemIdentifier = "AppleBarCode";
        ItemInformationDTO expResult = itemInfo1;

        ItemInformationDTO result = inventoryInstance.getItemInfomation(itemIdentifier);
        assertEquals(expResult, result, "The item was not fount in inventory");
    }

    @Test
    public void testGetItemInformationNull() {
        ExternelInventorySystem inventoryInstance = new ExternelInventorySystem();
        inventoryInstance.additem(itemInfo1);

        String itemIdentifier = "OrgangebarCode";
        ItemInformationDTO expResult = null;

        ItemInformationDTO result = inventoryInstance.getItemInfomation(itemIdentifier);
        assertEquals(expResult, result, "The item was not fount in inventory");
    }
}