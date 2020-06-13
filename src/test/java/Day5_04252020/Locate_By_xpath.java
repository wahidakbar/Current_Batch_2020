package Day5_04252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate_By_xpath {

    public static void main(String[] args) throws InterruptedException {

        //Optional but can be practised.........
        //in this case we can use the String variables name instead of giving the whole xpath in the statement
        //
        //line below store your search field xpath as a string variables
        String searchPath = "//*[@name='field-keywords']";
        //line below store your search icon xpath as a string variables
        String searchIconPath = "//*[@value = 'Go']";
        //line below store your image icon xpath as a string variables
        String searchImageIcon = "//img[contains(@class,'s-image')]";


        //define your property
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //define the driver
        WebDriver driver = new ChromeDriver();
        //Navigating to Amazon website
        driver.get("https://amazon.com");
        //Maximizing the page
        driver.manage().window().maximize();
        //waiting few seconds
        Thread.sleep(2000);

        //finding the search box and typing laopt in it
        // '*' means ignoring the tag; tag is input here in the DOM
        // '//' means
        //this is single way to find the search box
        driver.findElement(By.xpath("//*[@name='field-keywords']")).sendKeys("laptop");
        //We can use or here to find the search box either by any one of the xpath if I am not sure about the unique of the value
        //enter a keyword laptop on amazon search field by using xpath
        // for 'or'
           //driver.findElement(By.xpath("//*[@name='field-keywords' or @id='twotabsearchtextbox']")).sendKeys("laptop");

        
        //if we use string for xpath //optional one in the beginning of the class
        //driver.findElement(By.xpath(searchPath)).sendKeys("laptop");

        //click on search icon
        // for AND operator, all the condition have to be true
        driver.findElement(By.xpath("//*[@value = 'Go']")).submit();//.click is the best option
            //driver.findElement(By.xpath("//*[@type='submit' and @value = 'Go']")).submit();

        Thread.sleep(3000);
        //click on the second image item of the same element within that page using index number
        driver.findElements(By.xpath("//*[@class = 's-image']")).get(1).click();
        //it means that the code will find the element that contain s-image in the page
        //in this case we do not need to mention the full class name. It will find by the value contains in the DOM
        //THIS IS NOT BEST PRACTICE TO FIND THE ELEMENTS but we need to do it if class name is not unique for all.
            //driver.findElements(By.xpath("//*[contains(@class,'s-image')]")).get(1).click();
        //using 'img'  instead of * is more specific to find out the element
        // we have to use , instead of = because = means exactly but , means just contains the value.
            //driver.findElements(By.xpath("//img[contains(@class,'s-image')]")).get(3).click();



        Thread.sleep(2500);
        //renavigate the home page
            //driver.get("https://amazon.com");










    }//end of main method
}//end of java class
