package Hashtables;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class Number
{
    private int theValue;
    public Number(int value){
        theValue = value;
    }   
    public int getValue(){
        return theValue;
    }
    public boolean equals(Object obj){
        if(theValue != ((Number)obj).getValue()){
            return false;
        }
        return true;
    } 
    public int hashCode(){
        return theValue;
    }
    public String toString(){
        return "" + theValue;
    }   
}