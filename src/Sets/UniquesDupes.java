package Sets;

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;

public class UniquesDupes
{


    public static Set<String> getDupes(String input)
    {
        Set<String> uniques = new TreeSet<String>();
        Set<String> dupes = new TreeSet<String>();
        String[] allwords = input.split(" ");

        
        for(String kb: allwords)
            if(!uniques.add(kb))
               dupes.add(kb);
        
        
        return dupes;
    }

    public static Set<String> getUniques(String input)
    {
        Set<String> uniques = new TreeSet<String>();
        String[] allwords = input.split(" ");


        for(String kb: allwords)
            uniques.add(kb);

        return uniques;
    }
}