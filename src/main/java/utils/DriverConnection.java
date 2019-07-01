package utils;

import configuration.ReadConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;


import org.openqa.selenium.winium.WiniumDriverService;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author : VaibhavS
 * @desc : Read the property file and used the property for driver creation and connection
 */
public class DriverConnection {

    public static WiniumDriver driver = null;

    public WiniumDriver loadWindowApp() throws IOException, InterruptedException {
        ReadConfiguration dtls = null;
        try {
            dtls = new ReadConfiguration();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //When Everytime you run the test case it will check driver port assigned .. if yes then first it will delete
        Process process = Runtime.getRuntime().exec("taskkill /F /IM Winium.Desktop.Driver.exe");
        process.waitFor();
        process.destroy();

        DesktopOptions option = new DesktopOptions();

        //setting the windows calculator application path
        option.setApplicationPath(dtls.getKey("applicationpath")); //applicationpath=C:\\Windows\\System32\\calc.exe

        //set the DebugConnectToRunningApp(false)
        option.setDebugConnectToRunningApp(false);

        //setting launchDelay 2 seconds
        option.setLaunchDelay(2);

        // Here tried instead of run the winimum.driver.exe manually running automatically
        File drivePath = new File(dtls.getKey("winiumDriverPath")); //Set winium driver path
        WiniumDriverService service = new WiniumDriverService.Builder()
                                          .usingDriverExecutable(drivePath)
                                          .usingPort(9999)
                                          .withVerbose(false) //by making true it will start showing the log on command prompt
                                          .withSilent(false)
                                          .buildDesktopService();
        try {
            service.start(); //Build and Start a Winium Driver service
        } catch (IOException e) {
            e.printStackTrace();
        }
        //windriverurl = http://localhost:9999
        driver = new WiniumDriver(service, option); //Start a winium driver

        //windriverurl = http://localhost:9999
//        driver =  new WiniumDriver(new URL(dtls.getKey("windriverurl")),option);

        // Changing the Standard calculator to Scientific Calculator
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement window =  driver.findElementByClassName("CalcFrame");
        WebElement menuItem = window.findElement(By.id("MenuBar")).findElement(By.name("View"));
        menuItem.click();
        driver.findElementByName("Scientific").click();

        return driver;
    }

    public static void main(String[] args) throws MalformedURLException,IOException, InterruptedException{
        DriverConnection a = new DriverConnection();
        a.loadWindowApp();
    }
}
