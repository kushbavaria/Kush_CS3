package Queues;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

//ArrayList of ints
//or
//array of ints

import java.util.ArrayList;
import static java.lang.System.*;

public class IntQueue
{
    //pick your storage for the queue
    //you can use the an array or an ArrayList

    //option 1
    private int[] rayOfInts;

    public IntQueue()
    {

        rayOfInts = new int[0];
    }

    public void add(int item)
    {
        int[] new1 = new int[rayOfInts.length+1];
        for(int i = 0; i < rayOfInts.length; i++)
            new1[i] = rayOfInts[i];
        new1[new1.length-1] = item;
        rayOfInts = new1;
    }

    public int remove()
    {
        int[] new1 = new int[rayOfInts.length-1];
        for(int i = 1; i < rayOfInts.length; i++)
            new1[i-1] = rayOfInts[i];
        int num = rayOfInts[0];
        rayOfInts = new1;
        return num;
    }

    public boolean isEmpty()
    {

        return rayOfInts.length == 0;
    }

    public int peek()
    {

        return rayOfInts[0];
    }

    public String toString()
    {
        String queue = "";
        for(int i = 0; i < rayOfInts.length; i++)
            if(i != rayOfInts.length-1)
                queue += rayOfInts[i] + ", ";
            else
                queue += rayOfInts[i];
        return "[" + queue + "]";
    }
}