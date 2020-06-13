package Day3_04182020;

public class Method_Execution_Classs {

    public static void main(String[] args) {

        //call the method to be executed
        Custom_Method.voidAdd(100, 200);


        //Call the return add method
        int c = Custom_Method.returnAdd(100, 200);
        System.out.println("new result is "+ (c+50));


    }//end of the main method


}//end of the java class
