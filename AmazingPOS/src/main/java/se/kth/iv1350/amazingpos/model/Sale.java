package se.kth.iv1350.amazingpos.model;

import java.util.ArrayList;
import java.time.LocalTime; 
/**
 *One single sale made by one single customer and payed with one payment
 * @author Sushil's pc
 */
public class Sale {
    LocalTime saleTime; 
    private Receipt receipt;
    private ArrayList<ItemInformationDTO> itemList = new ArrayList<ItemInformationDTO>(); 
    private double runningTotal; 
    private double totalAmout;
    
    /**
     * Creates a new instance and saces the time of the sale.
    */
    public Sale(){
        saleTime = LocalTime.now();
        receipt = new Receipt(); 
    }  
    
    /**
     * This method checks if a item has already been register and if it is in itemList. If a item has already been
     * registed the it just adds up the quantity of the item. 
     * @param itemIdentifier A number or barcode that represents a specific item.
     * @return if the item has already been register it retruns true else it returns false. 
     */
    public boolean checkIfItemAlreadyRegister (String itemIdentifier){
        for(int itemInItemList = 0; itemInItemList < itemList.size(); itemInItemList++) {
            if(itemIdentifier.equals(itemList.get(itemInItemList).getItemIdentifier())) {
                itemList.get(itemInItemList).quantity +=1; 
                return true; 
            }
        }
    return false; 
    }
    
    
    /**
     * Adds a new item to the itemList where all the information about the items 
     * are stored if the item is not empty. If the item alreasy been registered it just adds up the quantity.
     * @param item: It has the information about the item to be added
     * @param itemCheck: A boolen that is true if an item has already been registered or false if it not.  
    */
    public void additem(ItemInformationDTO item, boolean itemCheck){
        if (item != null && itemCheck == false){
            itemList.add(item); 
        }
    }


    /**
     * Retuns the current list of item in the sale. 
     */
    public ArrayList<ItemInformationDTO> getListOfItems(){
        return this.itemList; 
    }

    /**
     * This method updates the running total by going through the item list and the quntity of an item times the price of the item
     * is the running total.
     * @return returng the current running total of the sale.  
     */
    public double countRunningTotal(){
        for(int itemInItemList = 0; itemInItemList < itemList.size(); itemInItemList++){
            runningTotal +=  itemList.get(itemInItemList).quantity * itemList.get(itemInItemList).getItemPrice();  
        }
        return runningTotal; 
    }
    
    /** 
     * @return this method gets the running total of the sale. At the end of the sale it is the totalprice of the sale. 
     */
    public double getTotalAmount(){
        totalAmout = countRunningTotal();
        return totalAmout; 
    }

}

