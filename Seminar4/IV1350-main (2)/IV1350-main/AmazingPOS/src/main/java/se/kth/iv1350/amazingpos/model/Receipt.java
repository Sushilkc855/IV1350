package se.kth.iv1350.amazingpos.model;

import java.time.LocalTime;
import java.util.ArrayList;
/**
 * Represens one receit, which proves the payment of one sale
 * @author Sushil's pc
 */
public class Receipt {
    private ArrayList<ItemInformationDTO> listOfItems; 
    private Sale                          sale; 
    private CashPayment                   cashPayment;
    private LocalTime                     saleTime; 
    private StoreAddress                  storeAddress; 
    private double                        totalPrice;
    private double                        totalVAT;
    private double                        paidAmount;
    private double                        change;

    public Receipt(){

    }

    /**
     * Creates a receipt, containing the necessary information about the sale
     * @param sale All the sale information about items are in sale. 
     * @param storeAddres The adress of the store. 
     * @param cashPayment Has the infomation about the payment ditaing and the cashe to give to customer.
     */
    
    public Receipt (Sale sale, StoreAddress storeAddress, CashPayment cashPayment){
        this.sale = sale; 
        this.storeAddress = storeAddress; 
        this.cashPayment = cashPayment;
        this.change = cashPayment.changeToGiveCustomer(sale.getTotalAmount(), paidAmount); 
        this.saleTime = sale.saleTime; 
        this.totalPrice = sale.getTotalAmount(); 
        this.listOfItems = sale.getListOfItems(); 
    }
    
    public StoreAddress getStoreAddress(){
        return storeAddress; 
    }

    public double getChange(){
        return change;
    }

    public LocalTime getTimeOfSake(){
        return saleTime; 
    } 

    public double getTotalAmount(){
        return totalPrice; 
    }

    public  ArrayList<ItemInformationDTO> getItemList(){
        return listOfItems; 
    }

    public double getTotalVatRate(){
        return totalVAT; 
    }

}
