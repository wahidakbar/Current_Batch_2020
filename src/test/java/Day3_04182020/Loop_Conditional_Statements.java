package Day3_04182020;

public class Loop_Conditional_Statements {

    public static void main(String[] args) {
        // only print out city Brooklyn or Queens.
        String [] city = new String[4];
        city [0] = "Brooklyn";
        city [1] = "Queens";
        city [2] = "Manhattan";
        city [3] = "Bronx";

        for ( int i = 0; i < city.length; i++) {
            //using if else if else condition
            //String can have '.equal()' command or '==' but integer must use'=='
            //'equal' command when the expected value is matching the array value
            //'equalIgnoreCase' command will ignore case sensitivity as long as the array spelling is correct


            /*
            //if (city[i].equalsIgnoreCase("Brooklyn") || city[i] == "Queens") { 'in this we can write 'brooklyn' but it
             //will find the word
            if (city[i].equals ("Brooklyn")) {   //if(city[i] == "Brooklyn") can be used instead of previous statement.
                System.out.println("My City is "+city[i]);
            }
            else if (city[i] == "Queens") {
                System.out.println("My City is "+city[i]);

            }//end of if else if condition
             */



            //using 'or' || operator to meet the same condition are above
            //if (city[i].equalsIgnoreCase("Brooklyn") || city[i] == "Queens") { 'in this we can write 'brooklyn' but it
            // will find the word'Brooklyn'
            if (city[i].equals("Brooklyn") || city[i] == "Queens") {
                System.out.println("My City is "+city[i]);

            }//end of operator condition


        }//end of for loop
        }//end of main method

    }// end of the java class
