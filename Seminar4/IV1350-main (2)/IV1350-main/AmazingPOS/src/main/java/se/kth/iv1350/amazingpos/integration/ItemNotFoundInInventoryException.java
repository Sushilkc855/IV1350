package se.kth.iv1350.amazingpos.integration;
/**
 * This exeption is thrown if an item with a specefic itemidentifier is not found in inventory.
 */
public class ItemNotFoundInInventoryException extends Exception {
    public ItemNotFoundInInventoryException(String errorMessage){
        super(errorMessage);
    }
}
