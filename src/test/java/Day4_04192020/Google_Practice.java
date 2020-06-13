package Day4_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Google_Practice {
    public static void main(String[] args) throws InterruptedException {
        //Webdriver directives
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //--------------input into array
        String city [] =new String[4];
        city[0] = "Brooklyn";
        city[1] = "Queens";
        city[2] = "Bronx";
        city[3] = "Manhattan";
        for(int i = 0; i<city.length;i++) {


            //------------------open google
            driver.get("https://www.google.com");
            Thread.sleep(2000);
            driver.manage().window().maximize();
            Thread.sleep(2000);


            //--------------------type city name
           driver.findElement(By.name("q")).sendKeys(city[i]);
            //driver.findElement(By.name("btnK")).click();
           driver.findElement(By.name("btnK")).submit();//Clicking on search box.
           Thread.sleep(2000);
            //System.out.println(driver.findElement(By.id("result-stats")).getText());//optional


            //---------------------input of array
            String message = driver.findElement(By.id("result-stats")).getText();
            Thread.sleep(2000);
            String[] fraction=message.split(" ");
            System.out.println("My city is " + city[i] + " and search number is " + fraction[1]);




        }//end of for loop


        //--------------------
        driver.quit();

    }//end of the method
}//end of the java class
