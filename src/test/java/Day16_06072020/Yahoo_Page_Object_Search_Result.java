package Day16_06072020;

import Reusable_Classes.Abstract_Class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Yahoo_Page_Object_Search_Result extends Abstract_Class {

    @Test
    public void Yahoo_Search_Result() throws InterruptedException {

        //using arrayList to define array test data
        ArrayList<String> cars= new ArrayList<>();
        cars.add("Lexux");
        cars.add("BMW");
        cars.add("Mercedes");


    for (int i=0; i<cars.size();i++) {

    logger.log(LogStatus.INFO, "Navigate to yahoo Home Page");
    driver.navigate().to("https://www.yahoo.com");
    Thread.sleep(3000);
    Yahoo_Base_Class.yahoo_homepage().searchField(cars.get(i));
    Thread.sleep(2000);
    Yahoo_Base_Class.yahoo_homepage().searchIcon();
    Thread.sleep(4000);
    Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
    Thread.sleep(2000);
    Yahoo_Base_Class.yahoo_search_result_page().searchNumber();


}//end of for loop

    }//end of @Test method




}//end of java class
