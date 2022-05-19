package se.kth.iv1350.amazingpos.integration;
/**
 * This exeption is thrown to indicate that the database can not be called, it might be
* for example that the database server is simply not running
 */
public class DatabaseServerNotRunning extends Exception {
    public DatabaseServerNotRunning(String errorMessage){
        super(errorMessage);
    }
}
