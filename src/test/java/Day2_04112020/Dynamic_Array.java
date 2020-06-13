package Day2_04112020;

public class Dynamic_Array {

    public static void main(String[] args) {

        //declare string dynamic array variables
        String[] locations, countries;
        //declare integer dynamic array variables
        int[] number, houseAddress;

        //define the dynamic array with the length(size) of the variables
        countries = new String[6];
        countries[0] = "USA";
        countries[1] = "Canada";
        countries[2] = "Russia";
        countries[3] = "Bangladesh";
        countries[4] = "India";
        countries[5] = "China";

       //now printing the statement
        System.out.println("My Country is "+countries[3]+" but I am living in "+countries[0]+" now");

        //define the int variables
        number = new int[5];
        number[0] = 1;
        number[1] = 2;
        number[2] = 3;
        number[3] = 4;

        //now printing the statement
        System.out.println("My Country is "+countries[3]+" and my house number is "+number[1]);



    }//end of main method


}// end of java class
