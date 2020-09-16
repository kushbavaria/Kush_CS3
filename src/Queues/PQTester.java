package Queues;//A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  

import java.util.Queue;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PQTester
{
    private PriorityQueue<String> pQueue;

    public PQTester()
    {

        setPQ("");
    }

    public PQTester(String list)
    {

        setPQ(list);
    }

    public void setPQ(String list)
    {
        pQueue = new PriorityQueue<String>();
        
        Scanner word = new Scanner(list);
        while(word.hasNext())
            pQueue.add(word.next());
    }
    
    public Object getMin()
    {

        return pQueue.peek();
    }
    
    public String getNaturalOrder()
    {
        String output="";
        while(!pQueue.isEmpty())
            output += pQueue.remove() + " ";
        return output;      
    }

    public String toString(){
        return "toString() - "+ pQueue.toString() + "\ngetMin() - " + getMin() + "\ngetNaturalOrder - " + getNaturalOrder() + "\n";
    }
}