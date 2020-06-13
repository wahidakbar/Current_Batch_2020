package Day3_04182020;

public class Custom_Method {

    //purpose of these users defined custom method so that I can reuse it again and again
    //ans call it on my main when I need to use them
    //user defined custom method will be created
    //lets create one for the void first
    //voidAdd is a name. I can choose other name also.
    public static void voidAdd (int a, int b) {
        int result =a+b;
        System.out.println("My additional result is "+result);
    }//end of void method




    //create same method as return method
    //returnAdd is a name. I can choose otjer name too
    //it is interegr so I used int here. If it is String then we must use String the the method name
    public static int returnAdd(int a, int b) {

        int c =a+b;
        System.out.println("my additional result "+c);
        return c; //will return the result c
    }//end of return method


}//end of java class
