package Action_Items;

import Reusable_Classes.Reusable;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Action_Items_Kayak {

    //when using annotation method your local driver
    //must be declared outside so i can call it
    //on all my annotation method
    WebDriver driver;
    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet wSheet;
    //initiate row count
    int row;

    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException, BiffException {
        //define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src//main//java//Excels//Excel_Kayak.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//java//Excels//Excel_Kayak_Somon_Result.xls"),readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(0);
        //get all visible row count
        row = wSheet.getRows();
        //defined the driver
        driver = Reusable.setDriver();
    }//end of BeforeSuite

    @Test
    public void kayakSearch() throws InterruptedException, WriteException {
        for(int i = 1; i < 2; i++) {
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(2000);
            //click on Search field
            Reusable.click(driver,"//*[contains(@id,'pickup-field')]","Search Filed");
            //enter keyword on search field
            String airports = wSheet.getCell(0,i).getContents();
            Reusable.userKeys(driver,"//*[@name='pickup']",airports,"Search Field");

            //click on car result item as first one
            Reusable.click(driver,"//*[@class='item-info']","Car Result");

            //click on drop off
            Reusable.click(driver,"//*[@data-placeholder='Drop-off']","Drop-off Date");
            Thread.sleep(5000);
            //enter pick up date
            String dropOffDate = wSheet.getCell(3,i).getContents();
            Reusable.userTypeAndHitEnter(driver,"//*[contains(@id,'dropoff-date-input')]",dropOffDate,"Drop-off Date");
            Thread.sleep(2000);
            //click somewhere outside
            Reusable.click(driver,"//*[@class='title dark']","Text Content");

            //click on drop off time
            Thread.sleep(1000);
            Reusable.click(driver,"//*[contains(@id,'end-time-select')]","Drop off Time");
            //choose drop off up time
            Thread.sleep(2000);
            String dropOffTime = wSheet.getCell(4,i).getContents();
            Reusable.mouseClick(driver,"//*[contains(@id,'end-time-select-option') and @data-title='"+dropOffTime+"']","Choose Drop-off Time");

            //click on pick up date
            Reusable.click(driver,"//*[@data-placeholder='Pick-up']","Pick-up Date");
            Thread.sleep(2000);
            //enter pick up date
            String pickupDate = wSheet.getCell(1,i).getContents();
            Reusable.userTypeAndHitEnter(driver,"//*[contains(@id,'pickup-date-input')]",pickupDate,"Pick-up Date");
            //click somewhere outside
            Reusable.click(driver,"//*[@class='title dark']","Text Content");

            //choose pick up time
            Thread.sleep(2000);
            String pickupTime = wSheet.getCell(2,i).getContents();
            Reusable.mouseClick(driver,"//*[contains(@id,'start-time-select-option') and @data-title='"+pickupTime+"']","Choose Drop-off Time");

            //click on search icon
            Reusable.click(driver,"//*[@title='Search cars']","Search Icon");
            Thread.sleep(4000);
            //click on vehicle size checkbox
            String vehicleSize = wSheet.getCell(5,i).getContents();
            Reusable.click(driver,"//div[text()='"+vehicleSize+"']","Vehicle Size Checkbox");

            //click on second View Deal button
            Thread.sleep(5000);
            Reusable.clickByIndex(driver,"//*[text()='View Deal']",1,"View Deal");

            ArrayList<String> list = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window(list.get(1));
            Thread.sleep(2000);
            String result = Reusable.captureText(driver,"//*[contains(@class,'bui-panel') or @class='search' or @class='booking-section' or @class='addressGrid']","Car Info");
            Label label = new Label(6,i,result);
            wSheet.addCell(label);
            driver.close();
            driver.switchTo().window(list.get(0));
            driver.manage().deleteAllCookies();
        }//end of for loop
    }//end of Kayak test

    @AfterSuite
    public void quitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();
    }//end of AfterSuite





}
