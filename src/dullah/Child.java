package dullah;

public class Child implements Comparable<Child>
{
    private int age;
    private int niceLevel;
    private String name;
    private String street;
    
    public Child(int a, String n, String s){
        age = a;
        niceLevel = 0;
        name = n;
        street = s;
    }
    
    public int getAge(){
        return age;
    }
    public int getNiceLevel(){
        return niceLevel;
    }
    public String getName(){
        return name;
    }
    public String getStreet(){
        return street;
    }
    public void setNiceLevel(int n){
        niceLevel = n;
    }
    
    public int compareTo(Child rapper){
        if(niceLevel > rapper.getNiceLevel()){
            return -1;
        }
        else if(niceLevel == rapper.getNiceLevel()){
            return 0;
        }
        else{
            return 1;
        }
           
    }
    public String toString(){
        return name + " is " + age + " years old and has a nice level of " + niceLevel + " and live on " + street;
    }
}
