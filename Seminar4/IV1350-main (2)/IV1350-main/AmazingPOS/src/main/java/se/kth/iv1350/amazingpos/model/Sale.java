package se.kth.iv1350.amazingpos.model;
import se.kth.iv1350.amazingpos.integration.*; 
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime; 
/**
 *One single sale made by one single customer and payed with one payment
 * @author Sushil's pc
 */
public class Sale {
    LocalTime saleTime; 
    private Receipt receipt;
    private ArrayList<ItemInformationDTO> itemList = new ArrayList<ItemInformationDTO>(); 
    private double totalAmout = 0;
    private int itemInItemList;
    private boolean itemCheck;
    private ExternelInventorySystem externelInventorySystem = new ExternelInventorySystem(); 
    private List<RevenueObserver> revenueObservers;
    
    /**
     * Creates a new instance and saves the time of the sale.
    */
    public Sale(){
        saleTime = LocalTime.now();
        receipt = new Receipt(); 
        revenueObservers = new ArrayList<RevenueObserver>(); 
    }  
    
    /**
     * This method checks if a item has already been register and if it is in itemList. If a item has already been
     * registed the it just adds up the quantity of the item. 
     * @param itemIdentifier A number or barcode that represents a specific item.
     * @return if the item has already been register it retruns true else it returns false. 
     */
    public boolean checkIfItemAlreadyRegister (String itemIdentifier){
        for( itemInItemList = 0; itemInItemList < itemList.size(); itemInItemList++) {
            if(itemIdentifier.equals(itemList.get(itemInItemList).getItemIdentifier())) {
                return true; 
            }
        }
    return false; 
    }
    
    /**
     * If an item is already been registered this method increases the quntity of the item. 
     * @param itemIdentifier A number or barcode that represents a specific item.
     */
    public ItemInformationDTO increaseQuantity (String itemIdentifier, int quantity){
        itemList.get(itemInItemList).quantity += quantity; 
        return itemList.get(itemInItemList); 
    }

    
    /**
     * This method calls for externelInventorySystem to get information about a specefic item.
     * and adds it to the sale but if an item already has been registered it just adds up the quantity. 
     * @param itemIdentifier: A code that represents an specific item. 
     * @param qiantity: the quantity of the item 
     * @return : retruns the information about the item. But if it is already registered it returns the information 
     *                with the updated quantity. 
    */
    public ItemInformationDTO additem(ItemInformationDTO item){
        itemCheck = checkIfItemAlreadyRegister(item.getItemIdentifier());
        if (itemCheck == false) {
             itemList.add(new ItemInformationDTO(item.getItemName(), item.getItemIdentifier(), item.getItemPrice(), item.getItemVATRate(), item.getItemQuantity())); 
             return item; 
        }
        else{
            ItemInformationDTO itemInfo = increaseQuantity(item.getItemIdentifier(), item.getItemQuantity());
            return itemInfo; 
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
        double runningTotal = 0; 
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
        notifyObservers();
        return totalAmout; 
    }

    /**
     * 
     */
    private void notifyObservers() {
        for (RevenueObserver obs: revenueObservers){
            obs.completedSale(totalAmout);
        }
    }

    /**
     * Adds a list of observers to the revenueObserves list.
     * @param observers - the list of observers to add.
     */
    public void addRevenueObservers(List<RevenueObserver> observers) {
        revenueObservers.addAll(observers);
    }

}

