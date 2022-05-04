package se.kth.iv1350.amazingpos.model;

import java.util.ArrayList;
/**
 * Represens one receit, which proves the payment of one sale
 * @author Sushil's pc
 */
public class Receipt {
    private ArrayList<ItemInformationDTO> listOfItems; 
    private ArrayList<Integer> itemQuantity;
    private Sale sale; 
    private String saleTime; 
    private StoreAddress storeAdress; 
    private double totalPrice;
    private double totalVAT;
    private double paidAmount;
    private double change;


    

}
