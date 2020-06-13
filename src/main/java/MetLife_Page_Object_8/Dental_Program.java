package MetLife_Page_Object_8;

import Reusable_Classes.Abstract_Class_ActionItms_7;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Dental_Program extends Abstract_Class_ActionItms_7 {

    ExtentTest logger;

    //Making constructor method
    public Dental_Program(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
        //local page logger gets set to Abstract class logger when you see it in
        //page object concept
        this.logger = super.logger;

    }//end of constructor



    //method for scrolling down
    public Dental_Program scrollToMiddle(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        logger.log(LogStatus.INFO,"Scrolling to the Middle of Dental Program Page");
        jse.executeScript("scroll(0,500)");
        return new Dental_Program(driver);

    }//end of scrollToMidle method

//method for clicking on Dental Program
    public Dental_Program Dental_Program(String userValue){
    //Reusable_Library_Loggers.click(driver,"//input[@class='\"+dentalProgram.get(i)+\"']","Dental Program",logger);
    Reusable_Library_Loggers.click(driver,"//input[@class='"+userValue+"']","Dental Program",logger);
        return new Dental_Program(driver);

    }//end of method for clicking on Dental Program

    //method for clicking on Enroll In Program Now
    public Dental_Program Enroll_In_Program_Now(){
        Reusable_Library_Loggers.click(driver,"//a[contains(text(),'ENROLL IN PROGRAM NOW')]","Enroll In Program Now",logger);
        return new Dental_Program(driver);

    }//end of method for clicking on Enroll In Program Now


}//end of java class
