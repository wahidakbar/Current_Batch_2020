package Day2_04112020;

public class Linear_Array {

    public static void main(String[] args) {

        //declare the empty string array variables first
        String[] locations, countries, places;
        //declare the empty int variables first
        int[] number, houseAddress;

        //declare the String variables
        locations = new String[]{"Sixflag","Disney","Beach"};
        countries = new String[]{"Bangladesh","USA","Canada","India"};

        //define the int array variables
        number = new int[]{1,2,3,4};
        houseAddress = new int[]{222,333,444,555};

        //print the last value from locations variables
        System.out.println("My Last Location is "+locations [2] + " is in array index "+number[1]);
        //printing the extra line for my better understanding
        System.out.println("My country is "+countries [0] + " My House address is "+houseAddress[2]);




    }//end of main method


}//end of java class
