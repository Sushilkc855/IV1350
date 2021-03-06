package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.model.RevenueObserver;

public class TotalRevenueView implements RevenueObserver{

    private double totalRevenue;
    
    /**
     * Creates a new TotalRevenueView
     */
    public TotalRevenueView() {
        totalRevenue = 0;
    }
     /**
     * invoked when a sale is complited
     * @param totalPrice the total abount to be paid for purchases
     */
    @Override
    public void completedSale(double totalPrice){
        totalRevenue = totalRevenue + totalPrice; 
        printRevenue();
    }

    private void printRevenue() {
        System.out.println("Total Revenue generated by sale " + totalRevenue);
    }
}
