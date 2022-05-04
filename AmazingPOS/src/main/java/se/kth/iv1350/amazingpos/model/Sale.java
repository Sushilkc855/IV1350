package se.kth.iv1350.amazingpos.model;

import java.util.ArrayList;
import java.time.LocalTime; 
/**
 *One single sale made by one single customer and payed with one payment
 * @author Sushil's pc
 */
public class Sale {
    private LocalTime saleTime; 
    private Receipt receipt;
    private ArrayList<ItemInformationDTO> itemList = new ArrayList<ItemInformationDTO>(); 
    private double change; 
    private double runningTotal; 
    
    
    /**
     * Creates a new instance and saces the time of the sale.
    */
    public Sale(){
        saleTime = LocalTime.now();
        receipt = new Receipt(); 
    }  
    
    /**
     * This method checks if a item has already been register and if it is in itemList
     * @param itemIdentifier A number or barcode that represents a specific item.
     * @return if the item has already been register it retruns true else it returns false. 
     */
    public boolean checkIfItemAlreadyRegister (String itemIdentifier){
        for(int itemInItemList = 0; itemInItemList < itemList.size(); itemInItemList++) {
            if(itemIdentifier.equals(itemList.get(itemInItemList).getItemIdentifier())) {
                return true; 
            }
        }
    return false; 
    }
    
    
    /**
     * Adds a new item to the itemList where all the information about the items 
     * are stored if the item is not empty. If the item alreasy been registered it just adds up the quantity.
     * @param item: It has the information about the item to be added
     * @param quantity: amout of the same item. 
    */
    public void additem(ItemInformationDTO item, int quantity, boolean itemCheck){
        
        if (item != null && itemCheck == false){
            item.quantity = quantity; 
            itemList.add(item); 
        }
        else if(itemCheck == true && item != null){
            item.quantity += quantity;
        }
    }

    /**
     * This method updates the running total after an item and the quantity of the item
     * has been added to the itemList.
     * @param item It has the information about the item for exemple the quantity and the prise of an item. 
     */
    public void countRunningTotal(ItemInformationDTO item){
        runningTotal += item.getItemPrice() * item.getItemQuantity();  
    }
    
    /** 
     * @return this method gets the running total of the sale. At the end of the sale it is the total price of the sale. 
     */
    public double getTotalAmount(){
        return runningTotal; 
    }

    
    
}

