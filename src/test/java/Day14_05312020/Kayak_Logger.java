package Day14_05312020;

import Reusable_Classes.Reusable_For_Kayak;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_Logger {

    //declaration of WebDriver
    WebDriver driver;
    //Declaring the ReadAble File
    Workbook readableFile;
    //Declaring the Readable Sheet
    Sheet readableSheet;
    //Declaring the Writable File
    WritableWorkbook writableFile;
    //Declaring the Writable Sheet
    WritableSheet wSheet;
    //defining the report variable outside
    ExtentReports reports;

    //defining the logger(extent test)
    ExtentTest logger;


    @BeforeSuite
    public void callDriver() throws IOException, BiffException, InterruptedException {
        driver= Reusable_For_Kayak.setDriver();
        //Define path for Readable File
        readableFile = Workbook.getWorkbook(new File("src//main//java//Excels//Excel_Kayak.xls"));
        //Define Readable sheet
        readableSheet=readableFile.getSheet(0);
        //Define Writable File
        writableFile = Workbook.createWorkbook(new File("src//main//java//Excels//Excel_Kayak_Result.xls"),readableFile);
        wSheet = writableFile.getSheet(0);

        Thread.sleep(3000);
        //define the report path here as a before suite
        reports = new ExtentReports("src//main//java//HTML_Report//Kayak_Report.html", true);

    }//end of Call Driver Before Suite

    @Test
    public  void kayakTest() throws InterruptedException, WriteException, IOException {
        int rows = wSheet.getRows();
        //define and start the test


        for (int i=1; i<rows; i++) {
                        //navigating to kayak

                        logger = reports.startTest("Kayak Search Verification");
                        driver.navigate().to("https://www.kayak.com");
                        Thread.sleep(2000);

                        //click on Search field
                        Reusable_Library_Loggers.click(driver, "//*[contains(@id,'pickup-field')]", "Search Filed", logger);
                        //enter keyword on search field
                        String airports = wSheet.getCell(0, i).getContents();
                        Reusable_Library_Loggers.userKeys(driver, "//*[@name='pickup']", airports, "Search Field", logger);

                        //click on car result item as first one
                        Reusable_Library_Loggers.click(driver, "//*[@class='item-info']", "Clicking outside", logger);

                        //click on drop off
                        Reusable_Library_Loggers.click(driver, "//*[@data-placeholder='Drop-off']", "Drop-off Date", logger);
                        Thread.sleep(2000);


                        //enter pick up date
                        String dropOffDate = wSheet.getCell(3, i).getContents();
                        Reusable_Library_Loggers.userTypeAndHitEnter(driver, "//*[contains(@id,'dropoff-date-input')]", dropOffDate, "Drop-off Date", logger);
                        Thread.sleep(2000);
                        //click somewhere outside
                        Reusable_Library_Loggers.click(driver, "//*[@class='title dark']", "Text Content", logger);

                        //click on drop off time
                        Thread.sleep(1000);
                        Reusable_Library_Loggers.click(driver, "//*[contains(@id,'end-time-select')]", "Drop off Time", logger);

                        //choose drop off up time
                        Thread.sleep(2000);


                        String dropOffTime = wSheet.getCell(4, i).getContents();
                        Reusable_Library_Loggers.mouseClick(driver, "//*[contains(@id,'end-time-select-option') and @data-title='" + dropOffTime + "']", "Choose Drop-off Time", logger);

                        //click on pick up date
                        Reusable_Library_Loggers.click(driver, "//*[@data-placeholder='Pick-up']", "Pick-up Date", logger);
                        Thread.sleep(2000);
                        //enter pick up date
                        String pickupDate = wSheet.getCell(1, i).getContents();
                        Reusable_Library_Loggers.userTypeAndHitEnter(driver, "//*[contains(@id,'pickup-date-input')]", pickupDate, "Pick-up Date", logger);
                        //click somewhere outside
                        Reusable_Library_Loggers.click(driver, "//*[@class='title dark']", "Text Content", logger);

                        //choose pick up time
                        Thread.sleep(2000);
                        String pickupTime = wSheet.getCell(2, i).getContents();
                        Reusable_Library_Loggers.mouseClick(driver, "//*[contains(@id,'start-time-select-option') and @data-title='" + pickupTime + "']", "Choose Drop-off Time", logger);

                        //click on search icon
                        Reusable_Library_Loggers.click(driver, "//*[@title='Search cars']", "Search Icon", logger);
                        Thread.sleep(8000);
                        //click on vehicle size checkbox
                        String vehicleSize = wSheet.getCell(5, i).getContents();
                        //Reusable_Library_Loggers.click(driver, "//div[contains(@id,'cars-topFilter-'"+vehicleSize+"')]", "Vehicle Size Checkbox", logger);
                        Reusable_Library_Loggers.click(driver, "//div[@id='cars-topFilter-"+vehicleSize+"-checkbox_icon']", "Vehicle Size Checkbox", logger);

                        //click on second View Deal button
                        Thread.sleep(8000);
                        Reusable_Library_Loggers.clickByIndex(driver, "//*[text()='View Deal']", 1, "View Deal", logger);

                        ArrayList<String> list = new ArrayList(driver.getWindowHandles());
                        driver.switchTo().window(list.get(1));
                        Thread.sleep(2000);
                        String result = Reusable_Library_Loggers.captureText(driver, "//*[contains(@class,'bui-panel') or @class='search' or @class='booking-section' or @class='addressGrid']", "Car Info", logger);
                        Label label = new Label(6, i, result);
                        wSheet.addCell(label);
                        driver.close();
                        driver.switchTo().window(list.get(0));
                        driver.manage().deleteAllCookies();
                    }//end of for loop


                }//end of Kayak test


    @AfterSuite
    public void closeAndQuit() throws InterruptedException, IOException, WriteException {
        Thread.sleep(1000);
writableFile.write();
writableFile.close();
readableFile.close();


        //flushing = writing the log(logger) back to your automation report that you define
        reports.flush();

        Thread.sleep(3000);
        driver.quit();

    }//end of close After Suit





}//end of java class
