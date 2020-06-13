package Action_Items;

import MetLife_Page_Object_8.MetLife_Base_Class;
import Reusable_Classes.Abstract_Class_ActionItms_7;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;

public class MetLife_Page_Object_ActnItm_8 extends Abstract_Class_ActionItms_7 {

    @Test
    public void MetFile_Verification() throws InterruptedException {
        //Implicit timing.
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

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




        logger.log(LogStatus.INFO, "Navigate to MetLife home page");
        //navigating to Metlife website
        driver.get("https://www.metlife.com");
        Thread.sleep(5000);
        MetLife_Base_Class.metLife_homepage().verifyTitle();
        Thread.sleep(5000);
        MetLife_Base_Class.metLife_homepage().solution();
        Thread.sleep(2000);
        MetLife_Base_Class.metLife_takeAlong_dental().MetLife_TakeAlong_Dental();
        Thread.sleep(5000);
        MetLife_Base_Class.enroll_now().verifyTitle();
        Thread.sleep(5000);

        for (int i=0; i<zipCode.size();i++) {

            MetLife_Base_Class.enroll_now().Enroll_Now();
        Thread.sleep(3000);

            //Declaring and definng Array List for new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            Thread.sleep(3000);

            //Calling the array list to new tab
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(4000);
        MetLife_Base_Class.zip_code().Zip_Code(zipCode.get(i));
        Thread.sleep(2000);
        MetLife_Base_Class.zip_code().GO_Zip_Code();
        Thread.sleep(3000);
        MetLife_Base_Class.dental_program().scrollToMiddle();
        Thread.sleep(2000);
        MetLife_Base_Class.dental_program().Dental_Program(dentalProgram.get(i));
        Thread.sleep(2000);
        MetLife_Base_Class.dental_program().Enroll_In_Program_Now();
        Thread.sleep(2000);
        MetLife_Base_Class.referral_code().Referral_Code(referrelCodes.get(i));
        Thread.sleep(2000);
        MetLife_Base_Class.referral_code().GO_Referral_Code();
        Thread.sleep(2000);
        MetLife_Base_Class.referral_code().error_Text();
        Thread.sleep(2000);
        MetLife_Base_Class.referral_code().EnrollWithout_referralCode();
        Thread.sleep(2000);
        MetLife_Base_Class.metLife_capture_text_page().capture_dentalProgram_text();






driver.close();

//Calling the array list to new tab
            driver.switchTo().window(tabs.get(0));


}//end of for loop

    }//end of @Test method




}//end of java class
