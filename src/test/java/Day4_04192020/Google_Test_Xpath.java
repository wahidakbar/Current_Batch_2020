package Day4_04192020;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Test_Xpath {

    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path at least once in one of your main method
        //webdriver.chrome.driver need to be in lower case string following by your driver

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        //you declare and define the webdriver
        WebDriver driver = new ChromeDriver();

            //opening the browser automatically to go to google.com home page
            driver.get("https://google.com");
            //also can be used different way to nevigate
            //driver.navigate().to("https://www.google.com");


            //maximize your browser
            driver.manage().window().maximize();

            //wait few seconds after nevigeting to a page so brower can load property
            //sleep statement handles in miliseconds ao example is 1 sec = 1000 milisec
            Thread.sleep(2000);


                //locate the search field by inspecting it first then enter a keyward lets say cars
                driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
                //clicking on search button
                driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //wait for few seconds
            Thread.sleep(2000);

                //to capture a text from website
                String message = driver.findElement(By.id("result-stats")).getText();
                //using array varialbe to split the above message
                String[] arrayResult = message.split(" ");
                System.out.println("My result is "+ arrayResult[1]);


        //I put this again because I will need some time before it closes the session
        Thread.sleep(2000);

        //close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driver but not from your memory
        //I prefer to use quit
        //driver.close();
        driver.quit();




    }//end of main method

}//end of java class
