package Day13_05302020;


import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean_htmlreport {

    //declare the driver outside
    WebDriver driver;

    //defining the report variable outside
    ExtentReports reports;

    //defining the logger(extent test)
    ExtentTest logger;


    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = Reusable_Library_Loggers.setDriver();
        //define the report path here as a before suite
        reports = new ExtentReports("src//main//java//HTML_Report//AutomationReport.html", true);
    }//end of before suite


    @Test
    public void yahoo_verification() throws InterruptedException {
        //define and start the test
        logger = reports.startTest("Yahoo Verification");
        //navigate to yahoo home page
        logger.log(LogStatus.INFO, "Navigate to Yahoo home page");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(4000);
        //i want tp count all the links in yahoo home page and print it
        logger.log(LogStatus.INFO, "Getting the list count for all links");
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        //printing the total number of link under the ID
        logger.log(LogStatus.INFO, "Actual number of links are :" + linkCount.size());
        System.out.println("The total number of links are :" + linkCount.size());
        //verify if the lickCount returns you 12 links
        if (linkCount.size() == 13) {
            System.out.println("MY yahoo page link count matches and it it " + linkCount.size());
            logger.log(LogStatus.PASS, "MY yahoo page link count matches and it it :" + linkCount.size());
        } else {
            System.out.println("MY yahoo home page link count doesn't matches and actual is " + linkCount.size());
            logger.log(LogStatus.FAIL, "MY yahoo home page link count doesn't matches and actual is :" + linkCount.size());
        }//end of if else method
        //clicking on signin
        Reusable_Library_Loggers.click(driver, "//*[@id='header-signin-link']", "Sign In",logger);
        //wait for few second
        Thread.sleep(3000);
        //veryfying the state of the checkbox is checked for stay sign in section
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState == false) {
            System.out.println("Checkbox is not selected by default");
            logger.log(LogStatus.FAIL, "Checkbox is not selected by default");
        } else {
            System.out.println("Checkbox is selected by default");
            logger.log(LogStatus.PASS, "Checkbox is selected by default");
        }//end of if else

        //end the test for specific @test
        reports.endTest(logger);

    }//end of test method


    @AfterSuite
    public void closeSession() {
        //driver.quit();
        //flushing = writing the log(logger) back to your automation report that you define
        reports.flush();
    }//end of after suits


}//end of java class
