package Stack;//� A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class -
//Lab  -

//ArrayList of ints
//or
//array of ints

import java.util.ArrayList;
import static java.lang.System.*;

public class IntStack
{
    //pick your storage for the stack
    //you can use the an array or an ArrayList

    //option 1
    private int[] rayOfInts;

    //option 2
    private ArrayList<Integer> listOfInts;

    public IntStack()
    {
        rayOfInts = new int[0];
    }

    public void push(int item)
    {
        int[] newRay = new int[rayOfInts.length+1];
        for(int i = 0; i < rayOfInts.length; i++)
            newRay[i] = rayOfInts[i];
        newRay[newRay.length-1] = item;
        rayOfInts = newRay;
    }

    public int pop()
    {
        int[] newRay = new int[rayOfInts.length-1];
        for(int i = 0; i < newRay.length; i++)
            newRay[i] = rayOfInts[i];
        int item = rayOfInts[rayOfInts.length-1];
        rayOfInts = newRay;
        return item;
    }

    public boolean isEmpty()
    {
        return rayOfInts.length == 0;
    }

    public int peek()
    {
        return rayOfInts[rayOfInts.length-1];
    }

    public String toString()
    {
        String stack = "";
        for(int i = 0; i < rayOfInts.length; i++)
            if(i != rayOfInts.length-1)
                stack += rayOfInts[i] + ", ";
            else
                stack += rayOfInts[i];
        return "[" + stack + "]";
    }
}