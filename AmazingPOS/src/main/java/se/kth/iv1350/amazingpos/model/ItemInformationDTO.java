package se.kth.iv1350.amazingpos.model;

/**
 * This class is for storing the attributes of an item. 
 * @author Sushil
 */
public class ItemInformationDTO {
    private String itemName; 
    private String itemIdentifier; 
    private double itemPrice; 
    private double itemVATRate; 
    int quantity; 
    
    
    /**
     * Creates an instance of class ItemInformationDTO.
     * @param itemName. Name of the item.
     * @param itemIdentifier. The zipcode that represents the item.
     * @param itemPrice. The price of the item.
     * @param itemVATRate. The VAT rate of the item. 
     */
    public ItemInformationDTO(String itemName, String itemIdentifier, double itemPrice,
                              double itemVATRate, int quantity){
        this.itemName = itemName; 
        this.itemIdentifier = itemIdentifier; 
        this.itemPrice = itemPrice; 
        this.itemVATRate = itemVATRate; 
        this.quantity = quantity; 
    }
    
    /**
     * @return. Returns the name of the item.  
     */
    public String getItemName(){
        return this.itemName; 
    }
    
    /**
     * @return. Returns the itemIdentifier of the item.  
     */
    public String getItemIdentifier(){
        return this.itemIdentifier; 
    }

    /**
     * @return. Returns the price of the item.  
     */
    public double getItemPrice(){
        return this.itemPrice;
    } 
    
    /**
     * @return. Returns the VATRate of the item.  
     */
    public double getItemVATRate(){
        return this.itemVATRate;
    }
    
    /**
     * @return. Returns the quntity of the item.  
     */
    public double getItemQuantity(){
        return this.quantity;
    }
}
