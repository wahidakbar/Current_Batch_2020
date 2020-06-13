package Action_Items;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Abstract_Class_ActionItms_7;
import Reusable_Classes.Reusable_Library;
import Reusable_Classes.Reusable_Library_ActionItms_7;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Excel_Google_Search_7 extends Abstract_Class_ActionItms_7 {

    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet wSheet;
    //initiate row count
    int rows;

    @Test
    public void Google_Search_7() throws InterruptedException, IOException, BiffException, WriteException {

        //locate the readable file path
        readableFile = Workbook.getWorkbook(new File("src//main//java//Excels//Google_Search.xls"));

        //locate the readable worksheet by index
        readableSheet = readableFile.getSheet(0); //I can also use 'sheet1' instead on index '0'

        //we need create a writable workbook to mimic readable file because we should not be on writing on readable files
        writableFile = Workbook.createWorkbook(new File("src//main//java//Excels//Google_Search_Result.xls"),readableFile);
        //create writable sheet
        wSheet = writableFile.getSheet(0);
        //get the total rows that are not empty
        rows = wSheet.getRows();

        //Define the webdriver using reusable library
        WebDriver driver = Reusable_Library_ActionItms_7.setDriver();

        //define the for loop
        for (int i = 1; i<rows; i++){

            //store the car column value as a string variable
            String cars = wSheet.getCell(0,i).getContents();

            logger.log(LogStatus.INFO, "Navigate to Google home page");
            //Navigate to google.com
            driver.navigate().to("https://www.google.com");

            //timeout
            Thread.sleep(2000);

            //reusable library to enter car value on google search
            Reusable_Library.userKeys(driver,"//*[@name='q']",cars,"Search Fields");

            //reusable library to click on google search
            Reusable_Library_ActionItms_7.submit(driver,"//*[@name='btnK']","Google Search",logger);

            //timeout
            Thread.sleep(2000);

            String result = Reusable_Library_ActionItms_7.captureText(driver,"//*[@id='result-stats']","Search Result",logger);
            String[] arrayResult = result.split(" ");
            System.out.println("My search number is :"+arrayResult[1]);

            //write the search number result back to writable sheet
            Label label = new Label(1,i,arrayResult[1]+" "+arrayResult[3]+" "+arrayResult[4]);
            //adding back to writable cell
            //writableSheet.addCell(label);
            wSheet.addCell(label);


        }//end of for loop

        //outside of the loop we need to write and close the excel
        writableFile.write();
        writableFile.close();
        readableFile.close();

        //end the test for specific @test
        reports.endTest(logger);

    }//end of @Test Method

}// end of java class
