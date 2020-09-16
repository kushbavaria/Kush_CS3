package Stack;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.util.Stack;
import java.util.ArrayList;
import static java.lang.System.*;

public class SyntaxChecker
{
    private String exp;
    private Stack<Character> symbols;

    public SyntaxChecker()
    {

        setExpression("");
    }

    public SyntaxChecker(String s)
    {

        setExpression(s);
    }
    
    public void setExpression(String s)
    {
        exp = s;
        ArrayList<Character> symbolsReverse = new ArrayList<Character>();
        for(Character x: s.toCharArray())
            symbolsReverse.add(0,x);
        symbols = new Stack<Character>();
        symbols.addAll(symbolsReverse);
    }

    public boolean checkExpression()
    {
        Stack<Character> groups = new Stack<Character>();
        
        while(!symbols.isEmpty()){
            Character x = symbols.pop();
            if(("{(<[").indexOf(x) != -1)
                   groups.push(x);
             else if(("]>)}").indexOf(x) != -1)
                 if(!groups.isEmpty()){
                    if(groups.pop() == x)
                        return false;
                }
                 else
                    return false;
        }
         return groups.isEmpty();
    }

     public String toString(){

        return exp + (checkExpression() ? " is correct" : " is incorrect") + "\n" ;
    }
}