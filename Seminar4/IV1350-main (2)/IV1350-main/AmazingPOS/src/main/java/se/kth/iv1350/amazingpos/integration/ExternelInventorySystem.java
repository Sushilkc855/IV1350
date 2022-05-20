package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.model.*;
import java.util.ArrayList;
/**
 * Inventory system has the information about how many items there are in the sore 
 * and other information about the items.
 * @author Sushil's pc
 */
public class ExternelInventorySystem {
    
    public ArrayList<ItemInformationDTO> itemList = new ArrayList<ItemInformationDTO>(); 
    /**
     * An instance of the EXternelInventorySystem. 
     * The items in the list are for testing purposes. 
     */
    public ExternelInventorySystem(){
        itemList.add(new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.13, 10)); 
        itemList.add(new ItemInformationDTO("Milk", "MilkBarCode", 10, 0.11, 2));
        itemList.add(new ItemInformationDTO("Milk", "1", 10, 0.11, 6));
        itemList.add(new ItemInformationDTO("Milk", "2", 5, 0.11, 6));
        itemList.add(new ItemInformationDTO("Milk", "4", 10, 0.11, 6));
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
     * This method looks for the item that has the same itemidentifier as the one 
     * sent by the chaier. 
     * @param itemIdentifier. A number or barcode that represents a specific item. 
     * @return  If they are the same this method returns information abour the item. else
     * it returns null. 
     * @throws ItemNotFoundInInventoryException an item with a specefic itemidentifier is not found in inventory
     * @throws DatabaseServerNotRunning indicates that the database can not be called
     */
    public ItemInformationDTO getItemInfomation (String itemIdentifier, int quantity) throws ItemNotFoundInInventoryException, DatabaseServerNotRunning{
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemIdentifier().equals(itemIdentifier)) {
                return itemList.get(i);
            }   
            else if(itemIdentifier == "InvalidItemName"){
                throw new DatabaseServerNotRunning("The database is currently offline");
            }
            else{
                throw new ItemNotFoundInInventoryException("This item with itemIdentifier: "+ itemIdentifier+ " was not found in inventory" );
            }
        }
        
    return null; 
    }

  
    
    /**
     * Updates the inventory when the sale ends.  
     * @param sale: contains the nessery infomation about the sale in oder to update inventory. 
     */
    public void updateInventory(Sale sale){
        
    }
    
}