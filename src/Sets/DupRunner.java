package Sets;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.*;

public class DupRunner
{
	public static void main( String args[] )
	{
	    String one = "a b c d e f g h a b c d e f g h i j k";
	    String two = "one two three one two three six seven one two";
	    
	    System.out.println("\nOriginal List : " + one);
	    System.out.println("Uniques : " + UniquesDupes.getUniques(one));
	    System.out.println("Dupes : " + UniquesDupes.getDupes(one));
	    
	    System.out.println("\nOriginal List : " + two);
	    System.out.println("Uniques : " + UniquesDupes.getUniques(two));
	    System.out.println("Dupes : " + UniquesDupes.getDupes(two));

	}
}