package se.kth.iv1350.amazingpos.util;
/**
 * Prints an message to the log when an exception is caught. 
 * This printOut is intended for the log
 */
public class LogWriter {
    public void log(Exception exception){
        System.out.println("LOG ENTRY | " + exception.getMessage()
        + " | "
        + java.time.LocalDateTime.now()
        + "\nEND LOG\n--------\n");     
    }
}
