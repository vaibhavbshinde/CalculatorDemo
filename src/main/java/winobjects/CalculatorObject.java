package winobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.Reporter;
import utils.DriverConnection;

import java.io.IOException;
import java.net.MalformedURLException;


/**
 * @author : VaibhavS
 * @desc : Perform the Addition, Mutltiplication, division, subtract operation
 */
public class CalculatorObject {

    public static DriverConnection drvconn = new DriverConnection();
    public static WiniumDriver winDrvConn = null;

    /**
     * element Id's of Number, Operators etc.
     */
    By one = By.name("1");
    By two = By.name("2");
    By three = By.name("3");
    By four = By.name("4");
    By five = By.id("135");
    By six = By.name("6");
    By seven = By.id("137");
    By eight = By.name("8");
    By nine = By.name("9");
    By zero = By.name("0");
    By dot = By.id("84");

    //Add, subtract, multiply, division
    By add = By.id("93");
    By subtract = By.name("Subtract");
    By multiply = By.name("Multiply");
    By division = By.name("Divide");
    By equals = By.id("121");
    By clear = By.id("82");
    By memclear = By.id("122");
    By sqrroot = By.id("110");


    /**
     * Method : to connect the winium driver and read the configuration properties
     */
    public void connectDriver() {
        try {
            winDrvConn = drvconn.loadWindowApp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method : To press the Number button from the calculator
     */
    public void pressNumberButton(String recNumber) {
        for (int i = 0; i < recNumber.length(); i++) {
            String substr = recNumber.substring(i,i+1);
          /*  try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            switch (substr) {
                case "0":
                    winDrvConn.findElement(zero).click();
                    break;
                case "1":
                    winDrvConn.findElement(one).click();
                    break;
                case "2":
                    winDrvConn.findElement(two).click();
                    break;
                case "3":
                    winDrvConn.findElement(three).click();
                    break;
                case "4":
/*                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    winDrvConn.findElement(four).click();
                    break;
                case "5":
                    winDrvConn.findElement(five).click();
                    break;
                case "6":
                    winDrvConn.findElement(six).click();
                    break;
                case "7":
                    winDrvConn.findElement(seven).click();
                    break;
                case "8":
                    winDrvConn.findElement(eight).click();
                    break;
                case "9":
                    winDrvConn.findElement(nine).click();
                    break;
                case ".":
                    winDrvConn.findElement(dot).click();
                    break;
                case "-":
                    winDrvConn.findElement(subtract).click();
                    break;
                case "+":
                    winDrvConn.findElement(add).click();
                    break;
                case "/":
                    winDrvConn.findElement(multiply).click();
                    break;
                case "*":
                    winDrvConn.findElement(division).click();
                    break;
            }
        }

    }

    /**
     * Method : Addition of numbers
     */
    public String addition(String num1, String num2) {
        String msgStr = "";
        double validNum1, validNum2;

        //clear the result
        winDrvConn.findElement(clear).click();

        try {
            validNum1 = Double.parseDouble(num1);

            // calling pressNumber
            pressNumberButton(num1);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            msgStr = msgStr + num1 + "is not number So considered the default value as Zero. ";
            validNum1 = 0;
            winDrvConn.findElement(zero).click();

            //Reporter Log added
            Reporter.log( num1 + "is not number so considered the default value as Zero. ");

        }

        // Press Add button
        winDrvConn.findElement(add).click();

        try {
            validNum2 = Double.parseDouble(num2);

            // calling pressNumber
            pressNumberButton(num2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            msgStr = msgStr + " AND " + num2 + "is not number so considered the default value as Zero";
            validNum2 = 0;

            //Reporter Log added
            Reporter.log( num2 + "is not number so considered the default value as Zero. ");

        }

        //pressing Equals buttons
        winDrvConn.findElement(equals).click();
        String result = winDrvConn.findElement(By.id("150")).getAttribute("Name");
        System.out.println("Addition of "+num1+" and "+ num2+ " result is :" + result);
        System.out.println("msgStr :" + msgStr);

        Reporter.log("-------------------------------------");
        Reporter.log( "Addition of "+num1+" and "+ num2+ " result is :" + result);
        Reporter.log("-------------------------------------");

        return result;
    }

    /**
     * Method : Subtraction of numbers
     */
    public String subtraction(String num1, String num2) {
        String msgStr = "";
        double validNum1, validNum2;

        //clear the result
        winDrvConn.findElement(clear).click();

        try {
            validNum1 = Double.parseDouble(num1);

            // calling pressNumber
            pressNumberButton(num1);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            msgStr = msgStr + num1 + "is not number so considered the default value as Zero. ";
            validNum1 = 0;
            winDrvConn.findElement(zero).click();

            //Reporter Log added
            Reporter.log( num1 + "is not number so considered the default value as Zero. ");

        }

        // Press Add button
        winDrvConn.findElement(subtract).click();

        try {
            validNum2 = Double.parseDouble(num2);

            // calling pressNumber
            pressNumberButton(num2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            msgStr = msgStr + " AND " + num2 + "is not number so considered the default value as Zero";
            validNum2 = 0;

            //Reporter Log added
            Reporter.log( num2 + "is not number so considered the default value as Zero. ");

        }

        //pressing Equals buttons
        winDrvConn.findElement(equals).click();
        String result = winDrvConn.findElement(By.id("150")).getAttribute("Name");
        System.out.println("Subtraction of "+num1+" and "+ num2+ " result is :" + result);
        System.out.println("msgStr :" + msgStr);

        Reporter.log("-------------------------------------");
        Reporter.log( "Subtraction of "+num1+" and "+ num2+ " result is :" + result);
        Reporter.log("-------------------------------------");

        return result;
    }

    /**
     * Method : Division of numbers
     */
    public String division(String num1, String num2) {
        String msgStr = "";
        double validNum1, validNum2;

        //clear the result
        winDrvConn.findElement(clear).click();

        try {
            validNum1 = Double.parseDouble(num1);

            // calling pressNumber
            pressNumberButton(num1);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            msgStr = msgStr + num1 + "is not number so considered the default value as Zero. ";
            validNum1 = 0;
            winDrvConn.findElement(zero).click();

            //Reporter Log added
            Reporter.log( num1 + "is not number so considered the default value as Zero. ");

        }

        // Press Add button
        winDrvConn.findElement(division).click();

        try {
            validNum2 = Double.parseDouble(num2);

            // calling pressNumber
            pressNumberButton(num2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            msgStr = msgStr + " AND " + num2 + "Is not number so consider the default value as Zero";
            validNum2 = 0;

            //Reporter Log added
            Reporter.log( num2 + "is not number so considered the default value as Zero. ");

        }

        //pressing Equals buttons
        winDrvConn.findElement(equals).click();
        String result = winDrvConn.findElement(By.id("150")).getAttribute("Name");
        System.out.println("Division of "+num1+" and "+ num2+ " result is :" + result);
        System.out.println("msgStr :" + msgStr);

        Reporter.log("-------------------------------------");
        Reporter.log( "Division of "+num1+" and "+ num2+ " result is :" + result);
        Reporter.log("-------------------------------------");

        return result;
    }

    /**
     * Method : Mulitiply of numbers
     */
    public String multiply(String num1, String num2) {
        String msgStr = "";
        double validNum1, validNum2;

        //clear the result
        winDrvConn.findElement(clear).click();

        try {
            validNum1 = Double.parseDouble(num1);

            // calling pressNumber
            pressNumberButton(num1);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            msgStr = msgStr + num1 + "Is not number so consider the default value as Zero. ";
            validNum1 = 0;
            winDrvConn.findElement(zero).click();

            //Reporter Log added
            Reporter.log( num1 + "is not number so considered the default value as Zero. ");

        }

        // Press Add button
        winDrvConn.findElement(multiply).click();

        try {
            validNum2 = Double.parseDouble(num2);

            // calling pressNumber
            pressNumberButton(num2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            msgStr = msgStr + " AND " + num2 + "Is not number so consider the default value as Zero";
            validNum2 = 0;

            //Reporter Log added
            Reporter.log( num2 + "is not number so considered the default value as Zero. ");

        }

        //pressing Equals buttons
        winDrvConn.findElement(equals).click();
        String result = winDrvConn.findElement(By.id("150")).getAttribute("Name");
        System.out.println("Multiplication of "+num1+" and "+ num2+ " result is :" + result);
        System.out.println("msgStr :" + msgStr);

        Reporter.log("-------------------------------------");
        Reporter.log( "Division of "+num1+" and "+ num2+ " result is :" + result);
        Reporter.log("-------------------------------------");

        return result;
    }

    /**
     * Method : sqroot of numbers
     */
    public String sqrroot(String num1) throws InterruptedException {
        String msgStr = "";
        double validNum1;

        //clear the result
        winDrvConn.findElement(clear).click();

        try {
            validNum1 = Double.parseDouble(num1);

            // calling pressNumber
            pressNumberButton(num1);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            msgStr = msgStr + num1 + "Is not number so consider the default value as Zero. ";
            validNum1 = 0;
            winDrvConn.findElement(zero).click();

            //Reporter Log added
            Reporter.log( num1 + "is not number so considered the default value as Zero. ");

        }

        // Press square root button button
        winDrvConn.findElement(sqrroot).click();
        Thread.sleep(1000);
        winDrvConn.findElement(sqrroot).click();
        Thread.sleep(1000);
        winDrvConn.findElement(sqrroot).click();
        Thread.sleep(1000);

        String result1 = winDrvConn.findElement(By.id("150")).getAttribute("Name");
        System.out.println("OOOO  sqr(sqr(sqr("+num1+"))) of result is :" + result1);
        Reporter.log("-------------------------------------");
        Reporter.log( "sqr(sqr(sqr("+num1+"))) of result is :" + result1);
        Reporter.log("-------------------------------------");

        //pressing Equals buttons
        winDrvConn.findElement(equals).click();
        String result = winDrvConn.findElement(By.id("150")).getAttribute("Name");
        System.out.println("sqr(sqr(sqr("+num1+"))) of result is :" + result);
        System.out.println("msgStr :" + msgStr);

/*
        Reporter.log("-------------------------------------");
        Reporter.log( "sqr(sqr(sqr("+num1+"))) of result is :" + result);
        Reporter.log("-------------------------------------");
*/

        return result;
    }


}
