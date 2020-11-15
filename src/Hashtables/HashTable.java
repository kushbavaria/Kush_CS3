package Hashtables;

import static java.lang.System.*;
import java.util.LinkedList;
import java.util.Scanner; 
public class HashTable
{
    private LinkedList[] table;
    public HashTable(){
        table = new LinkedList[10];
        for(int i = 0; i < table.length; i++){
            table[i] = new LinkedList();
        }
    }
    public void add(Object obj){
        int i = obj.hashCode() % 10;
        if(!table[i].contains(obj)){
            table[i].add(obj);
        }
    }
    public String toString(){
        String output="HASHTABLE\n";
        for(int i = 0; i < table.length; i++){
            output += "bucket " + i + " ";
            for(int j = 0; j < table[i].size(); j++){
                output += table[i].get(j) + " ";
            }
            output+= "\n";
        }
        return output;
    }
}