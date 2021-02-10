package ShortestPathGraph;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -Kush

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;
public class ShortestPathGraphRunner
{
    public static void main( String[] args ) throws IOException
    {
        try(BufferedReader bReader = new BufferedReader(new FileReader("graph.dat"))){
            int paths = Integer.parseInt(bReader.readLine());
            for(int i = 0; i<paths; i++){
                ShortestPathGraph trial = new ShortestPathGraph(bReader.readLine());
                String goal = bReader.readLine();
                String start = goal.substring(0,1);
                String end = goal.substring(1,2);
                trial.check(start,end,"",0);
                System.out.println(start + " connects to " + end + " == " + trial );
            }
        }
        catch(IOException e){
            System.out.println("Runner doesnnt work");
        }
    }
}