package MetLife_Page_Object_8;

import Reusable_Classes.Abstract_Class_ActionItms_7;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Homepage extends Abstract_Class_ActionItms_7 {

ExtentTest logger;

//We need a contractor method that define
    //driver and logger to be reuse locally to this page class
    public MetLife_Homepage(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    //method for title verification
    public MetLife_Homepage verifyTitle(){
        Reusable_Library_Loggers.verifyTitle(driver,"Insurance and Employee Benefits | MetLife",logger);
        return new MetLife_Homepage(driver);
        //the driver that I used is returning me the same MetLife_Homepage

    }//end of Title Verification method

    //method for clicking on SOLUTION
    public MetLife_Homepage solution(){
    Reusable_Library_Loggers.click(driver,"//div[contains(text(),'SOLUTIONS')]","Clicking on SOLUTION",logger);
    return new MetLife_Homepage(driver);

    }//end of Click on SOLUTION method






}//end of java class
