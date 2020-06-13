package Day7_05022020;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;


public class Google_Test_tryCatch_arrayList {

    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path at least once in one of your main method
        //webdriver.chrome.driver need to be in lower case string following by your driver

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        //you declare and define the webdriver
        WebDriver driver = new ChromeDriver();


        //set the ArrayList for the cars
        //do not need to define the size/length and also do not need ti define the index number
        //it is a resizable Array
        ArrayList<String> cars =new ArrayList<>();
        cars.add("Lexus");
        cars.add("Toyota");
        cars.add("BMW");

        for(int i=0; i<cars.size(); i++) {

            //opening the browser automatically to go to google.com home page
            driver.get("https://google.com");
            //also can be used different way to nevigate
            //driver.navigate().to("https://www.google.com");


            //maximize your browser
            driver.manage().window().maximize();

            //wait few seconds after nevigeting to a page so brower can load property
            //sleep statement handles in miliseconds ao example is 1 sec = 1000 milisec
            Thread.sleep(2000);

            //using try catch exception to handle any error
            //try catch is used to find out the mistake in capturing elements fromDOM
            try {
                //locate the search field by inspecting it first then enter a keyward lets say cars
                //driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));
                WebElement search = driver.findElement(By.xpath("//*[@name='q']"));
                search.sendKeys(cars.get(i));
            } catch (Exception e) {
                System.out.println("Unable to enter data on search box " + e);
            }//end of search field exception

            try{
                driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            } catch (Exception e){
                System.out.println("Unable to submit ON search Icon "+e);
            }//end of search Icon Exception

            //wait for few seconds
            Thread.sleep(2000);

            try{
                //to capture a text from website
                String message = driver.findElement(By.id("result-stats")).getText();
                //using array varialbe to split the above message
                String[] arrayResult = message.split(" ");
                System.out.println("My result is "+ arrayResult[1]);
            } catch(Exception e) {
                System.out.println("Unable to capture on search result "+e);
            }//end of search result exception

            //I put this again because I will need some time before it closes the session
            Thread.sleep(2000);


        }//end of for loop


        //when you inspect an element and most of the time it takes you to the lowest tag and property within it
        //but I can still use the tag and the property before it as long as it highlight the same element in the page


        //I put this again because I will need some time before it closes the session
        Thread.sleep(2000);

        //close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driver but not from your memory
        //I prefer to use quit

        driver.quit();




    }//end of main method

}//end of java class
