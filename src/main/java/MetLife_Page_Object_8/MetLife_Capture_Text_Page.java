package MetLife_Page_Object_8;

import Reusable_Classes.Abstract_Class_ActionItms_7;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MetLife_Capture_Text_Page extends Abstract_Class_ActionItms_7 {

    ExtentTest logger;

    //Making constructor method
    public MetLife_Capture_Text_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
        //local page logger gets set to Abstract class logger when you see it in
        //page object concept
        this.logger = super.logger;

    }//end of constructor
    

    //method to capture the search number
    public MetLife_Capture_Text_Page capture_dentalProgram_text(){
     String result = Reusable_Library_Loggers.captureText(driver,"//*[contains(text(),'MetLife TakeAlong Dental℠')]","text of Dental Program",logger);
        String[] arrayMessage = result.split(" ");
        System.out.println("My Search Result is : "+arrayMessage[3]);
     return new MetLife_Capture_Text_Page(driver);

    }//end of searchNumber method




}//end of java class
