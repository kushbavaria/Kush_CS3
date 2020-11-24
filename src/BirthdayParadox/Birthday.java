package BirthdayParadox;

import java.util.Scanner;
public class Birthday
{
    public static void main(String[] args){
        int count = 0;
        String output = "";
        String trialResults = "";
        String cont = "Y";
        String matchingTrials = "Y";
        int trials = 0;
        int students =0;
        Scanner input = new Scanner(System.in);

        while(cont.equals("Y")){
            System.out.print("how many students are in the class? ");
            students = input.nextInt();
            System.out.print("how many trials do you want to run? ");
             trials = input.nextInt();
              System.out.print("do you want to see all the matching trials(Y or N)? ");
            matchingTrials = input.next();
             System.out.println("the theoretical probability of a match is: "+ getTheoretical(students));
            if(matchingTrials.equals("Y")) {
                for (int i = 0; i < trials; i++) {
                    if (!(trialResults = trial(students)).equals("no match")) {
                        output += trialResults + "\n";
                        count++;
                    }
                }
                System.out.println(output);
            }
            else {
                System.out.println("");
            }
            System.out.println(("using " + students+ " students and " + trials + " the number where same birthday was present is: " + count +" which is " + ((double)count/trials)*100) + "%");
            System.out.print("\n do you want to run another trial (Y or N)? ");
            cont = input.next();
            System.out.println();
        }
    }
    
    public static double getTheoretical(int students){
        double prob = 1.0;
        for(int i = 0; i < students; i++)
            prob *= 365 - i;
        return 1 - prob/Math.pow(365,students);
    }
    
    public static String trial(int student){
        Student[] studarray = new Student[student];
        for(int i = 0; i < studarray.length; i++)
            studarray[i] = new Student();
           
        for(int i = 0; i < studarray.length-1; i++)
            for(int j = i + 1; j < studarray.length; j++)
                if(studarray[i].equals(studarray[j]))
                    return "found match on student " + (j + 1) + " " + studarray[i];
        
        return "no match";
    }
}