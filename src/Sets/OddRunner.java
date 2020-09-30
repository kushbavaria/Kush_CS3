package Sets;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import static java.lang.System.*;

public class OddRunner
{
    public static void main( String args[] )
    {
        try(BufferedReader kb = new BufferedReader(new FileReader("oddevent.dat"))){
            String next;
            while((next = kb.readLine()) != null)
                System.out.println(new OddEvenSets(next));
        }
        catch(IOException e){
            System.out.println(e);
        }
        
                
    }
}