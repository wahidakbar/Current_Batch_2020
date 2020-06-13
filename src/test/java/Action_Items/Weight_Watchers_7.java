package Action_Items;

import Reusable_Classes.Abstract_Class_ActionItms_7;
import Reusable_Classes.Reusable_Library_ActionItms_7;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Weight_Watchers_7 extends Abstract_Class_ActionItms_7 {

    @Test
    public void Weight_Watchers_verification() throws InterruptedException {

//Implicit timing.
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        logger.log(LogStatus.INFO, "Navigate to Weight Watchers home page");
        //Navigating to the weightwatchers.com
        driver.navigate().to("http://www.weightwatchers.com");
        //Wait few seconds
        Thread.sleep(2000);
        //Getting the page title
        Reusable_Library_ActionItms_7.verifyTitle(driver,"Weight Loss & Wellness Help",logger);

        Thread.sleep(2000);

        //Declaring and defining String variables
        String[] zipCode = new String[3];
        zipCode[0] = "11238";
        zipCode[1] = "11216";
        zipCode[2] = "11201";

        Thread.sleep(2000);
        //Defining the for loop
        for(int i = 0; i<zipCode.length; i++){
            driver.findElement(By.xpath("//*[text() = 'Find a Workshop']")).click();
            logger.log(LogStatus.INFO, "Successfully got the ZipCode into the Meeting Search Box");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='meetingSearch']")).sendKeys(zipCode[i]);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class='btn spice-translated']")).click();
            Thread.sleep(2000);

            //Applying if else conditional to get the link and click on it
            if(i==0){
                logger.log(LogStatus.INFO, "Successfully locate and click on third one");
                driver.findElements(By.xpath("//div[@class='location__top']")).get(3).click();
            }
            else if(i==1){
                logger.log(LogStatus.INFO, "Successfully locate and click on second one");
                driver.findElements(By.xpath("//div[@class='location__top']")).get(2).click();
            }
            else if(i==2){
                logger.log(LogStatus.INFO, "Successfully locate and click on first one");
                driver.findElements(By.xpath("//div[@class='location__top']")).get(1).click();

            }//end of if else condition

            Thread.sleep(3000);
            //printin the Location
            Reusable_Library_ActionItms_7.captureText(driver,"//div[@class='location__container']","Location Text",logger);

            //Printing the achedule
            Reusable_Library_ActionItms_7.captureText(driver,"//div[@class='meeting-schedule meeting-detail-bottom-section']","Schedule",logger);


        }//end of for loop

        //end the test for specific @test
        reports.endTest(logger);


    }//end of @Test Method

}//end of java class
