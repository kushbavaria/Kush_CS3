package Hashtables;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import static java.lang.System.*;

public class HashTableRunner
{
  public static void main ( String[] args )
  {
        try(BufferedReader bReader = new BufferedReader(new FileReader("numbers.dat"))){
            //make a new table          
            HashTable t = new HashTable();
            //read from the file    
            int lines = Integer.parseInt(bReader.readLine());
            for(int i = 0; i < lines; i++){
                Scanner l = new Scanner(bReader.readLine());
                //load stuff into the table
                Number next = new Number(l.nextInt());
                t.add(next);
            }
            //print out the table
            System.out.println(t);
        }
        catch(Exception e)
        {
            System.out.println("Houston, we have a problem!");
        }
  }
}