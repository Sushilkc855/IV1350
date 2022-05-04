package se.kth.iv1350.amazingpos.model;

public class CashPayment {
    private Sale sale; 
    private double payedAmount; 
    private double changeForCustomer; 

    /**
     * Creates a new instance of class CashPayment
     *
     * @param sale Contains the information about the sale. 
     * @param payedAmount the amount that is payed by the customer
     */
    public CashPayment(Sale sale, double payedAmount){
        this.payedAmount = payedAmount;
        this.sale = sale; 
    }

    /**
     * This method counts how much change to give to customer.
     * @param payedAmount  the amount that is payed by the customer
     */
    public double changeToGiveCustomer(double payedAmount){
        changeForCustomer =  payedAmount - sale.getTotalAmount(); 
        return changeForCustomer; 
    }

}
