package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import winobjects.CalculatorObject;

/**
 * @author : VaibhavS
 * @desc : Perform the Addition, Mutltiplication, division, subtract operation
 */
public class TestCase {

    @BeforeClass
    public void call_driverConnection() {
        new CalculatorObject().connectDriver();
    }

    @Parameters({"calcNum1","calcNum2"})
    @Test(enabled = true, priority = 0)
    public void verify_ValidNumber_Addition(String calcNum1,String calcNum2) {
        String result = new CalculatorObject().addition(calcNum1,calcNum2);
        //String result = new CalculatorObject().addition("-125.15", "273");
        //  System.out.println("Result of Addition of :"+  result);

    }

    @Parameters({"calcNum1","calcNum2"})
    @Test(enabled = false, priority = 1)
    public void verify_invalidNumber_Addition(String calcNum1,String calcNum2) {
        // As both are invalid numbers so , addition will zero and will show reason
        String result = new CalculatorObject().addition("", "-273.123.123");

        // As both are invalid numbers so , addition will zero and will show reason
        // String result = new CalculatorObject().addition("*","12@");

        // This will convert the negative number to positive number and will do additions
        //String result = new CalculatorObject().addition("-123","-273.123");


        //  System.out.println("Result of Addition of :"+  result);
    }

    @Parameters({"calcNum1","calcNum2"})
    @Test(enabled = true, priority = 2)
    public void verify_ValidNumber_Subtraction(String calcNum1,String calcNum2) {
        String result = new CalculatorObject().subtraction(calcNum1,calcNum2);
        //  System.out.println("Result of Addition of :"+  result);

    }

    @Parameters({"calcNum1","calcNum2"})
    @Test(enabled = true, priority = 3)
    public void verify_ValidNumber_Multiplication(String calcNum1,String calcNum2) {
        String result = new CalculatorObject().multiply(calcNum1,calcNum2);
        //  System.out.println("Result of Addition of :"+  result);

    }

    @Parameters({"calcNum1","calcNum2"})
    @Test(enabled = true, priority = 4)
    public void verify_ValidNumber_Division(String calcNum1,String calcNum2) {
        String result = new CalculatorObject().division(calcNum1,calcNum2);
        //  System.out.println("Result of Addition of :"+  result);

    }

    @Parameters({"calcNum1"})
    @Test(enabled = true, priority = 5)
    public void verify_ValidNumber_SquareRoot(String calcNum1) throws InterruptedException {
        String result = new CalculatorObject().sqrroot(calcNum1);
        //  System.out.println("Result of Addition of :"+  result);
    }


    @AfterClass
    public void call_driverclose() {
        CalculatorObject.winDrvConn.quit();
    }
}
