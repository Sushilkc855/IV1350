package se.kth.iv1350.amazingpos.startup;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.view.View; 
/**
 *Contains the main method to start the application. 
 */
public class Main {
    /**
     *  The main method used to start the entire application.
     * @param args The application does not take any comand line parameters. 
    */
    public static void main(String[] args){
        Controller contr = new Controller(); 
        new View(contr).runFakeExecution(); 
    }
}
