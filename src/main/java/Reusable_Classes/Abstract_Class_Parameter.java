package Reusable_Classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Abstract_Class_Parameter {

    //
//to be used on your @test classes
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;



    //define before suite to set up a static driver

    @BeforeSuite
    public void defineDriver() {

        //define the report path here as a before suite
        reports = new ExtentReports("src//main//java//HTML_Report//TestReport.html", true);

    }//end og before suite

    //before method will be used to capture a unique @Test name that you gave
    //on your test class
    @Parameters("Browser")
    //before method will be used to capture a unique @test name that you gave on your test class
    @BeforeMethod
    public void getMethodName(Method testName, String Browser) {
        if (Browser.equalsIgnoreCase("Chrome")){
            driver = Reusable_Library_Loggers.setDriver();
        }else if(Browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver32.exe");
            driver = new FirefoxDriver();
        }//end of conditional statement
        //start the logger here to capture the specific @Test method
        logger = reports.startTest(testName.getName()+ "-" +Browser);

    }//end of before method

    @AfterMethod
    public void endTest() {
        reports.endTest(logger);

    }//end of After method

    @AfterSuite
    public void closeinfo() {
        reports.flush();

    }//end of after suite


}//end of java class
