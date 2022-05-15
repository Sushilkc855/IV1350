package se.kth.iv1350.amazingpos.model;

/**
 * Contains the exat adress of the store.
 * @author Sushil
 */
public class StoreAddress {
    private final String streetName; 
    private final String cityAndCountry; 
    private final String zipcode; 
    
    /**
     * Fake adress for the sore.
     */
    public StoreAddress(){
        streetName = " Isafjordsgatan 22"; 
        cityAndCountry = "Kista, Sweden";
        zipcode = "164 40"; 
    }
    
    /**
     * Returns the streetName for the store. 
     */
    public String getStreetName(){
      return streetName; 
    }
    
    /**
     * Returns city and country that the store is located at. 
     */
    public String getCityAndCountry(){
      return cityAndCountry; 
    }
    
    /**
     * Riturns the zipcode for the store.
     */
    public String getZipCode(){
      return zipcode; 
    }
    
}
