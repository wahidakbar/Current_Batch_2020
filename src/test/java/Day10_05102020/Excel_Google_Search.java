package Day10_05102020;

import Reusable_Classes.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Excel_Google_Search {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

        //STEP 1:-------------------------------------------------------------------------------------------------------
        //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/Google_Search.xls"));

        //STEP 2:
        //locate the readable worksheet by index
        Sheet readableSheet = readableFile.getSheet(0); //I can also use 'sheet1' instead on index '0'

        //STEP 3:-------------------------------------------------------------------------------------------------------
        //we need create a writable workbook to mimic readable file because we should not be on writing on readable files
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/Resource/Google_Search_Result.xls"),readableFile);
        //create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);
        //get the total rows that are not empty
        int rows = writableSheet.getRows();

        //Define the webdriver using reusable library
        WebDriver driver = Reusable_Library.setDriver();

        //define the for loop
        for (int i = 1; i<rows; i++){

            //STEP 4:---------------------------------------------------------------------------------------------------
            //store the car column value as a string variable
            //columns are always hard coded whereas the rows are dynamic based on your i
            String cars = writableSheet.getCell(0,i).getContents();

            //Navigate to google.com
            driver.navigate().to("https://www.google.com");

            //timeout
            Thread.sleep(2000);

            //reusable library to enter car value on google search
            Reusable_Library.userKeys(driver,"//*[@name='q']",cars,"Search Fields");

            //reusable library to click on google search
            Reusable_Library.submit(driver,"//*[@name='btnK']","Google Search");

            //timeout
            Thread.sleep(2000);

            String result = Reusable_Library.captureText(driver,"//*[@id='result-stats']","Search Result");
            String[] arrayResult = result.split(" ");
            System.out.println("My search number is :"+arrayResult[1]);

            //STEPS 5:--------------------------------------------------------------------------------------------------
            //write the search number result back to writable sheet
            Label label = new Label(1,i,arrayResult[1]+" "+arrayResult[3]+" "+arrayResult[4]);
            //adding back to writable cell
            //writableSheet.addCell(label);
            writableSheet.addCell(label);


        }//end of for loop

        //outside of the loop we need to write and close the excel
        writableFile.write();
        writableFile.close();
        readableFile.close();


        //quit the driver
        driver.quit();





    }//end of main method

}// end of java class
