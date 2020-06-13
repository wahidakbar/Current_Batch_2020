package Day11_05162020;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class GoogleSearch_TestNG_Suite_1 {

    //when using the annotation method your local driver must be declared outside
    //so i can call it on my my annotation method
    WebDriver driver;
    String getURL;

    //It comes first to execute script wherever the location of this method is
    @BeforeSuite
    public void callDriver(){
        driver = Reusable_Library.setDriver();
    }//end of BeforeMethod


    @Test(priority = 1)
    public void SearchInGoogle() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        //enter keyward cars in the search field
        Reusable_Library.userKeys(driver, "//*[@name='q']", "cars", "Search field");
        //click on submit
        Thread.sleep(2000);
        Reusable_Library.submit(driver, "//*[@name='btnK']", "Google Search Button");
        //Getting the current URL for searchResult Page
        getURL=driver.getCurrentUrl();//this Script still runs without using this.
        //just to print the current URL in the console
        System.out.println("Current URL is :"+getURL);

    }//end of test priority 1


    @Test(priority = 2)
    // or @Test(dependsOnMethods = "SearchInGoogle")
    //When I use dependsOnMethod in my @test that means my second test is dependent on first test
    //if first test fails second test will be skipped
    //if all the test have "priority" they might or might not dependent on each other
        //@Test(dependsOnMethods = "SearchInGoogle")

    public void captureText() throws InterruptedException {
        driver.navigate().to(getURL);//this Script still works without using this
        //capture the text and print out the search number
        Thread.sleep(2000);
        String searchResult = Reusable_Library.captureText(driver,"//*[@id='result-stats']","Search Result");
        //split the text and print the number
        Thread.sleep(2000);
        String[] arraySearch = searchResult.split(" ");
        System.out.println("My search number for car is "+arraySearch[1]);

    }//end of Test Priority 2 or test(dependentOnMethods)


    //It comes last to execute script wherever the location of this method is
    @AfterSuite
    public void quitMethod(){
        driver.quit();

    }//end of quit Method




}// end of java class
