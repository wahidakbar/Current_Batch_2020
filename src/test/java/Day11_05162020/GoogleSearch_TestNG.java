package Day11_05162020;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.ArrayList;

public class GoogleSearch_TestNG {

    //when using the annotation method your local driver must be declared outside
    //so i can call it on my my annotation method
    WebDriver driver;
    ArrayList<String> cars = new ArrayList<>();


    //it is the main steps to execute the text cases wherever the location of this method is
    @Test
    public void GoogleSearch() throws InterruptedException {
        for (int i =0; i<cars.size(); i++) {
            driver.navigate().to("https://www.google.com");
            Thread.sleep(2000);
            //enter keyward cars in the search field
            //Reusable_Library.userKeys(driver, "//*[@name='q']", "cars", "Search field");
            Reusable_Library.userKeys(driver, "//*[@name='q']", cars.get(i), "Search field");
            //click on submit
            Thread.sleep(2000);
            Reusable_Library.submit(driver, "//*[@name='btnK']", "Google Search Button");
            //capture the text and print out the search number
            Thread.sleep(2000);
            String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search Result");
            //split the text and print the number
            Thread.sleep(2000);
            String[] arraySearch = searchResult.split(" ");
            Reporter.log("My search number for car is " + arraySearch[1]);
            System.out.println("My search number for car is " + arraySearch[1]);

        }//end of for loop

    }//end of google search method

    //It comes first to execute wherever the location of this method is
    //@BeforeMethod
    @BeforeSuite
    public void callDriver(){
        driver = Reusable_Library.setDriver();
        cars.add("BMW");
        cars.add("Lexus");
        //driver.navigate().to("https://google.com");//if we do not use loop then we can use navigation here.

    }//end of BeforeMethod



    //It comes last to execute wherever the location of this method is
    //@AfterMethod
    @AfterSuite
    public void quitMethod(){
        driver.quit();

    }//end of quit Method




}// end of java class
