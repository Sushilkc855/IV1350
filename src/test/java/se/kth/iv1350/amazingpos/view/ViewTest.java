package se.kth.iv1350.amazingpos.view;
/*
import java.io.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.amazingpos.controller.Controller;

public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printout; 
    private PrintStream originalSysOut; 
    
    @BeforeEach
    public void setUp() {
        Controller contr = new Controller(); 
        instanceToTest = new View(contr);
        
        printout = new ByteArrayOutputStream(); 
        PrintStream inMemSysOut = new PrintStream(printout); 
        originalSysOut = System.out; 
        System.setOut(inMemSysOut);
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        
        printout = null; 
        System.setOut(originalSysOut); 
    }

    @Test
    public void testRunFakeExecution() {
       instanceToTest.runFakeExecution();
       String POut = printout.toString(); 
       String expectedOutput = "started"; 
       assertTrue(POut.contains(expectedOutput), "UT did not start correctly"); 
    }
    
}
*/