package Action_Items;

import Reusable_Classes.Abstract_Class_ActionItms_7;
import Reusable_Classes.Reusable_Library_ActionItms_7;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class MetLife_7 extends Abstract_Class_ActionItms_7 {

    @Test
    public void MetLife_verification() throws InterruptedException {

//Implicit timing.
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        logger.log(LogStatus.INFO, "Navigate to MetLife home page");
        //navigating to Metlife website
        driver.get("https://www.metlife.com");

        //Calling verifyTitle method

        Reusable_Library_ActionItms_7.verifyTitle(driver,"Insurance & Employee Benefit | Metlife",logger);
        Thread.sleep(5000);

        //Clicking on the SOLUTION
        Reusable_Library_ActionItms_7.click(driver,"//div[contains(text(),'SOLUTIONS')]","Click on SOLUTION",logger);

        Thread.sleep(5000);

        //Clicking on MetLife TakeAlong Dental
        Reusable_Library_ActionItms_7.click(driver,"//a[contains(text(),'MetLife TakeAlong Dental')]","Click on MetLife TakeAlong Dental",logger);

        Thread.sleep(3000);

        //Verifying loaded page title for MetLife TakeAlong Dental | Metlife
        Reusable_Library_ActionItms_7.verifyTitle(driver,"MetLife TakeAlong Dental | Metlife",logger);

        //Defining and dclaring variables for zipCode
        ArrayList<String> zipCode= new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("11219");
        zipCode.add("11217");

        //Defining and dclaring variables for referrelCodes
        ArrayList<String> referrelCodes= new ArrayList<>();
        referrelCodes.add("First");
        referrelCodes.add("Second");
        referrelCodes.add("Third");

        //Defining and dclaring variables for dentalProgram
        ArrayList<String> dentalProgram= new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        for (int i=0; i<zipCode.size(); i++) {

            Thread.sleep(3000);

            //Clicking on Enroll Now Button
            Reusable_Library_ActionItms_7.click(driver,"//a[contains(text(),'Enroll Now')]","Clicking on Enroll Now",logger);

            //Declaring and definng Array List for new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            Thread.sleep(3000);

            //Calling the array list to new tab
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(4000);


            //Putting Zip Codes in the box
            Reusable_Library_ActionItms_7.userKeys(driver,"//input[@id = 'txtZipCode']",zipCode.get(i),"Zip Code box",logger);

            //Clicking on the Go Button
            Reusable_Library_ActionItms_7.click(driver,"//*[@id ='txtZipCodetxt']","Clicking on GO",logger);

            Thread.sleep(5000);

            //Clicking on Dental Program arrayList
            Reusable_Library_ActionItms_7.click(driver,"//input[@class='"+dentalProgram.get(i)+"']","Dental Program",logger);

            Thread.sleep(3000);

            //Clicking on ENROLL IN PROGRAM NOW
            Reusable_Library_ActionItms_7.click(driver,"//a[contains(text(),'ENROLL IN PROGRAM NOW')]","ENROLL IN PROGRAM NOW",logger);

            Thread.sleep(3000);

            // Putting codes to referral code box
            Reusable_Library_ActionItms_7.userKeys(driver,"//input[@id = 'txtBxPromocode']",referrelCodes.get(i),"Referral Code",logger);
            //Click on Enroll Go
            Reusable_Library_ActionItms_7.click(driver,"//button[@id ='enrollgobtn']","Enroll Go",logger);

            Thread.sleep(3000);

            //capturing the error messages and printing in console box
            Reusable_Library_ActionItms_7.captureText(driver,"//span[contains(text(),'Referral Code was not recognized')]","Capturing the Error Text",logger);

            Thread.sleep(3000);
            //clicking on enroll without referral code
            Reusable_Library_ActionItms_7.click(driver,"//*[@id = 'withoutrefcode']","enroll without referral code",logger);

            Thread.sleep(5000);

            //Capturing the text of Dental Program
            String result = Reusable_Library_ActionItms_7.captureText(driver,"//*[contains(text(),'MetLife TakeAlong Dental℠')]","text of Dental Program",logger);
            String[] arrayMessage = result.split(" ");
            if (dentalProgram.get(i).equals(arrayMessage[3])) {
                System.out.println("Dental Program matches the expectation"+arrayMessage);
            }else {
                System.out.println("Dental Program does not match. The actual name of search program is "+arrayMessage[3]);
            }//end of if else condition


            Thread.sleep(3000);

            //Closing the new tabs
            driver.close();

            Thread.sleep(1000);

            //Return to the main tabs
            driver.switchTo().window(tabs.get(0));


        }//end of for loop

        //end the test for specific @test
        reports.endTest(logger);


    }//end of @Test Method

}//end of java class
