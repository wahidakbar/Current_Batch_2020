package MetLife_Page_Object_8;

import Reusable_Classes.Abstract_Class_ActionItms_7;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Base_Class extends Abstract_Class_ActionItms_7 {

    public MetLife_Base_Class(WebDriver driver){
    super();
        PageFactory.initElements(driver, this);
    }//end of MetLife Base Class

    //object for MetLife homepage
    public static MetLife_Homepage metLife_homepage(){
        MetLife_Homepage metLife_homepage = new MetLife_Homepage(driver);
        return metLife_homepage;
    }//end of object reference for MetLife homepage

    //object for TakeAlong Dental
    public static MetLife_TakeAlong_Dental metLife_takeAlong_dental(){
        MetLife_TakeAlong_Dental metLife_takeAlong_dental = new MetLife_TakeAlong_Dental(driver);
        return metLife_takeAlong_dental;
    }//end of object reference for TakeAlong Dental page

    //object for EnrollNow
    public static Enroll_Now enroll_now(){
        Enroll_Now enroll_now = new Enroll_Now(driver);
        return enroll_now;
    }//end of object reference for EnrollNow page

    //object for Zip Code
   public static Zip_Code zip_code(){
        Zip_Code zip_code = new Zip_Code(driver);
        return zip_code;
    }//end of object reference for Zip Code page

    //object for Dental Program
    public static Dental_Program dental_program(){
       Dental_Program dental_program = new Dental_Program(driver);
       return dental_program;
    }//end of object reference for Dental Program page

    //object for Referral Code
    public static Referral_Code referral_code(){
      Referral_Code referral_code = new Referral_Code(driver);
      return referral_code;
    }//end of object reference for Referral Code page


    //object for yahoo search result page
    public static MetLife_Capture_Text_Page metLife_capture_text_page() {
        MetLife_Capture_Text_Page metLife_capture_text_page = new MetLife_Capture_Text_Page(driver);
        return metLife_capture_text_page;

    }//end of object reference for MetLife Capture text page





}//end of java class
