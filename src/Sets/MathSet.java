package Sets;

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import static java.lang.System.*;
import java.util.Scanner;

public class MathSet
{
    private Set<Integer> numberones;
    private Set<Integer> numbertwos;

    public MathSet()
    {
        this("","");
    }

    public MathSet(String o, String t)
    {
        numberones = new TreeSet<Integer>();
        numbertwos = new TreeSet<Integer>();
        
        Scanner nums = new Scanner(o);
        while(nums.hasNext())
            numberones.add(nums.nextInt());
        
        nums = new Scanner(t);    
        while(nums.hasNext())
            numbertwos.add(nums.nextInt());
    }



    public Set<Integer> difference(Set<Integer> a, Set<Integer> b){
        Set<Integer> difference = new TreeSet<Integer>();
        
        for(Integer kb : a)
            if(!b.contains(kb))
                difference.add(kb);
        
        return difference;
    }
    public Set<Integer> union()
    {
        Set<Integer> union = new TreeSet<Integer>();

        for(Integer kb : numberones)
            union.add(kb);

        for(Integer kb : numbertwos)
            union.add(kb);
        return union;
    }

    public Set<Integer> intersection()
    {
        Set<Integer> union = new TreeSet<Integer>();
        Set<Integer> intersection = new TreeSet<Integer>();

        for(Integer kb : numberones)
            if(!union.add(kb))
                intersection.add(kb);

        for(Integer kb : numbertwos)
            if(!union.add(kb))
                intersection.add(kb);

        return intersection;
    }

    public Set<Integer> differenceAMinusB()
    {
        return difference(numberones,numbertwos);
    }

    public Set<Integer> differenceBMinusA()
    {
        return difference(numbertwos,numberones);
    }
	
    public Set<Integer> symmetricDifference()
    {		
    	return difference(union(), intersection());
    }	
	
    public String toString()
    {
    	return "Set numberones " + numberones + "\n" +	"Set numbertwos " + numbertwos +  "\n" + operations();
    }
    
    public String operations(){
        return "\nunion - " + union() + "\nintersection - " + intersection() + "\ndifference A-B - " + differenceAMinusB() + "\ndifference B-A - " + differenceBMinusA() + "\nsymmetric difference " + symmetricDifference() + "\n";
    }
}