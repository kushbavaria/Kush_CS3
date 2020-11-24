package Sets;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets
{
    private Set<Integer> odd;
    private Set<Integer> even;

    public OddEvenSets()
    {
        odd = new TreeSet<Integer>();
        even = new TreeSet<Integer>();
    }

    public OddEvenSets(String line)
    {
      
        even = new TreeSet<Integer>();
        odd= new TreeSet<Integer>();
        Scanner nums = new Scanner(line);
        while(nums.hasNext()){
            int currentNum = nums.nextInt();
            if((currentNum & 1)==1)
               odd.add(currentNum);
            else
               even.add(currentNum);
            }
    }

    public String toString()
    {
        
        return "\nODDS : " + odd + "\nEVENS : " + even + "\n\n\n\n";
    }
}