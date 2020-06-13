package Day4_04192020;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Google_Test {

    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path at least once in one of your main method
        //webdriver.chrome.driver need to be in lower case string following by your driver

  /*      //for Chrome driver
        //System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");
        //you declare and define the webdriver
        WebDriver driver = new ChromeDriver();
   */

        //for Firefox driver
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //opening the browser automatically to go to google.com home page
        driver.get("https://google.com");

        //also can be used different way to navigate
        //driver.navigate().to("https://www.google.com");


        //maximize your browser
        driver.manage().window().maximize();

        //wait few seconds after nevigeting to a page so brower can load property
        //sleep statement handles in miliseconds ao example is 1 sec = 1000 milisec
        Thread.sleep(2000);

        //locate the search field by inspecting it first then enter a keyward lets say cars
        driver.findElement(By.name("q")).sendKeys("cars");

        //I put this again because Iw ill need some time before it closes the session
        Thread.sleep(2000);

        //close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driver but not from your memory
        //I prefer to use quit
        

        Thread.sleep(2000);
        driver.quit();





    }//end of main method

}//end of java class
