package Day12_05172020;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Kayak_TestNG_Assertion {

    //Declare the webdriver outside of all method to be reused
    WebDriver driver;

    @BeforeSuite
    public void defineDriver(){
        driver = Reusable_Library.setDriver();

    }//end of define driver method


    @Test
    public void kayakTestCase() throws InterruptedException {

        driver.navigate().to("https://www.kayak.com");
        Thread.sleep(2000);

        //verifying the title using hard assertion
        //Assert.assertEquals(driver.getTitle(),"Search Hotel, Cars");

        //using soft assertion
        SoftAssert sAssert = new SoftAssert();

        sAssert.assertEquals(driver.getTitle(),"Search Hotel, Cars");

        //Click on Airport/City
        Reusable_Library.click(driver,"//div[@data-placeholder='Enter an airport or city']","Search Fields");

        //enter the airport
        Reusable_Library.userKeys(driver,"//*[@name='pickup']","JFK","Search Fields");

        Thread.sleep(3000);

        //Pass assert that way it does not skip all your past test steps
        sAssert.assertAll();

    }//end of Kayak test case

    @AfterSuite
    public void closeSession(){
        driver.quit();

    }//end of close session method



}//end of java class
