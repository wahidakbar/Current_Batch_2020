package MetLife_Page_Object_8;

import Reusable_Classes.Abstract_Class_ActionItms_7;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Referral_Code extends Abstract_Class_ActionItms_7 {

ExtentTest logger;

//We need a contractor method that define
    //driver and logger to be reuse locally to this page class
    public Referral_Code(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor


    //method for referral code Typing
    public Referral_Code Referral_Code(String userValue){
    Reusable_Library_Loggers.userKeys(driver,"//input[@id = 'txtBxPromocode']",userValue,"Referral Code Typing",logger);
    return new Referral_Code(driver);

    }//end of method for Zip Code Typing

    //method for clicking on GO the referral code
    public Referral_Code GO_Referral_Code(){
        Reusable_Library_Loggers.click(driver,"//button[@id ='enrollgobtn']","clicking on GO Referral Code",logger);
        return new Referral_Code(driver);

    }//end of method for clicking on GO the referral code

    //method to capture the error text
    public MetLife_Capture_Text_Page error_Text(){
        String searchResult = Reusable_Library_Loggers.captureText(driver,"//span[contains(text(),'Referral Code was not recognized')]","Capture Error Text",logger);
        return new MetLife_Capture_Text_Page(driver);

    }//end of capture the error text method

    //method for clicking on enroll without referral code
    public Referral_Code EnrollWithout_referralCode(){
        Reusable_Library_Loggers.click(driver,"//*[@id = 'withoutrefcode']","enroll without referral code",logger);
        return new Referral_Code(driver);

    }//end of method for clicking on enroll without referral code





}//end of java class
