package Yahoo_Page_Object;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Homepage extends Abstract_Class {

ExtentTest logger;

//We need a contractor method that define
    //driver and logger to be reuse locally to this page class
    public Yahoo_Homepage(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    //method for search field
    public Yahoo_Homepage searchField(String userValue){
        Reusable_Library_Loggers.userKeys(driver,"//*[@id='header-search-input']",userValue,"Yahoo search field",logger);
        return new Yahoo_Homepage(driver);
        //the driver that I used is returning you tha same Yahoo_Homepage

    }//end of search method

    //method for search icon
    public Yahoo_Homepage searchIcon(){
    Reusable_Library_Loggers.click(driver,"//*[@id='header-desktop-search-button']","Clicking on Search icon",logger);
    return new Yahoo_Homepage(driver);

    }//end of search icon method






}//end of java class
