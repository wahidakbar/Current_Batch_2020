package Day4_04192020;

public class split_command {

    public static void main(String[] args) {

        //create a string message first and store it as a single string variables
       //message is just a name. we can give other name too.

        // String message = "Welcome to Selenium Automation Class";



        // I want to print the only keyword 'Selenium' from my message variables
        //we need to define string array variables in order to split the message

        //String[] arrayResult = message.split(" ");
        //print the result
        //System.out.println("My final message is "+ arrayResult[2]);


        //If we put a _ then the way will be as following
        String message = "Welcome to_Selenium Automation Class";

        String[] arrayResult = message.split(" ");

        String[] array2 = arrayResult[1].split("_");

        System.out.println("My final message is "+ array2[1]);

        //you want to print out to & class
        System.out.println("My to keyword is "+array2[0]+" my class keyword is "+arrayResult[3]);





    }//end of main method



}//end of java class
