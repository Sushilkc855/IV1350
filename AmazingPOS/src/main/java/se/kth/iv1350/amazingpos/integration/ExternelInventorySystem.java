package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.model.*;
import java.util.ArrayList;
/**
 * Inventory system has the information about how many items there are in the sore 
 * and other information about the items.
 * @author Sushil's pc
 */
public class ExternelInventorySystem {
     

    private ArrayList<ItemInformationDTO> itemList = new ArrayList<ItemInformationDTO>(); 


    /**
     * An instance of the EXternelInventorySystem. 
     */
    public ExternelInventorySystem(){
    }
    
    /**
     * This method looks for the item that has the same itemidentifier as the one 
     * sent by the chaier. 
     * @param itemIdentifier. A number or barcode that represents a specific item. 
     * @return  If they are the same this method returns information abour the item. else
     * it returns null. 
     */
    public ItemInformationDTO getItemInfomation (String itemIdentifier){
        for (ItemInformationDTO itemsInInventoryLoopVariabel : itemList) {
            if (itemsInInventoryLoopVariabel.getItemIdentifier().equals(itemIdentifier)) {
                return itemsInInventoryLoopVariabel;
            }   
        }
    return null; 
    }

    /**
     * Adds a new item to the inventory where all the information about the items are stored.  
     * @param item The item that is added to the inventory. 
     */
    public void additem(ItemInformationDTO item){
        if (item != null){
            itemList.add(item); 
        }
    }
    
    /**
     * Updates the inventory when the sale ends.  
     * @param sale: contains the nessery infomation about the sale in oder to update inventory. 
     */
    public void updateInventory(Sale sale){
        
    }
    
}
