package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_MortgageCalculator {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //Navigating to MortgageCalculator website
        driver.navigate().to("https://mortgagecalculator.org");

        Thread.sleep(3000);

        //declare and define javascript
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //scrolling all the way to bottom. 5000 means going to end of the page
        jse.executeScript("scroll(0,5000)");

        Thread.sleep(2000);

        //scrolling all the way to top again
        jse.executeScript("scroll(0,-5000)");


        /*
        //Scrolling to an element view for loan term
        try {
            WebElement loanTerm = driver.findElement(By.xpath("//*[@id='loanterm']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",loanTerm);   //";" is a javascript command
        } catch (Exception e){
            System.out.println("Unable to locate the Loan Term "+e);
        }//end of Long Term Exception
        */


        //Scrolling to en element view fro Home Value
        try {
            WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",homeValue);  // ";" is a javascript command
        } catch (Exception e){
            System.out.println("Unable to locate the Home Value "+e);
        }//end of Home Value Exception






    }//end of main method

}//end of java class
