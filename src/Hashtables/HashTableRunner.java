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
        try(BufferedReader KBreader = new BufferedReader(new FileReader("numbers.dat"))){
            //make a new table
            HashTable kush = new HashTable();
            //read from the file
            int lines = Integer.parseInt(KBreader.readLine());
            for(int i = 0; i < lines; i++){
                Scanner l = new Scanner(KBreader.readLine());
                //load stuff into the table
                Number next = new Number(l.nextInt());
                //Word next = new Word(l.next());
                kush.add(next);
            }
            //print out the table
            System.out.println(kush);
        }
        catch(Exception e)
        {
            System.out.println("Houston, we have a problem!");
        }
  }
}