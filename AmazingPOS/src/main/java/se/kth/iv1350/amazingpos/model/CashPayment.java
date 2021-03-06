package se.kth.iv1350.amazingpos.model;

public class CashPayment {
    private Sale sale; 
    private double payedAmount; 
    private double changeForCustomer; 

    /**
     * Creates a new instance of class CashPayment
     */
    public CashPayment(){
    }

    /**
     * This method counts how much change to give to customer.
     * @param sale Contains the information about the sale.
     * @param payedAmount  the amount that is payed by the customer
     */
    public double changeToGiveCustomer(Sale sale, double payedAmount){
        this.payedAmount = payedAmount;
        changeForCustomer =  payedAmount - sale.getTotalAmount(); 
        return changeForCustomer; 
    }

    public double getPayedAmount(){
        return this.payedAmount;
    }

}
