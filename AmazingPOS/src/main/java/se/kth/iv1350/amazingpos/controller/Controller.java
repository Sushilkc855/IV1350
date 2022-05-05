package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.model.*;
import se.kth.iv1350.amazingpos.integration.*; 

/**
 * This is the application only controller. All calls to the model pass through this class. 
 * @author sushi
 */
public class Controller {   
    private Sale sale; 
    private ExternelInventorySystem externelInventorySystem = new ExternelInventorySystem(); 
    private ExternelAccountingSystem externelAccountingSystem; 
    private DiscountDB discountDB; 
    private boolean itemCheck;
    private double change; 
    private Printer printer;
    private Receipt receipt; 
    CashPayment cashPayment = new CashPayment();
    /**
     * Start a new sale. This method must be called before doing anything else 
     * during a sale. 
    */
    public void startSale(){
        sale = new Sale(); 
    }
   
    /**
     * This methid calls for checkIfItemAlreadyRegister metod to see if a item already has been registered.
     * @param itemIdentifier A number or barcode that represents a specific item.
     * @return if the item has already been register it retruns true else it returns false.
     */
    public boolean itemAlreadyRegister(String itemIdentifier){
        Sale registetionInfo = new Sale(); 
        itemCheck =  registetionInfo.checkIfItemAlreadyRegister(itemIdentifier);
        return itemCheck; 
    }
    
    /**
     * This method calls for externelInventorySystem to get information about a specefic item. 
     * @param itemIdentifier. A number or barcode that represents a specific item.
     * @return Returns the information about the item and it is not in iventory it retuns null.   
     */
    public ItemInformationDTO getItemInfo (String itemIdentifier){
        ItemInformationDTO itemInfo = externelInventorySystem.getItemInfomation(itemIdentifier); 
        itemCheck = itemAlreadyRegister(itemIdentifier);
        sale.additem(itemInfo, itemCheck);
        return itemInfo; 
    }

    /**
     * gets the current sale running total
     * @return the currents sale running total. 
     */
    public double runningTotal (){
        double runningTotal = sale.countRunningTotal();
        return runningTotal;
    }
    /**
     * @return This method returns the Totalamount of the entire sale. 
     */
    public double totalAmoutn(){
        return sale.getTotalAmount(); 
    }

    /**
     * @param amountPayed This is the amount payed by the customer.
     * @return this method gets the chage that is needed to give to the customer. 
     */
    public double registerPayment (double amoutPayedByCustomer){ 
        change = cashPayment.changeToGiveCustomer(sale, amoutPayedByCustomer);
        return change; 
    }

    /**
     * Ends the sale process.
     * 
     */
    public void endSale(){
    }

     /**
     * updates the externel inventory system. 
     * @param sale Has the information about the curren. 
     */
    public void updateInventorySystem(Sale sale){
        externelInventorySystem.updateInventory(sale);
    }

    /**
     * updates the externel accounting system. 
     * @param sale Has the information about the curren. 
     */
    public void updateAccountingSystem(Sale sale){
        externelAccountingSystem.updateAccountingSystem(sale);
    }
   

    public Receipt getReceipt(Sale sale, StoreAddress storeAddress, CashPayment cashPayment){
        return receipt; 
    }

    /**
     * This method prints out the receipt. 
     */
    public void printReceipt(){
        printer.printReceipt(receipt);
    }
}
