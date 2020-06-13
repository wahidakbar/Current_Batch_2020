package Action_Items;

import Reusable_Classes.Reusable_For_Kayak;
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

public class Action_Item_06 {

    //declaration of WebDriver
    WebDriver driver;
    //Declaring the ReadAble File
    Workbook readableFile;
    //Declaring the Readable Sheet
    Sheet readableSheet;
    //Declaring the Writable File
    WritableWorkbook writableFile;
    //Declaring the Writable Sheet
    WritableSheet writableSheet;


    @BeforeSuite
    public void callDriver() throws IOException, BiffException {
        driver= Reusable_For_Kayak.setDriver();
        //Define path for Readable File
        readableFile = Workbook.getWorkbook(new File("src//main//java//Excels//Excel_Kayak.xls"));
        //Define Readable sheet
        readableSheet=readableFile.getSheet(0);
        //Define Writable File
        writableFile = Workbook.createWorkbook(new File("src//main//java//Excels//Excel_Kayak_Result.xls"),readableFile);
        writableSheet = writableFile.getSheet(0);

    }//end of Call Driver Before Suite

    @Test
    public  void kayakTest() throws InterruptedException, WriteException, IOException {
        int rows = writableSheet.getRows();
        for (int i=1; i<rows; i++) {

            //Navigating to Kayak webSite
            driver.navigate().to("https://www.kayak.com");
            //Click on the search box
            Reusable_For_Kayak.click(driver, "//div[@data-placeholder='Enter an airport or city']", "Click on search Box");
            Thread.sleep(2000);

            String airPort = writableSheet.getCell(0,i).getContents();

            //calling Search Box for entering input
            Reusable_For_Kayak.userTypeAndHitEnter(driver, "//*[@name='pickup']", airPort, "Search Box for Airport");
            Thread.sleep(2000);


            String endDate = writableSheet.getCell(3,i).getContents();

            //Calling Click By Index Method
            Reusable_For_Kayak.clickByIndex(driver, "//*[@data-placeholder='Drop-off']", 0, "End Date Box");
            //calling Click by Index 01 method
            Reusable_For_Kayak.clickByIndex_1(driver, "//*[@aria-label='Drop-off date']", 1, endDate, "Entering End Date");
            Thread.sleep(2000);


            String endTime = writableSheet.getCell(4,i).getContents();
            //Reusable_For_Kayak.mouseClick(driver,"//*[contains(@id,'end-time-select-display') and @data-title='"+endTime+"']",1,"Entering end time");
            Reusable_For_Kayak.click(driver, "//*[contains(@id,'end-time-select-display')]", "Clicking End Time");
            Reusable_For_Kayak.mouseClick(driver, "//*[@data-title='"+endTime+"']", 1, "Entering end time");

            //Clicking outside
            Reusable_For_Kayak.click(driver,"//*[@class='title-section']","Clicking on outside");
            Thread.sleep(2000);

            String startDate = writableSheet.getCell(1,i).getContents();
            Reusable_For_Kayak.clickByIndex(driver, "//*[@data-placeholder='Pick-up']", 0, "Start Date Box");
            Reusable_For_Kayak.clickByIndex_1(driver, "//*[@aria-label='Pick-up date']", 1, startDate, "Entering Start Date");

            Thread.sleep(2000);
            //Clicking outside
            Reusable_For_Kayak.click(driver,"//*[@class='title-section']","Clicking on outside");
            Thread.sleep(2000);

            String startTime = writableSheet.getCell(2,i).getContents();
            //Reusable_For_Kayak.mouseClick(driver,"//*[contains(@id,'start-time-select-display') and @data-title='"+startTime+"']",0,"Entering Start Time");
            //Reusable_For_Kayak.click(driver,"//*[contains(@id,'start-time-select-display')]","Clicking Start Time");
            Reusable_For_Kayak.mouseClick(driver,"//*[@data-title='"+startTime+"']",0,"Entering Start time");

            Thread.sleep(6000);

            //Click on the search Button
            Reusable_For_Kayak.click(driver, "//*[@title='Search cars']", "Clicking on search button");

            Thread.sleep(8000);

            String vSize = writableSheet.getCell(5,i).getContents();
            //Click on vehicles size
            Reusable_For_Kayak.clickByIndex(driver, "//*[contains(@id,'topFilter') and contains(@id,'"+vSize+"')]",1, "Vehicles Size");

            Thread.sleep(8000);

            //Click on view deal
            Reusable_For_Kayak.clickByIndex(driver, "//*[text()='View Deal']", 1, "Click on view deal");

            Thread.sleep(2000);

            //Declaring and defining Array List for new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            Thread.sleep(3000);

            //Calling the array list to new tab
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(8000);

            String pageTitle = driver.getTitle();
            System.out.println("The name od Page Title is :"+pageTitle);

            if (pageTitle.equals("Car hire Laguardia International Airport in Laguardia Airport (LGA), USA - New York at discounted rates with Booking.com.")){
                String data = Reusable_For_Kayak.captureText(driver,"//div[@class='bui-panel   ']","capturing the text");
                Label label = new Label(6,i,data);
                writableSheet.addCell(label);
            }else {
                String data = Reusable_For_Kayak.captureText(driver, "//*[@class='Checkout-Common-Uicore-NormalText resetColor']", "Capturing the text");
                String data_2 = Reusable_For_Kayak.captureText(driver, "(//*[@class='summarySection'])[2]", "Capturing the text for Date & Time");
                Label label = new Label(6, i, data);
                writableSheet.addCell(label);

                Label label_2 = new Label(7, i, data_2);
                writableSheet.addCell(label_2);

            }


            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));

            driver.manage().deleteAllCookies();

        }//end of for loop

    }//end of Kayak test Method

    @AfterSuite
    public void closeAndQuit() throws InterruptedException, IOException, WriteException {
        Thread.sleep(1000);
        writableFile.write();
        writableFile.close();
        readableFile.close();

        Thread.sleep(3000);
        driver.quit();

    }//end of close After Suit





}//end of java class
