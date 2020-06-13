package Reusable_Classes;

import Reusable_Classes.Reusable_Kayak_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;

public class Reusable_Kayak_Logger {

    static int timeout = 120;


    //----------------------------------------------------------------------------------------------------------
    //This 'Reusable_Kayak_Logger' is made from 'Reusable_For_Kayak' which is now locator problem in Date and Time
    //----------------------------------------------------------------------------------------------------------
    //Pls follow the 'Reusable_Library_Loggers' for loggers and 'Reusable' for only reuable if apply something in Kayak
    //--------------------------------------------------------------------------------------------------------------


    //method to re use chrome driver and chrome options
    public static WebDriver setDriver(){
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of setDriver method

    //method to click on an element
    public static void click(WebDriver driver, String locator, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value on element " + elementName);
            //Reporter.log("Clicking a value on element :" + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
            //Reporter.log("Unable to click element "+elementName+" "+e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //Method to get input at search box
    public static void userTypeAndHitEnter(WebDriver driver, String locator, String userInput, String elementName,ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);

        try{
            System.out.println(" Entering a value on element "+elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(2000);
            element.sendKeys(Keys.ENTER);
        }catch (Exception e){
            System.out.println("Unable to find the element "+elementName+" "+e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of Search Box for Airport exception
    }//end of searchBoxForAirport method

    //method to click by Index on an element
    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName,ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value on element " + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click by Index method

    //method to click by Index to send input on an element
    public static void clickByIndex_1(WebDriver driver,String locator,int index, String useriput, String elementName,ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value on element " + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
            element.clear();
            element.sendKeys(useriput);
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click by Index to sent input method


    //MouseClick Method
    public static void mouseClick (WebDriver driver, String locator,int index, String elementName,ExtentTest logger){
        Actions mouse = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Tne name of element is :"+elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement clickMouse = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            mouse.moveToElement(clickMouse).click().perform();
        }catch (Exception e){
            System.out.println("Unable to click the mouse click on element "+e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of click mouse exception

    }//end of mouse click method

    //MouseClick Method
    public static String captureText (WebDriver driver, String locator, String elementName,ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result =null;
        try{
            System.out.println("Tne name of element is :"+elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
           result = element.getText();
            System.out.println("My result is "+result);
        }catch (Exception e){
            System.out.println("Unable to click the mouse click on element "+e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of click mouse exception

        return result;
    }//end of mouse click method

        //method to capture screenshot when logger fails
        public static void getScreenShot(WebDriver driver, ExtentTest logger, String imageName){
            try {
                String fileName = imageName + ".png";
                String directory = "src//main//java//HTML_Report//Screenshots//";
                File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(sourceFile, new File(directory + fileName));
                //String imgPath = directory + fileName;
                String image = logger.addScreenCapture("Screenshots//" + fileName);
                logger.log(LogStatus.FAIL, "", image);
            } catch (Exception e) {
                logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
                e.printStackTrace();
            }//end of try catch

        }//end of get screen shot method







}//end of Java Class
