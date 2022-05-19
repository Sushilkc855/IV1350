package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.model.*;
import se.kth.iv1350.amazingpos.util.*;
import se.kth.iv1350.amazingpos.view.TotalRevenueView;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.amazingpos.integration.*;
/**
 * This is the application only controller. All calls to the model pass through this class. 
 * @author sushi
 */
public class Controller {   
    private Sale sale; 
    private ExternelInventorySystem externelInventorySystem = new ExternelInventorySystem(); 
    private ExternelAccountingSystem externelAccountingSystem;
    private double change; 
    private Printer printer;
    private Receipt receipt; 
    private StoreAddress storeAddress; 
    CashPayment cashPayment = new CashPayment();
    private LogWriter log; 
    private List<RevenueObserver> revenueObservers = new ArrayList<RevenueObserver>();
    

    /**
     * Start a new sale. This method must be called before doing anything else 
     * during a sale. 
    */
    public void startSale(){
        sale = new Sale(); 
        sale.addRevenueObservers(revenueObservers);
    }
   
    
    /**
     * ScanItems. Adds a scanned item to the current sale. 
     * @param itemIdentifier. A number or barcode that represents a specific item.
     * @return Returns the information about the item and it is not in iventory it retuns null.  
     * @throws ItemNotFoundException - If an item with the itemidentifier is not found in externellinventorysystem.
     * @throws databaseServerNotRunning -  throws database failure exception when a search is made for a particular, hardcoded,item identifier.
     */
    public ItemInformationDTO scanItem (String itemIdentifier, int quantity) throws ItemNotFoundInInventoryException, DatabaseServerNotRunning{
        ItemInformationDTO itemInfo;
        try{
            itemInfo = externelInventorySystem.getItemInfomation(itemIdentifier, quantity); 
            }
        catch (ItemNotFoundInInventoryException exception){
            throw exception; 
            }
        catch (DatabaseServerNotRunning exception){
            log.log(exception);
            throw exception; 
            }

        sale.additem(itemInfo);
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
    public double totalAmount(){
        double totalAmount = sale.getTotalAmount();
        return totalAmount; 
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
     * @param sale Has the information about the current sale. 
     */
    public void updateAccountingSystem(Sale sale){
        externelAccountingSystem.updateAccountingSystem(sale);
    }
   

    /**
     * this methods is used for getting the nessery information in receipt. 
     * @param sale  Has the information about the current sale
     * @param storeAddress Address of the store
     * @param cashPayment Information about the change and payment. 
     * @return
     */
    public Receipt getReceipt(Sale sale, StoreAddress storeAddress, CashPayment cashPayment){
         return new Receipt(sale, storeAddress, cashPayment); 
    }

    
    /**
     * This method prints out the receipt. 
     */
    public void printReceipt(){
        receipt = getReceipt(sale, storeAddress, cashPayment); 
        printer.printReceipt(receipt);
    }

    /**
     * Adds observers to a list.
     * @param RevenueObserver - a total revenue observer.
     */
    public void addRevenueObserver(RevenueObserver totalRevenueView) {
        revenueObservers.add(totalRevenueView);
    }

    
}
