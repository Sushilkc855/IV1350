package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.integration.ExternelInventorySystem;
/**
 *This is a placeholde for the real view. It contains a hardcoded execution with
 * calls to all system operation in the controller.
 * @author Sushil's pc
 */
import se.kth.iv1350.amazingpos.model.ItemInformationDTO;
public class View {
    private Controller contr; 
    /**
    * Creates a new instance, that uses the specified controller for att calls 
    * to other layes. 
    * @param contr The controller to use for all calls to
    */
    public View (Controller contr){
        this.contr = contr; 
    }
    
    /**
     * Performs a fake sale, by calling all system operations in the controller.
    */
    public void runFakeExecution(){
        contr.startSale();
        System.out.println("A new sale has been started.");

       // ItemInformationDTO itemInfo = new ItemInformationDTO("Apple", "AppleBarCode", 15, 0.13, 10);
       //ExternelInventorySystem inventoryInstance = new ExternelInventorySystem();
       // inventoryInstance.additem(itemInfo);
        
    

        System.out.println("Gets the information about the items whith the bara code that is in inventory system");
        ItemInformationDTO itemInformation = contr.getItemInfo("AppleBarCode"); 
        double itemPrice = itemInformation.getItemPrice(); 
        String barcode = itemInformation.getItemIdentifier(); 
        String itemName = itemInformation.getItemName(); 
        double getItemVATRate = itemInformation.getItemVATRate();  
        System.out.println("items barCode, " + barcode);
        System.out.println("item name, " + itemName);
        System.out.println("item price, " + itemPrice);
        System.out.println("item Vat Rate, " + getItemVATRate);


        boolean register = contr.itemAlreadyRegister("AppleBarCode");
        //false because it is not registered in sale yet. 
        System.out.println(register);

        
        System.out.println("The curren Running total for the sale, "+ contr.runningTotal());

        // The total amount for tha sale 
        System.out.println("The total amount for the sale, "+ contr.totalAmoutn());


        System.out.println("Returns how much change to give customer, " + contr.registerPayment(300.2));

    }

}
