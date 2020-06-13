package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Actions_USPS {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigating to USPS
        driver.navigate().to("https://www.usps.com");

        Thread.sleep(3000);

        //call your Mouse Actions
        Actions mouse = new Actions(driver);

        //hover to Mail & Ship
        try{
            WebElement mailAndShip = driver.findElement(By.xpath("//*[text()= 'Mail & Ship']"));
            //WebElement mailAndShip = driver.findElement(By.xpath("//*[@id= 'Mail & Ship']"));
            //call your actions command to move to the element
            mouse.moveToElement(mailAndShip).perform();
        }catch (Exception e){
            System.out.println("Unable to locate Mail & Ship "+e);
        }//end of Mail & Ship Exception


        //click on Click-N-Ship using Actions
        try{
            WebElement clickAndShip = driver.findElement(By.xpath("//a[text()= 'Click-N-Ship']"));

            //We can make unique by Child-Parent method of Xpath. It is from Parent to Child. 'following::' can be used between / and a.
                //WebElement clickAndShip = driver.findElement(By.xpath("//*[@class= 'tools-cns']/a[text()= 'Click-N-Ship']"));
                //WebElement clickAndShip = driver.findElement(By.xpath("//*[@class= 'tools-cns']following::/a[text()= 'Click-N-Ship']"));

            //We can make unique by Child-Parent method of Xpath. It is from Child to parent. We have to use 'preceding::' between / and li.
                //WebElement clickAndShip = driver.findElement(By.xpath("//a[text()= 'Click-N-Ship']/preceding::li[@class= 'tools-cns']"));

            //as there are more than one so we can also use 'findElements'
            //WebElement clickAndShip = driver.findElements(By.xpath("//a[text()= 'Click-N-Ship']")).get(1);

            //call your actions command to move to the element and then Click
            mouse.moveToElement(clickAndShip).click().perform();
            //We can use Submit instead of Click. The syntax will be as follows
                //clickAndShip.submit(); //or the other way is following
                //mouse.moveToElement(clickAndShip).sendKeys(Keys.ENTER).perform(); //word Keys is showing wrong
        }catch (Exception e){
            System.out.println("Unable to locate click-N-Ship "+e);
        }//end of Click-N-Ship Exception






    }//end of main method

}//end of java class
