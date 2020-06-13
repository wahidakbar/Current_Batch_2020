package Day3_04182020;

public class if_else_with_operators {

    public static void main(String[] args) {

        // if students get grade from 90 to 100 then it is A
        // if students get grade from 80 to below 90 then it is B
        // if students get grade from 70 to below 80 then it is C
        // if anything below C (or below 70) is failure (F)

        //define a variable which represent grade number
        int grade = 60;
        //&& represents 'and' operators in java
        // && 'and' operators all condition has to be true
        // || 'or' operator one of the condition has to be true
        if(grade >= 90 && grade <=100) {
            System.out.println("Students grade is A");

        } else if (grade >=80 && grade < 90) {
            System.out.println("Students grade is B");

        } else if (grade >=70 && grade < 80) {
            System.out.println(" Students grade is C");

        } else {
            System.out.println(" Students grade is F");
        }// end of the if else operator condition



    }// end of main method

    }// end of java class
