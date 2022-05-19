package se.kth.iv1350.amazingpos.model;

/**
 * A listner interface for receiving the total amount to be paid for purchases
 */

public interface RevenueObserver {
    /**
     * invoked when a sale is complited
     * @param totalPrice the total abount to be paid for purchases
     */
    void completedSale(double totalPrice); 
}
