package Day6_04262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Chrome_Option {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some precondition using Chrome options
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chromedriver
        WebDriver driver = new ChromeDriver(options);

        //navigating mlcalc .com
        driver.get("https://www.mlcalc.com");

        //wait few seconds
        Thread.sleep(3000);

        //I want to get/capture the page title if I want just title in the consoler
        //System.out.println("my title is "+driver.getTitle());
        //IF I WANT TO CAPTURE THE TITLE AND COMPARE WITH EXPECTATION
        // STORE YOUR ACTUAL TITLE IN A VARIABLES AND COMPARE IT WITH EXPECTATION
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("MORTGAGE AND LOAN CALCULATION")) {
            System.out.println(" Title matches with the expectation");
        }else {
            System.out.println("Title does not match the expectation. Actual title is "+actualTitle);
        }//end of if else condition

        //if same locator used more than once then store it as a WebElement variable to reuse it
        WebElement pPrice = driver.findElement(By.xpath("//*[@name = 'ma']"));
        // in above statement the name works but id does not, we can use 'or' operator.
            //WebElement pPrice = driver.findElement(By.xpath("//*[@id = 'ma' or @name = 'ma']"));
        //sometime it does not work with same name so we need to use tag name instead of *
            //WebElement pPrice = driver.findElement(By.xpath("//input[@id = 'ma']"));

        //clear the field first
        pPrice.clear();

        //enter your new data
        pPrice.sendKeys("400000");



        //store your start month in WebElement variable and call it on your Select command
        WebElement sMonth = driver.findElement(By.xpath("//*[@name = 'sm']"));

        //call my Select command and it only work when your dropdown locator in under 'Select' tag
        Select sMonthList = new Select(sMonth);

        //select the drop down value by visible text
        sMonthList.selectByVisibleText("May");// this is the best option as it is visible on the page
        //sMonthList.selectByIndex(0);// is is as per array system so it start from '0'
        //sMonthList.selectByValue("1");// it is property value so we need to put as per developer designed


        //whenever dropdown in not under Select tag then we must click on the dropdown and then
        //click on the value of the dropdown
        //we can do if we want to select single one
            //driver.findElement(By.xpath("//*[@name = 'sy']")).click();
            //Thread.sleep(2000);
            //any text or digit in black color so it is called as text.
            //driver.findElement(By.xpath("//*[text() = '2000']")).click();
        //let's verify some of the start year to make sure it is matching on the dropdown
        String [] yearArray = new String[] {"2006","2010","2025"};
        for (int i = 0; i < yearArray.length; i++) {
            driver.findElement(By.xpath("//*[@name = 'sy']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[text() = '"+yearArray[i]+"']")).click();
        }//end of for loop

        Thread.sleep(3000);
        //quit the page
        driver.quit();




    }//end of main method


}//end of java class
