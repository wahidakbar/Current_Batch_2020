package Action_Items;
import Reusable_Classes.Abstract_Class_ActionItms_7;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class Google_Search_7 extends Abstract_Class_ActionItms_7 {

    @Test
    public void Google_Search_verification() throws InterruptedException {

        logger.log(LogStatus.INFO, "Navigate to Google home page");
        //opening the browser automatically to go to google.com home page
        driver.get("https://google.com");

        //wait few seconds after nevigating to a page so browser can load property
        Thread.sleep(2000);

        logger.log(LogStatus.INFO, "Getting the search box and typing the cars in the search box");
        //locate the search field by inspecting it first then enter a keyward lets say cars
        driver.findElement(By.name("q")).sendKeys("cars");



        //end the test for specific @test
        reports.endTest(logger);


    }//end of @Test Method


}//end of Java class


