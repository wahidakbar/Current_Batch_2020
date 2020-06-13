package Day7_05022020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Met_Life_tabs {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some precondition using Chrome options
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chromedriver
        WebDriver driver = new ChromeDriver(options);

        //navigating to metlife
        driver.navigate().to("http://metlife.com");

        //Wait few seconds
        Thread.sleep(3000);

        //click on solution tab
        try {
            driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();//from class
            //driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();//by self
        } catch (Exception e){
            System.out.println("Unable to click on Solution "+e);
        }//end of solution exception

        //wait few seconds in between
        Thread.sleep(2000);

        //click on MetLife TakeAlong Dental
        try{
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();//from class
            //driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();//by self
        } catch (Exception e){
            System.out.println("Unable to click on MetLife TakeAlong Dental "+e);
        }//end of MetLife TakeAlong Dental exception

        Thread.sleep(3000);

        //Clicking on the ENROLL NOW
        try {
            driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();//from class
            //driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();//by self
        } catch (Exception e){
            System.out.println("Unable to click on Enroll Now Button "+e);
        }//end of Enroll Now exception

        //noe define ArrayList to handle all current windows tab that are open
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());//from class
        //ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());//by self

        //Switch to second tabs
        //Tabs counts starts from left to right with index number 0.
        driver.switchTo().window(tabs.get(1));//from class
        //driver.switchTo().window(tabs.get(1));//by self

        //enter your ZipCode
        try {
            driver.findElement(By.xpath("//*[@id='txtZipCode']")).sendKeys("11218");//from class
            //driver.findElement(By.xpath("//*[@id = 'txtZipCode']")).sendKeys("11218");//by self
        } catch (Exception e){
            System.out.println("Unable to put ZipCode "+e);
        }//end of enter zip code exception

        Thread.sleep(3000);

        //I want to close this tab
        driver.close();

        //Switch to previous tab
        driver.switchTo().window(tabs.get(0));//from class
        //driver.switchTo().window(tabs.get(0));//by self

        //If another new tab open then we need to redefine it by simply
        tabs = new ArrayList<>(driver.getWindowHandles());

        //we need to locate it to find by following. It will be Index (2) as already one new tab opened
        //And that earlier new tab in not closed. If it was closed then the index would be(1).
        driver.switchTo().window(tabs.get(1));


        Thread.sleep(5000);

        //Quiting the website
        driver.quit();





    }//end of main method


}//end of java class
