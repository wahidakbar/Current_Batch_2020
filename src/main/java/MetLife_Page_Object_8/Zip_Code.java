package MetLife_Page_Object_8;

import Reusable_Classes.Abstract_Class_ActionItms_7;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Zip_Code extends Abstract_Class_ActionItms_7 {

ExtentTest logger;

//We need a contractor method that define
    //driver and logger to be reuse locally to this page class
    public Zip_Code(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor


    //method for Zip Code Typing
    public Zip_Code Zip_Code(String userValue){
    Reusable_Library_Loggers.userKeys(driver,"//input[@id = 'txtZipCode']",userValue,"Zip Code Box",logger);
    return new Zip_Code(driver);

    }//end of method for Zip Code Typing

    //method for clicking on GO
    public Zip_Code GO_Zip_Code(){
        Reusable_Library_Loggers.click(driver,"//*[@id ='txtZipCodetxt']","clicking on GO",logger);
        return new Zip_Code(driver);

    }//end of method for clicking on GO





}//end of java class
