package Hashtables;

public class Word
{
    private String theValue;
    //write a constructor method
    public Word(String x){
        theValue = x;
    }
    //write the getValue method
    public String getValue(){
        return theValue;
    }
    //write the equals method
    public boolean equals(Object obj){
        return theValue.equals(((Word)obj).getValue());
    }
    //write the hashCode method
    public int hashCode(){
    String vowels = "kushiscool";
    int vowelCount = 0;
    for(int i = 0;i<theValue.length();i++){
        if(vowels.indexOf(theValue.substring(i,i+1))!=-1){
                vowelCount++;
        }
    }
    vowelCount*=theValue.length();
    return vowelCount % 10;
    }
    //write the toString method
    public String toString(){
        return theValue.toString();
    }
}