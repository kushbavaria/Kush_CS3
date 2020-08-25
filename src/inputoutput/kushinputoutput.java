package inputoutput;

import java.io.*;
import java.util.Scanner;

public class kushinputoutput
{
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new FileReader("testtext.txt"));
            PrintWriter printer = new PrintWriter(new FileWriter("kush.txt"))){
                String lines;
                 int sum =0;
                while ((lines = reader.readLine()) !=null){
                    String[] stuff = lines.split(" ");
                   sum+= Integer.parseInt(stuff[1]);
                   
                    printer.println(lines);
           
        }
        printer.println("sum of all ages is:" + sum);
    }
        catch(IOException e){
            System.out.println(e);
        }
        
        
    }
}
