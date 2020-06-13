package MetLife_Page_Object_8;

import Reusable_Classes.Abstract_Class_ActionItms_7;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_TakeAlong_Dental extends Abstract_Class_ActionItms_7 {

ExtentTest logger;

//We need a contractor method that define
    //driver and logger to be reuse locally to this page class
    public MetLife_TakeAlong_Dental(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor


    //method for Clicking on TakeAlong Dental
    public MetLife_TakeAlong_Dental MetLife_TakeAlong_Dental(){
    Reusable_Library_Loggers.click(driver,"//a[contains(text(),'MetLife TakeAlong Dental')]","Clicking on MetLife TakeAlong Dental ",logger);
    return new MetLife_TakeAlong_Dental(driver);

    }//end of method for Clicking on TakeAlong Dental






}//end of java class
