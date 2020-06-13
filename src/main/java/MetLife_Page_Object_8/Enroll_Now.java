package MetLife_Page_Object_8;

import Reusable_Classes.Abstract_Class_ActionItms_7;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Enroll_Now extends Abstract_Class_ActionItms_7 {

ExtentTest logger;

//We need a contractor method that define
    //driver and logger to be reuse locally to this page class
    public Enroll_Now(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    //method for title verification
    public Enroll_Now verifyTitle(){
        Reusable_Library_Loggers.verifyTitle(driver,"MetLife TakeAlong Dental | MetLife",logger);
        return new Enroll_Now(driver);
        //the driver that I used is returning me the same MetLife_Homepage

    }//end of Title Verification method

    //method for clicking on Enroll Now
    public Enroll_Now Enroll_Now(){
    Reusable_Library_Loggers.click(driver,"//a[contains(text(),'Enroll Now')]","Clicking on Enroll Now ",logger);
    return new Enroll_Now(driver);

    }//end of method for clicking on Enroll Now





}//end of java class
